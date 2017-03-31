package feeddit.repositories;

import feeddit.entities.Vote;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Matkovic on 31.3.2017..
 */
public interface VoteRepository extends CrudRepository<Vote,Long>{
}
