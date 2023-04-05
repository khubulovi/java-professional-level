package lesson3.Auntetication;



import lesson3.User.User;

import java.util.ArrayList;
import java.util.List;

public class AuthenticationService {
    private final static List<User> users = new ArrayList<>();

    public AuthenticationService() {
        users.add(new User("user1", "password1"));
        users.add(new User("user2", "password2"));
        users.add(new User("user3", "password3"));
        users.add(new User("user4", "password4"));
    }

    public User doAuthentication(String nick, String password) {
        for (User user : users) {
            if (user.getNick().equals(nick) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
