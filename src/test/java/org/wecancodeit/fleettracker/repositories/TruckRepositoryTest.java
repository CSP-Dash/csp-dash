package org.wecancodeit.fleettracker.repositories;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import cspdash.models.Truck;
import cspdash.repositories.TruckRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TruckRepositoryTest {

	@Resource
	TruckRepository truckRepo;

	@Test
	public void shouldReturnAllTrips() {
		Truck truckOne = truckRepo.save(new Truck());
		Truck truckTwo = truckRepo.save(new Truck());

		Iterable<Truck> result = truckRepo.findAll();

		assertThat(result, hasItems(truckOne, truckTwo));
	}

	@Test
	public void shouldReturnOneTrip() {
		Truck truckThree = truckRepo.save(new Truck());

		Truck result = truckRepo.findById(truckThree.getId()).get();

		assertThat(result, is(truckThree));
	}
}