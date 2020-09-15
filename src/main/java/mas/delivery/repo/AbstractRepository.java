package mas.delivery.repo;

import mas.delivery.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractRepository<T extends User>
        extends CrudRepository<T, Long> {

    @Query("select e from #{#entityName} as e from equipment where e.name = equipmentName")
    T findEquipmentByName(String equipmentName);

}