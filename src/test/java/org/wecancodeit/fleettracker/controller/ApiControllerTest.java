package org.wecancodeit.fleettracker.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import cspdash.controller.ApiController;
import cspdash.models.Company;
import cspdash.models.Employee;
import cspdash.models.Trip;
import cspdash.models.Truck;

@RunWith(SpringRunner.class)
@WebMvcTest(ApiController.class)
public class ApiControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ApiController apiController;

	@Test
	public void shouldGetTruck() throws Exception {
		Truck truck = new Truck();
		Set<Truck> trucks = Collections.singleton(truck);

		given(apiController.getTrucks()).willReturn(trucks);
		mvc.perform(get("/api/trucks").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].plateNumber", is(truck.getPlateNumber())));
	}

	@Test
	public void shouldGetTrip() throws Exception {
		Trip trip = new Trip();
		Set<Trip> trips = Collections.singleton(trip);

		given(apiController.getTrips()).willReturn(trips);
		mvc.perform(get("/api/trips").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].tripNumber", is(trip.getTripNumber())));
	}

	@Test
	public void shouldGetEmployee() throws Exception {
		Employee employee = new Employee();
		Set<Employee> employees = Collections.singleton(employee);

		given(apiController.getEmployees()).willReturn(employees);
		mvc.perform(get("/api/employees").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].fedexId", is(employee.getFedexId())));
	}

	@Test
	public void shouldGetEntityId() throws Exception {
		Company company = new Company("", "", "", "", "", "", "", "", "");
		Set<Company> companies = Collections.singleton(company);

		System.out.println(company.getAuthOfficerId());

		given(apiController.getCompanies()).willReturn(companies);
		mvc.perform(get("/api/companies").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].getEntityId", is(equalTo(company.getEntityId()))));
	}

}
