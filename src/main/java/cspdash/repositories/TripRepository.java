package cspdash.repositories;

import org.springframework.data.repository.CrudRepository;

import cspdash.models.Trip;

public interface TripRepository extends CrudRepository<Trip, Long> {

}
