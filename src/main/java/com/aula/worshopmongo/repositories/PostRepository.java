package com.aula.worshopmongo.repositories;

import com.aula.worshopmongo.domain.Post;
import com.aula.worshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
