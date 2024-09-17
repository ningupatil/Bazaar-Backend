package org.bazaarBackend.User.Service;

import org.bazaarBackend.Response.Response;
import org.bazaarBackend.User.Dtos.UserDto;
import org.bazaarBackend.User.Models.User;
import org.bazaarBackend.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    public UserDto createUser(UserDto user) {
        UserDto u = userRepo.createUser(user);
        return u;
    }

    public UserDto getUser(UserDto userDetails) {
        return userRepo.getUser(userDetails);
    }
}
