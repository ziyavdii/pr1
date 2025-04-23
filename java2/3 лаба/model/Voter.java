
package model;

public class Voter extends User {
    public Voter(String login, String password) {
        super(login, password, "VOTER");
    }

    @Override
    public void showMenu() {
        System.out.println("=== Меню Пользователя ===");
        System.out.println("1. Регистрация");
        System.out.println("2. Голосование");
        System.out.println("3. Просмотр списка кандидатов");
        System.out.println("4. Все голосования, в которых голосовал/не голосовал");
        System.out.println("5. Выход");
    }
}
