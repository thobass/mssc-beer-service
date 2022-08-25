package guru.sfg.springframework.msscbeerservice.web.mapper;

import guru.sfg.brewery.model.BeerDto;
import guru.sfg.springframework.msscbeerservice.domain.Beer;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);

    BeerDto beerToBeerDtoWithInventory(Beer beer);
}
