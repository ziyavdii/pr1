
package service;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class AuthService {
    private List<User> users = new ArrayList<>();

    public AuthService() {
        users.add(new Administrator("admin", "admin123"));
        users.add(new CEC("cec1", "cec123"));
        users.add(new Candidate("cand1", "cand123"));
        users.add(new Voter("user1", "user123"));
    }

    public User login(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.checkPassword(password)) {
                return user;
            }
        }
        return null;
    }
}
