package feeddit.services;

import feeddit.entities.Users;

/**
 * Created by Matkovic on 31.3.2017..
 */
public interface UserService {

    public Iterable<Users> getAllUsers();
}
