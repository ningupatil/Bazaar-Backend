package org.bazaarBackend.User.Service;

import org.bazaarBackend.User.Models.User;
import org.bazaarBackend.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    public User createUser(User user) {
        User u = userRepo.createUser(user);
        return u;
    }

    public User getUser(User userDetails) {
        User u = userRepo.getUser(userDetails);
        return u;
    }
}
