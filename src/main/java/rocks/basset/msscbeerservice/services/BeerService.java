package rocks.basset.msscbeerservice.services;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import rocks.basset.msscbeerservice.web.model.BeerDto;
import rocks.basset.msscbeerservice.web.model.BeerPagedList;
import rocks.basset.msscbeerservice.web.model.BeerStyleEnum;

import java.util.UUID;

public interface BeerService {

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, boolean showInventoryOnHand);

    BeerDto getById(UUID beerId, boolean showInventoryOnHand);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    BeerDto getByUpc(String upc);
}
