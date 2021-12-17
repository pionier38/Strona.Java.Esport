package polskie.grupy.esportowe.structur.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import polskie.grupy.esportowe.structur.model.User;

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
