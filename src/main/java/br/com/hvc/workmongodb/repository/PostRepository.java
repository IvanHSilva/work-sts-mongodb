package br.com.hvc.workmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.hvc.workmongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
}
