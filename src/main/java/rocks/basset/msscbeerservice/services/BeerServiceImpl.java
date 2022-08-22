package rocks.basset.msscbeerservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rocks.basset.msscbeerservice.domain.Beer;
import rocks.basset.msscbeerservice.repositories.BeerRepository;
import rocks.basset.msscbeerservice.web.controller.NotFoundException;
import rocks.basset.msscbeerservice.web.mapper.BeerMapper;
import rocks.basset.msscbeerservice.web.model.BeerDto;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getById(UUID beerId) {
        return beerMapper.beerToBeerDto(
                beerRepository.findById(beerId).orElseThrow(NotFoundException::new)
        );
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return beerMapper.beerToBeerDto(
                beerRepository.save(beerMapper.beerDtoToBeer(beerDto))
        );
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);
        beer.setBeerStyle(beer.getBeerStyle());
        beer.setUpc(beer.getUpc());
        beer.setBeerName(beer.getBeerName());
        beer.setPrice(beer.getPrice());
        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }
}
