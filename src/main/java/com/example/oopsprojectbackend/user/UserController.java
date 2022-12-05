package com.example.oopsprojectbackend.user;

import com.example.oopsprojectbackend.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "oops/api/user")
    @CrossOrigin("http://localhost:3000/")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @RequestMapping(path = "oops/api/user/{uid}")
    @CrossOrigin("http://localhost:3000/")
    public Optional<User> getUserFromId(@PathVariable Long uid){return userService.getUserbyId(uid);
    }

    @RequestMapping(path = "oops/api/user", method = RequestMethod.POST)
    @CrossOrigin("http://localhost:3000/")
    public User registerNewUser(@RequestBody User user) {
        User usera = userService.addNewUser(user);
        return usera;
    }

    @RequestMapping(path = "oops/api/user/login", method = RequestMethod.POST)
    @CrossOrigin("http://localhost:3000/")
    public Optional<User> login(@RequestBody User user) {
        Optional<User> usera = userService.login(user.getEmail(), user.getPassword());
        return usera;
    }

    @RequestMapping(path = "oops/api/user/delete", method = RequestMethod.DELETE)
    @CrossOrigin("http://localhost:3000/")
    public void deleteUsr(@RequestBody User user) {
        userService.deleteUser(user.getId());
    }
}
