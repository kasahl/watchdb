package serverproject.watchdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import serverproject.watchdb.domain.User;
import serverproject.watchdb.domain.UserRepository;
import serverproject.watchdb.domain.Watch;
import serverproject.watchdb.domain.WatchRepository;

@SpringBootApplication
public class WatchdbApplication {
	private static final Logger log = LoggerFactory.getLogger(WatchdbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WatchdbApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner watchPlaceholder(WatchRepository repository, UserRepository urepository) {
		return (args) -> {
			 log.info("save some watches");
			
			repository.save(new Watch("Rolex", "Submariner", 2020, "Steel"));
			repository.save(new Watch("Omega", "Seamaster 300m", 2019, "Steel"));	
			
			urepository.deleteAll();
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all watches");
			for (Watch watch : repository.findAll()) {
				log.info(watch.toString());
			
			}
		}; 
	}
}

