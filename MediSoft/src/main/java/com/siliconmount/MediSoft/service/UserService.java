package com.siliconmount.MediSoft.service;

import com.siliconmount.MediSoft.entity.User;
import com.siliconmount.MediSoft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    private List<User> store = new ArrayList<>();
//
//    public UserService(){
//        store.add(new User(UUID.randomUUID().toString(),"jidnyasa","jidnyasa@gmail.com","Admin","Jidnyasa Patil"));
//    }

    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    public  User createUser(User user){
        user.setId(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);

    }


}
