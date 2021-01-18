package com.marlonmarques.workshopspringbootmongo.services;

import com.marlonmarques.workshopspringbootmongo.domain.Post;
import com.marlonmarques.workshopspringbootmongo.domain.User;
import com.marlonmarques.workshopspringbootmongo.repository.PostRepository;
import com.marlonmarques.workshopspringbootmongo.repository.UserRepository;
import com.marlonmarques.workshopspringbootmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id)  {
        Optional<Post> post = repository.findById(id);
        post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id
                + ", Tipo: " + Post.class.getName()));

        return post.get();
    }
}
