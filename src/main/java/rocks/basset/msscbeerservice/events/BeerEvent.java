package rocks.basset.msscbeerservice.events;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import rocks.basset.msscbeerservice.web.model.BeerDto;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
@Builder
public class BeerEvent implements Serializable {

    private static final long serialVersionUID = 6028418388539775830L;

    private final BeerDto beerDto;
}
