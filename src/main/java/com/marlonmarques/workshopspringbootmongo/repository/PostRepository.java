package com.marlonmarques.workshopspringbootmongo.repository;

import com.marlonmarques.workshopspringbootmongo.domain.Post;
import com.marlonmarques.workshopspringbootmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
