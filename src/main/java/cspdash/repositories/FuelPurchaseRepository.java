package org.wecancodeit.fleettracker.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.fleettracker.models.FuelPurchase;

public interface FuelPurchaseRepository extends CrudRepository<FuelPurchase, Long> {

}
