package cspdash.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import cspdash.models.Truck;

public interface TruckRepository extends CrudRepository<Truck, Long> {

	Optional<Truck> findByTruckNumber(String truckNumber);

}
