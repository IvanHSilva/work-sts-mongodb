package br.com.hvc.workmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.hvc.workmongodb.domain.Post;
import br.com.hvc.workmongodb.domain.User;
import br.com.hvc.workmongodb.dto.AuthorDTO;
import br.com.hvc.workmongodb.repository.PostRepository;
import br.com.hvc.workmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRep;

	@Autowired
	private PostRepository postRep;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRep.deleteAll();
		User u1 = new User(null, "Maria José", "maria@gmail.com");
		User u2 = new User(null, "José Antônio", "jose@gmail.com");
		User u3 = new User(null, "Teresa Raquel", "teresa@gmail.com");
		User u4 = new User(null, "Michael Jordan", "micahael@gmail.com");
		User u5 = new User(null, "Helo Pinho", "helo@gmail.com");
		userRep.saveAll(Arrays.asList(u1, u2, u3, u4, u5));
		
		postRep.deleteAll();
		Post p1 = new Post(null, sdf.parse("21/03/2019"), "Partiu viagem", "Vou viajar para Campinas. Abaços!", new AuthorDTO(u1));
		Post p2 = new Post(null, sdf.parse("25/03/2019"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(u1));
		postRep.saveAll(Arrays.asList(p1, p2));
	}
}
