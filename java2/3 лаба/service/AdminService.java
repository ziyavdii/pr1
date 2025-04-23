package service;
import model.*;

import java.util.List;

public class AdminService {
    private List<User> users;
    private List<CEC> cecs;
    private List<Candidate> candidates;

    public AdminService(List<User> users, List<CEC> cecs, List<Candidate> candidates) {
        this.users = users;
        this.cecs = cecs;
        this.candidates = candidates;
    }

    public void listUsers() {
        System.out.println("Список пользователей:");
        for (int i = 0; i < users.size(); i++) {
            System.out.println(i + ": " + users.get(i).getLogin());
        }
    }

    public void deleteUser(int index) {
        if (index >= 0 && index < users.size()) {
            users.remove(index);
            System.out.println("Пользователь удален.");
        } else {
            System.out.println("Неверный индекс.");
        }
    }

    public void listCECs() {
        System.out.println("Список ЦИК:");
        for (int i = 0; i < cecs.size(); i++) {
            System.out.println(i + ": " + cecs.get(i).getLogin());
        }
    }

    public void deleteCEC(int index) {
        if (index >= 0 && index < cecs.size()) {
            cecs.remove(index);
            System.out.println("ЦИК удален.");
        } else {
            System.out.println("Неверный индекс.");
        }
    }

    public void createCEC(String login, String password) {
        CEC newCec = new CEC(login, password);
        cecs.add(newCec);
        System.out.println("ЦИК успешно создан.");
    }

    public void listCandidates() {
        System.out.println("Список кандидатов:");
        for (int i = 0; i < candidates.size(); i++) {
            System.out.println(i + ": " + candidates.get(i).getLogin());
        }
    }

    public void deleteCandidate(int index) {
        if (index >= 0 && index < candidates.size()) {
            candidates.remove(index);
            System.out.println("Кандидат удален.");
        } else {
            System.out.println("Неверный индекс.");
        }
    }
}
