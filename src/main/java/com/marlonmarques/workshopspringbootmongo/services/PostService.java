package com.marlonmarques.workshopspringbootmongo.services;

import com.marlonmarques.workshopspringbootmongo.domain.Post;
import com.marlonmarques.workshopspringbootmongo.domain.User;
import com.marlonmarques.workshopspringbootmongo.repository.PostRepository;
import com.marlonmarques.workshopspringbootmongo.repository.UserRepository;
import com.marlonmarques.workshopspringbootmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
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

    public List<Post> findByTitle(String text) {
        return repository.findByTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repository.fullSearch(text, minDate, maxDate);
    }
}
