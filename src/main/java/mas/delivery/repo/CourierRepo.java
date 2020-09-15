package mas.delivery.repo;

import mas.delivery.Courier;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface CourierRepo <T extends Courier> extends CrudRepository<T, Long> {
}