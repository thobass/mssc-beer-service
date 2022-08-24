package rocks.basset.msscbeerservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import rocks.basset.msscbeerservice.config.JmsConfig;
import rocks.basset.msscbeerservice.domain.Beer;
import rocks.basset.msscbeerservice.events.BrewBeerEvent;
import rocks.basset.msscbeerservice.repositories.BeerRepository;
import rocks.basset.msscbeerservice.services.inventory.BeerInventoryService;
import rocks.basset.msscbeerservice.web.mapper.BeerMapper;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrewingService {
    private final BeerRepository beerRepository;
    private final BeerInventoryService beerInventoryService;
    private final JmsTemplate jmsTemplate;
    private final BeerMapper beerMapper;

    @Scheduled(fixedRate = 5000)
    public void checkForLowInventory() {
        List<Beer> beers = beerRepository.findAll();

        beers.forEach(beer -> {
            Integer invQOH = beerInventoryService.getOnhandInventory(beer.getId());

            log.debug("Min on hand is: " + beer.getMinOnHand());
            log.debug("Inventory is: " + invQOH);

            if (beer.getMinOnHand() >= invQOH) {
                jmsTemplate.convertAndSend(JmsConfig.BREWERY_REQUEST_QUEUE, new BrewBeerEvent((beerMapper.beerToBeerDto(beer))));
            }
        });
    }
}
