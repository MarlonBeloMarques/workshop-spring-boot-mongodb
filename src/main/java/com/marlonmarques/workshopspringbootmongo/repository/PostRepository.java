package com.marlonmarques.workshopspringbootmongo.repository;

import com.marlonmarques.workshopspringbootmongo.domain.Post;
import com.marlonmarques.workshopspringbootmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text);
}
