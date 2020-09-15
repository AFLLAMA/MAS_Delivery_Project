package mas.delivery.repo;

import mas.delivery.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CompanyRepo extends CrudRepository<Company, Long> {
    @Query("select c from Company c join fetch c.products where c.companyId = :id")
    public Optional<Company> findById(@Param("id") Long id);



    @Override
    List<Company> findAll();
}