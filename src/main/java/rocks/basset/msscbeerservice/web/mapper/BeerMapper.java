package rocks.basset.msscbeerservice.web.mapper;

import org.mapstruct.Mapper;
import rocks.basset.msscbeerservice.domain.Beer;
import rocks.basset.msscbeerservice.web.model.BeerDto;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}