package mas.delivery.repo;

import mas.delivery.CatalogueOfCompanies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional

public interface CatalogueOfCompaniesRepo<T extends CatalogueOfCompanies> extends CrudRepository<T, Long> {

}
