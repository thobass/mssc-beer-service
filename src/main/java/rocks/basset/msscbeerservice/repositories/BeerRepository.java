package rocks.basset.msscbeerservice.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import rocks.basset.msscbeerservice.domain.Beer;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
