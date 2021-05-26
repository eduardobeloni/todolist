package todolist.hello;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer>{

	public List<User> findByName(@Param("name") String name);
}
