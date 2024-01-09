package com.siliconmount.MediSoft.controller;

import com.siliconmount.MediSoft.entity.User;
import com.siliconmount.MediSoft.model.JwtRequest;
import com.siliconmount.MediSoft.model.JwtResponse;
import com.siliconmount.MediSoft.security.JwtHelper;
import com.siliconmount.MediSoft.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtHelper helper;

    @Autowired
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request){
        this.doAuthenticate(request.getUsername(),request.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());

        String token = this.helper.generateToken(userDetails);
//        System.out.println(token);

        JwtResponse response= JwtResponse.builder()
                .token(token)
                .username(userDetails.getUsername()).build();
        return  new ResponseEntity<>(response, HttpStatus.OK);
//        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void doAuthenticate(String username, String password) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
        try{
            authenticationManager.authenticate(authentication);
        }
        catch (BadCredentialsException e){
            throw new RuntimeException("Invalid Username or Password!");
        }
    }
    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler(){
        return "Credentials Invalid";
    }


    @PostMapping("/registration")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

}
