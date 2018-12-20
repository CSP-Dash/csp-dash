package org.wecancodeit.fleettracker.repositories;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import cspdash.models.Employee;
import cspdash.repositories.EmployeeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

	@Resource
	EmployeeRepository employeeRepo;

	@Test
	public void shouldReturnAllEmployees() {
		Employee employeeOne = employeeRepo.save(new Employee());
		Employee employeeTwo = employeeRepo.save(new Employee());

		Iterable<Employee> result = employeeRepo.findAll();

		assertThat(result, hasItems(employeeOne, employeeTwo));
	}

	@Test
	public void shouldReturnOneEmployee() {
		Employee employeeThree = employeeRepo.save(new Employee());

		Employee result = employeeRepo.findById(employeeThree.getId()).get();

		assertThat(result, is(employeeThree));
	}
}
