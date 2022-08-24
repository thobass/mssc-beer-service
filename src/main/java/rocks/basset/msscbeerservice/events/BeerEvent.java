package rocks.basset.msscbeerservice.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rocks.basset.msscbeerservice.web.model.BeerDto;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerEvent implements Serializable {

    private static final long serialVersionUID = 6028418388539775830L;

    private BeerDto beerDto;
}
