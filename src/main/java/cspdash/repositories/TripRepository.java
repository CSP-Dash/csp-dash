package org.wecancodeit.fleettracker.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.fleettracker.models.Trip;

public interface TripRepository extends CrudRepository<Trip, Long> {

}
