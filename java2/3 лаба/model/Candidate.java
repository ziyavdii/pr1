
package model;

public class Candidate extends User {
    public Candidate(String login, String password) {
        super(login, password, "CANDIDATE");
    }

    @Override
    public void showMenu() {
        System.out.println("=== Меню Кандидата ===");
        System.out.println("1. Заполнить данные о себе");
        System.out.println("2. Посмотреть результаты предыдущих голосований");
        System.out.println("3. Голосования, в которых участвовал");
        System.out.println("4. Выход");
    }
}
