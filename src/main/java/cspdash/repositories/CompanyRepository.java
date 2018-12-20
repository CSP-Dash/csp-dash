package cspdash.repositories;

import org.springframework.data.repository.CrudRepository;

import cspdash.models.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {

}
