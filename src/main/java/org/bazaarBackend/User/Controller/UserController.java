package org.bazaarBackend.User.Controller;

import org.bazaarBackend.User.Models.User;
import org.bazaarBackend.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("user/signup")
    public User createUser(@RequestBody User user) {
        User u = userService.createUser(user);
        return u;
    }


   @PostMapping("user/signin")
    public User getUser(@RequestBody User userdetails) {
        User u = userService.getUser(userdetails);
        return u;
   }
}
