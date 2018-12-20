package org.wecancodeit.fleettracker.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.fleettracker.models.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {

}
