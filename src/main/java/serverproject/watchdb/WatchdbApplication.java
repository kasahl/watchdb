package serverproject.watchdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import serverproject.watchdb.domain.Watch;
import serverproject.watchdb.domain.WatchRepository;

@SpringBootApplication
public class WatchdbApplication {
	private static final Logger log = LoggerFactory.getLogger(WatchdbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WatchdbApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner watchPlaceholder(WatchRepository repository) {
		return (args) -> {
			 log.info("save some watches");
			
			repository.save(new Watch("Rolex", "Submariner", 2020, "https://content.rolex.com/dam/new-watches-2020/new-submariner/new-submariner-m124060-0001-search.jpg"));
			repository.save(new Watch("Omega", "Seamaster", 2019, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTOQ3XAHgFWO3qUuwLhCYEfYUyc7BIVxf1GGw&usqp=CAU"));	
			
			log.info("fetch all watches");
			for (Watch watch : repository.findAll()) {
				log.info(watch.toString());
			
			}
		}; 
	}
}

