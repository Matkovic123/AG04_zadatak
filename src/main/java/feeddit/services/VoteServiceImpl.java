package feeddit.services;

import feeddit.entities.Vote;
import feeddit.repositories.ArticleRepository;
import feeddit.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Matkovic on 31.3.2017..
 */
@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    VoteRepository voteRepository;


    @Override
    public Vote saveVote(Vote vote) {

        return voteRepository.save(vote);
    }

    @Override
    public Iterable<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    @Override
    public void deleteVote(Long id) {
        voteRepository.delete(id);
    }


}
