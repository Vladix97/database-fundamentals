package app.services;

import app.domains.User;

public interface UserService {

    void persist(User user);

    User findByUsername(String username);
}
