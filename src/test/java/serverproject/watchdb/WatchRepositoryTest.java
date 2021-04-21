package serverproject.watchdb;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import serverproject.watchdb.domain.Watch;
import serverproject.watchdb.domain.WatchRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class WatchRepositoryTest {
	
	@Autowired
	private WatchRepository repository;

	@Test
	public void findByBrandShouldReturnModel() {
		
		List<Watch> watches = repository.findByBrand("Rolex");
		assertThat(watches.get(0).getModel()).isEqualTo("Submariner");
	}
	
	@Test
	public void createNewWatch() {
		Watch watch = new Watch("Audemars Piguet", "Royal Oak", 2015, "Steel");
					repository.save(watch);
						assertThat(watch.getId()).isNotNull();
	}
}