package pl.edu.zse.gry.dao;

import pl.edu.zse.gry.model.User;

import java.util.Optional;

public interface IUserDAO {
    Optional<User> getUserByLogin(String login);
    void persistUser(User user);
}
