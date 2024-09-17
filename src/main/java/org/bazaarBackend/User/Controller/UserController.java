package org.bazaarBackend.User.Controller;

import org.bazaarBackend.Response.Response;
import org.bazaarBackend.User.Dtos.UserDto;
import org.bazaarBackend.User.Models.User;
import org.bazaarBackend.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("user/signup")
    public UserDto createUser(@RequestBody UserDto user) {
        UserDto u = userService.createUser(user);
        return u;
    }


   @PostMapping("user/signin")
    public UserDto getUser(@RequestBody UserDto userdetails) {
        return userService.getUser(userdetails);
   }
}
