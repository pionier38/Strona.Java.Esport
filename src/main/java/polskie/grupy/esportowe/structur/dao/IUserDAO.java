package polskie.grupy.esportowe.structur.dao;

import polskie.grupy.esportowe.structur.model.User;

import java.util.Optional;

public interface IUserDAO {
    Optional<User> getUserByLogin(String login);
    void persistUser(User user);
}
