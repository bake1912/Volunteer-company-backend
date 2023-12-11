package com.ua.volunteer.company.api.contoller;


import com.ua.volunteer.company.entity.PhotoUser;
import com.ua.volunteer.company.entity.UserLogin;
import com.ua.volunteer.company.entity.UserRegister;
import com.ua.volunteer.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/volunteers/user")
    public List< UserRegister> getUsers(){return userRepository.getAll();
    }

    @PostMapping("/volunteers/register")
    public UserRegister createUser(@RequestBody UserRegister user){
       return userRepository.register(user);
    }

    @PostMapping("/volunteers/login")
    public UserRegister getUser(@RequestBody UserLogin user){
        return userRepository.getUser(user);
    }

    @PostMapping("/volunteers/user/{id}/photo")
    public PhotoUser postPhoto(@RequestParam("photo") MultipartFile photo, @PathVariable("id") Integer id) {
        try {
           return userRepository.uploadPhoto(id, photo.getBytes());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
}
@GetMapping("/volunteers/user/{id}/photo")
    public List<PhotoUser> getUserPhoto(@PathVariable Integer id){
        return userRepository.getPhotoUser(id);
}
}
