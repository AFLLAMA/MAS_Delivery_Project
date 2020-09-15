package mas.delivery.services;

import mas.delivery.User;
import mas.delivery.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl {
    @Autowired
    private UserRepo userRepo;

    public CustomerServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getCustomers(){
//        System.out.println(userRepo.findAll());
        List<User> users = new ArrayList<>();
        userRepo.findAll().iterator().forEachRemaining(e -> users.add((User) e));
        System.out.println(users);
        return users;
    }

    public User getCustomerById(Long id){
        return (User) userRepo.findById(id).get();
    }
}
