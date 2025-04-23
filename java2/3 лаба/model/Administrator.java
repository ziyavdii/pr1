
package model;

public class Administrator extends User {

    public Administrator(String login, String password) {
        super(login, password, "ADMIN");
    }

    @Override
    public void showMenu() {
        System.out.println("=== Меню администратора ===");
        System.out.println("1. Просмотр пользователей");
        System.out.println("2. Удаление пользователей");
        System.out.println("3. Создание ЦИК");
        System.out.println("4. Удаление кандидатов");
        System.out.println("5. Выход");
    }
}
