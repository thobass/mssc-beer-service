package rocks.basset.msscbeerservice.events;

import lombok.NoArgsConstructor;
import rocks.basset.msscbeerservice.web.model.BeerDto;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent {

    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
