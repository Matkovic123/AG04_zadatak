package feeddit.services;

import feeddit.entities.Users;
import feeddit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Matkovic on 31.3.2017..
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Iterable<Users> getAllUsers() {
        return userRepository.findAll();
    }

}
