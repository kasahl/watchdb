package serverproject.watchdb.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface WatchRepository extends CrudRepository<Watch, Long>{
	List<Watch> findByBrand(@Param("brand") String brand);
}
