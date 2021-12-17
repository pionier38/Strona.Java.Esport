package polskie.grupy.esportowe.structur.services.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import polskie.grupy.esportowe.structur.dao.IUserDAO;
import polskie.grupy.esportowe.structur.model.User;
import polskie.grupy.esportowe.structur.services.IAuthenticationService;
import polskie.grupy.esportowe.structur.session.SessionObject;
import polskie.grupy.esportowe.structur.validator.Validator;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class AuthenticationService implements IAuthenticationService {

    @Autowired
    IUserDAO userDAO;

    @Resource
    SessionObject sessionObject;

    @Override
    public void authenticate(String login, String password) {
        Optional<User> userBox = this.userDAO.getUserByLogin(login);

        if(!userBox.isPresent()) {
            return;
        }

        if(userBox.get().getPass().equals(DigestUtils.md5Hex(password))) {
            this.sessionObject.setUser(userBox.get());
        }
    }

    @Override
    public void register(String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPass(DigestUtils.md5Hex(password));
        user.setPrivileges(User.Privileges.USER);

        this.userDAO.persistUser(user);

        this.sessionObject.setUser(user);
    }
}
