package org.wecancodeit.fleettracker.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.fleettracker.models.Truck;

public interface TruckRepository extends CrudRepository<Truck, Long> {

	Optional<Truck> findByTruckNumber(String truckNumber);

}
