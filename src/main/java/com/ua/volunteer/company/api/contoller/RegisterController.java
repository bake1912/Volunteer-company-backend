package com.ua.volunteer.company.api.contoller;


import com.ua.volunteer.company.entity.UserLogin;
import com.ua.volunteer.company.entity.UserRegister;
import com.ua.volunteer.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/volunteers/register")
    public UserRegister createUser(@RequestBody UserRegister user){
       return userRepository.register(user);
    }
    @PostMapping("/volunteers/login")
    public UserRegister getUser(@RequestBody UserLogin user){
        return userRepository.getUser(user);
    }

}
