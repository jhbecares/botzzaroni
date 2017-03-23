package botzzaroni.service;

import botzzaroni.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
