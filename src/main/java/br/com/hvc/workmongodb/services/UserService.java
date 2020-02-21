package br.com.hvc.workmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hvc.workmongodb.domain.User;
import br.com.hvc.workmongodb.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository rep;
	
	public List<User> findAll() {
		return rep.findAll();
	}
}
