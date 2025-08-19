package com.example.cours3_ch4.user.service;

import com.example.cours3_ch4.user.db.UserRepository;
import com.example.cours3_ch4.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {// android 클린아키텍츠의 usecase 인듯

    private final UserRepository userRepository;
    public UserEntity save(UserEntity user){
        return userRepository.save(user);
    }

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public void delete(Long id){
        userRepository.delete(id);
    }

    public Optional<UserEntity> findById(Long id){
        return userRepository.findById(id);
    }
}
