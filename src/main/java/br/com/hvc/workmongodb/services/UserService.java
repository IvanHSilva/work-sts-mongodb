package br.com.hvc.workmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hvc.workmongodb.domain.User;
import br.com.hvc.workmongodb.dto.UserDTO;
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
	
	public User insert(User user) {
		return rep.insert(user);
	}
	
	public void delete(String id) {
		findById(id);
		rep.deleteById(id);
	}
	
	public User update(User user) {
		User newUser = findById(user.getId());
		updateData(newUser, user);
		return rep.save(newUser);
	}
	
	private void updateData(User newUser, User user) {
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
}
