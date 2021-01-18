package com.marlonmarques.workshopspringbootmongo.services;

import com.marlonmarques.workshopspringbootmongo.domain.User;
import com.marlonmarques.workshopspringbootmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return  repository.findAll();
    }
}
