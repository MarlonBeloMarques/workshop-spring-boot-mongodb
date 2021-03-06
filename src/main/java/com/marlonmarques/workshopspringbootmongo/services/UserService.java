package com.marlonmarques.workshopspringbootmongo.services;

import com.marlonmarques.workshopspringbootmongo.domain.User;
import com.marlonmarques.workshopspringbootmongo.dto.UserDTO;
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

    public User insert(User obj) {
        return repository.insert(obj);
    }

    public User update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
