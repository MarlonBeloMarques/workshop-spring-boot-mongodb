package com.marlonmarques.workshopspringbootmongo.services;

import com.marlonmarques.workshopspringbootmongo.domain.User;
import com.marlonmarques.workshopspringbootmongo.repository.UserRepository;
import com.marlonmarques.workshopspringbootmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return  repository.findAll();
    }

    public User findById(String id)  {
        Optional<User> user = repository.findById(id);
        user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id
                + ", Tipo: " + User.class.getName()));

        return user.get();
    }
}
