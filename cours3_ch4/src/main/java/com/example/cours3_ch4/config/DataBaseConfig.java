package com.example.cours3_ch4.config;

import com.example.cours3_ch4.user.db.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //di 인듯
public class DataBaseConfig {

    @Bean
    public UserRepository userRepository(){
        return new UserRepository();
    }
}
