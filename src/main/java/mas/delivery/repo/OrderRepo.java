package mas.delivery.repo;

import mas.delivery.DeliveryOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional

public interface OrderRepo extends CrudRepository<DeliveryOrder, Long> {
//    @Query("select d from DeliveryOrder d join User u on d.customer = u ")
//    public Optional<DeliveryOrder> findWithUserById(@Param("id") Long id);
}
