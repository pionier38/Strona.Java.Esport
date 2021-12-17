package pl.edu.zse.gry.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.edu.zse.gry.model.User;

@Component
@SessionScope
public class SessionObject {
    private User user = null;

    public boolean isLogged() {
        return user != null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
