package org.wecancodeit.fleettracker.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.fleettracker.models.FedExAssignment;

public interface FedExAssignmentRepository extends CrudRepository<FedExAssignment, Long> {

}
