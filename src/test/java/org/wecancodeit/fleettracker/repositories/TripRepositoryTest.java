package org.wecancodeit.fleettracker.repositories;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import cspdash.models.Trip;
import cspdash.repositories.TripRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TripRepositoryTest {

	@Resource
	TripRepository tripRepo;

	@Test
	public void shouldReturnAllTrips() {
		Trip tripOne = tripRepo.save(new Trip());
		Trip tripTwo = tripRepo.save(new Trip());

		Iterable<Trip> result = tripRepo.findAll();

		assertThat(result, hasItems(tripOne, tripTwo));
	}

	@Test
	public void shouldReturnOneTrip() {
		Trip tripThree = tripRepo.save(new Trip());

		Trip result = tripRepo.findById(tripThree.getId()).get();

		assertThat(result, is(tripThree));
	}
}
