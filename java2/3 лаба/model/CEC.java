
package model;

public class CEC extends User {
    public CEC(String login, String password) {
        super(login, password, "CEC");
    }

    @Override
    public void showMenu() {
        System.out.println("=== Меню ЦИК ===");
        System.out.println("1. Создать голосование");
        System.out.println("2. Добавить кандидата");
        System.out.println("3. Печать результатов в PDF");
        System.out.println("4. Группировка результатов");
        System.out.println("5. Сортировка результатов");
        System.out.println("6. Выход");
    }
}
