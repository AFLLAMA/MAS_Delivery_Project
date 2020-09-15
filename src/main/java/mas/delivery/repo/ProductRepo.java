package mas.delivery.repo;

import mas.delivery.DeliveryOrder;
import mas.delivery.Product;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional

public interface ProductRepo <T extends Product> extends CrudRepository<T, Long> {

}
