package br.com.hvc.workmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.hvc.workmongodb.domain.User;
import br.com.hvc.workmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRep;

	@Override
	public void run(String... args) throws Exception {
		
		userRep.deleteAll();
		
		User u1 = new User(null, "Maria José", "maria@gmail.com");
		User u2 = new User(null, "José Antônio", "jose@gmail.com");
		User u3 = new User(null, "Teresa Raquel", "teresa@gmail.com");
		User u4 = new User(null, "Michael Jordan", "micahael@gmail.com");
		User u5 = new User(null, "Helo Pinho", "helo@gmail.com");
		
		userRep.saveAll(Arrays.asList(u1, u2, u3, u4, u5));
	}
}
