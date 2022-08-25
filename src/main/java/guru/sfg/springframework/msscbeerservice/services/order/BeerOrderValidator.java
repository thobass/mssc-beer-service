package guru.sfg.springframework.msscbeerservice.services.order;

import guru.sfg.brewery.model.BeerOrderDto;
import guru.sfg.springframework.msscbeerservice.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
@RequiredArgsConstructor
public class BeerOrderValidator {

    private final BeerRepository beerRepository;

    public Boolean validateOrder(BeerOrderDto beerOrderDto) {
        var beersNotFound = new AtomicInteger();

        beerOrderDto.getBeerOrderLines().forEach(orderLine -> {
            if (beerRepository.findBeerByUpc(orderLine.getUpc()).isEmpty()) {
                beersNotFound.incrementAndGet();
            }
        });

        return beersNotFound.get() == 0;
    }
}
