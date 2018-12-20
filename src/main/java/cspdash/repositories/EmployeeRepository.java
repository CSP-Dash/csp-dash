package org.wecancodeit.fleettracker.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.fleettracker.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
