package org.wecancodeit.fleettracker.repositories;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import cspdash.models.Company;
import cspdash.repositories.CompanyRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CompanyRepositoryTest {

	@Resource
	CompanyRepository companyRepo;

	@Test
	public void shouldReturnAllCompanys() {
		Company companyOne = companyRepo.save(new Company());
		Company companyTwo = companyRepo.save(new Company());

		Iterable<Company> result = companyRepo.findAll();

		assertThat(result, hasItems(companyOne, companyTwo));
	}

	@Test
	public void shouldReturnOneCompany() {
		Company companyThree = companyRepo.save(new Company());

		Company result = companyRepo.findById(companyThree.getId()).get();

		assertThat(result, is(companyThree));
	}
}
