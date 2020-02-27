package br.com.hvc.workmongodb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hvc.workmongodb.domain.Post;
import br.com.hvc.workmongodb.repository.PostRepository;
import br.com.hvc.workmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository rep;
	

	public Post  findById(String id) {
		Optional<Post> p = rep.findById(id);
		return p.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
	}
}
