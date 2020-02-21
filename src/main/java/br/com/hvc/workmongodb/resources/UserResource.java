package br.com.hvc.workmongodb.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.hvc.workmongodb.domain.User;
import br.com.hvc.workmongodb.dto.UserDTO;
import br.com.hvc.workmongodb.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
//		User u1 = new User("1", "Maria José", "maria@gmail.com");
//		User u2 = new User("2", "José Maria", "jose@gmail.com");
//		List<User> list = new ArrayList<>();
//		list.addAll(Arrays.asList(u1, u2));
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()) ;
		return ResponseEntity.ok().body(listDTO);
	}
}
