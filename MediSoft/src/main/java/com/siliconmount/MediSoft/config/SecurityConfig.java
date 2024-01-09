package com.siliconmount.MediSoft.config;

import com.siliconmount.MediSoft.security.JwtAuthenticationEntryPoint;
import com.siliconmount.MediSoft.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import java.util.Date;

@Configuration
public class SecurityConfig  {

    @Autowired
    private JwtAuthenticationEntryPoint point;
    @Autowired
    private JwtAuthenticationFilter filter;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .cors(cors-> cors.disable())
                .authorizeHttpRequests(
                        auth->
                                auth.antMatchers("/home/**").authenticated()
                                        .antMatchers("/auth/login").permitAll()
                                        .antMatchers("auth/registration").permitAll()
                                        .anyRequest().authenticated())
//                                auth.antMatchers(HttpMethod.POST).hasAnyRole("ADMIN","DOCTOR","PATIENT")
//                                        .antMatchers(HttpMethod.PUT).hasAnyRole("ADMIN","PATIENT","DOCTOR")
//                                        .antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
//                                        .antMatchers(HttpMethod.GET).hasAnyRole("ADMIN","PATIENT","DOCTOR"))

                .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    @Bean
    public DaoAuthenticationProvider doDaoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

}