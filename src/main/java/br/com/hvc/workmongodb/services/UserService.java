package br.com.hvc.workmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hvc.workmongodb.domain.User;
import br.com.hvc.workmongodb.repository.UserRepository;
import br.com.hvc.workmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository rep;
	
	public List<User> findAll() {
		return rep.findAll();
	}

	public User findById(String id) {
//		User u = rep.findOne(id);
//		if (u == null) {
//			throw new ObjectNotFoundException("Usuário não encontrado!");
//		}
//		return u;
		Optional<User> u = rep.findById(id);
		return u.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
	}
}
