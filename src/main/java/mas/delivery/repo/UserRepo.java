package mas.delivery.repo;

import mas.delivery.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepo extends CrudRepository<User, Long> {
    @Query("select u from User u join fetch u.deliveryOrders where u.userId = :id")
    public Optional<User> findWithOrdersById(@Param("id") Long id);
//    List<User> findUserById(Long id);
}

