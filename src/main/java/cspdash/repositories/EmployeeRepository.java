package cspdash.repositories;

import org.springframework.data.repository.CrudRepository;

import cspdash.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
