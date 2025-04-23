import model.*;
import service.AuthService;
import service.ElectionService;
import service.VotingService;
import service.AdminService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthService authService = new AuthService();
        ElectionService electionService = new ElectionService();
        VotingService votingService = new VotingService();

        List<User> users = new ArrayList<>();
        List<CEC> cecs = new ArrayList<>();
        List<Candidate> candidates = new ArrayList<>();
        AdminService adminService = new AdminService(users, cecs, candidates);

        System.out.println("Добро пожаловать в систему электронного голосования!");
        System.out.print("Введите логин: ");
        String login = scanner.nextLine().trim();

        System.out.print("Введите пароль: ");
        String password = scanner.nextLine().trim();

        User user = authService.login(login, password);
        if (user != null) {
            System.out.println("Вы вошли как: " + user.getRole());

            while (true) {
                user.showMenu();
                System.out.print("Выберите действие: ");
                String choice = scanner.nextLine().trim();


                System.out.println("Введенный выбор: " + choice);

                boolean validChoice = false;


                switch (user.getRole().toUpperCase()) {
                    case "ADMIN":
                        if (choice.equals("1")) {
                            adminService.listUsers();
                            validChoice = true;
                        } else if (choice.equals("2")) {
                            adminService.listUsers();
                            System.out.print("Введите индекс для удаления: ");
                            try {
                                int indexToDelete = Integer.parseInt(scanner.nextLine().trim());
                                adminService.deleteUser(indexToDelete);
                                validChoice = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Некорректный индекс.");
                            }
                        } else if (choice.equals("3")) {
                            adminService.listCECs();
                            validChoice = true;
                        } else if (choice.equals("4")) {
                            adminService.listCECs();
                            System.out.print("Введите индекс для удаления: ");
                            try {
                                int indexToDelete = Integer.parseInt(scanner.nextLine().trim());
                                adminService.deleteCEC(indexToDelete);
                                validChoice = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Некорректный индекс.");
                            }
                        } else if (choice.equals("5")) {
                            System.out.print("Логин нового ЦИК: ");
                            String cecLogin = scanner.nextLine().trim();
                            System.out.print("Пароль нового ЦИК: ");
                            String cecPass = scanner.nextLine().trim();
                            adminService.createCEC(cecLogin, cecPass);
                            validChoice = true;
                        } else if (choice.equals("6")) {
                            adminService.listCandidates();
                            validChoice = true;
                        } else if (choice.equals("7")) {
                            adminService.listCandidates();
                            System.out.print("Введите индекс для удаления: ");
                            try {
                                int indexToDelete = Integer.parseInt(scanner.nextLine().trim());
                                adminService.deleteCandidate(indexToDelete);
                                validChoice = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Некорректный индекс.");
                            }
                        } else if (choice.equals("0")) {
                            return;  // Завершаем программу
                        } else {
                            System.out.println("Неверный выбор. Попробуйте снова.");
                        }
                        break;

                    case "CEC":
                        if (choice.equals("1")) {
                            System.out.print("Введите название голосования: ");
                            String name = scanner.nextLine().trim();
                            System.out.print("Введите дату окончания (ГГГГ-ММ-ДД): ");
                            LocalDate endDate = LocalDate.parse(scanner.nextLine().trim());
                            electionService.createElection(name, endDate);
                            validChoice = true;
                        } else if (choice.equals("2")) {
                            electionService.listElections();
                            System.out.print("Введите индекс голосования: ");
                            int index = Integer.parseInt(scanner.nextLine().trim());
                            System.out.print("Логин кандидата: ");
                            String candLogin = scanner.nextLine().trim();
                            System.out.print("Пароль кандидата: ");
                            String candPass = scanner.nextLine().trim();
                            Candidate candidate = new Candidate(candLogin, candPass);
                            electionService.addCandidateToElection(index, candidate);
                            validChoice = true;
                        } else if (choice.equals("3")) {
                            electionService.listElections();
                            System.out.print("Выберите голосование для печати результатов: ");
                            int index = Integer.parseInt(scanner.nextLine().trim());
                            votingService.showResults(electionService.getElections().get(index));
                            validChoice = true;
                        } else if (choice.equals("5") || choice.equals("6")) {
                            return;
                        } else {
                            System.out.println("Неверный выбор. Попробуйте снова.");
                        }
                        break;

                    case "VOTER":
                        if (choice.equals("1")) {
                            System.out.print("Введите ФИО: ");
                            scanner.nextLine();
                            System.out.print("Дата рождения: ");
                            scanner.nextLine();
                            System.out.print("СНИЛС: ");
                            scanner.nextLine();
                            System.out.println("Регистрация прошла успешно!");
                            validChoice = true;
                        } else if (choice.equals("2")) {
                            electionService.listElections();
                            System.out.print("Выберите голосование: ");
                            int eIdx = Integer.parseInt(scanner.nextLine().trim());
                            Election election = electionService.getElections().get(eIdx);
                            List<Candidate> candidatesList = election.getCandidates();
                            for (int i = 0; i < candidatesList.size(); i++) {
                                System.out.println(i + ". " + candidatesList.get(i).getLogin());
                            }
                            System.out.print("Выберите кандидата: ");
                            int cIdx = Integer.parseInt(scanner.nextLine().trim());
                            votingService.vote((Voter) user, election, candidatesList.get(cIdx));
                            validChoice = true;
                        } else if (choice.equals("3")) {
                            electionService.listElections();
                            validChoice = true;
                        } else if (choice.equals("5")) {
                            return;
                        } else {
                            System.out.println("Неверный выбор. Попробуйте снова.");
                        }
                        break;

                    case "CANDIDATE":
                        if (choice.equals("1")) {
                            System.out.print("Введите ФИО: ");
                            scanner.nextLine();  // Игнорируем ввод
                            System.out.print("Партийная принадлежность: ");
                            scanner.nextLine();  // Игнорируем ввод
                            System.out.println("Информация сохранена.");
                            validChoice = true;
                        } else if (choice.equals("2")) {
                            electionService.listElections();
                            System.out.print("Выберите голосование: ");
                            int index = Integer.parseInt(scanner.nextLine().trim());
                            votingService.showResults(electionService.getElections().get(index));
                            validChoice = true;
                        } else if (choice.equals("3")) {
                            electionService.listElections();
                            validChoice = true;
                        } else if (choice.equals("4")) {
                            return;
                        } else {
                            System.out.println("Неверный выбор. Попробуйте снова.");
                        }
                        break;

                    default:
                        if (choice.equals("5")) {
                            return;
                        } else {
                            System.out.println("Неверный выбор. Попробуйте снова.");
                        }
                }

                if (validChoice) {
                    System.out.println();
                }
            }
        } else {
            System.out.println("Ошибка входа. Неверный логин или пароль.");
        }
    }
}
