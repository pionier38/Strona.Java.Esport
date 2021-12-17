package polskie.grupy.esportowe.structur.services;

public interface IAuthenticationService {
    void authenticate(String login, String password);
    void register(String login, String password);
}
