package com.example.oopsprojectbackend.user;

import com.example.oopsprojectbackend.cartItem.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserbyId(Long id){
        return userRepository.findUserById(id);
    }

    public Optional<User> addNewUser(User user) {
            Optional<User> userOptional = userRepository.findUserById(user.getId());
            Optional<User> userOptional1 = userRepository.findUserByEmail(user.getEmail());
            if (userOptional.isPresent()) {
                throw new IllegalStateException("user exists");
            }
            if (userOptional1.isPresent()) {
                throw new IllegalStateException("email exists");
            }
            userRepository.save(user);
            Optional <User> u = login(user.getEmail(), user.getPassword());
            return u;
    }

    @Transactional
    public Optional<User> login(String email, String password){
        Optional<User> user = userRepository.checkIfExists(email, password);
        user.get().setState("in");
        return user;
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
