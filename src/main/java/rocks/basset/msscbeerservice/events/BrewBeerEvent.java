package rocks.basset.msscbeerservice.events;

import lombok.NoArgsConstructor;
import rocks.basset.msscbeerservice.web.model.BeerDto;

@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent {

    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
