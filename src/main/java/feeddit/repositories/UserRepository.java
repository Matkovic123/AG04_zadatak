package feeddit.repositories;

import feeddit.entities.Users;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Matkovic on 31.3.2017..
 */
public interface UserRepository extends CrudRepository<Users,String> {

}
