public class Menu {
    public static void showMainMenu() {
        System.out.println("МЕНЮ:");
        System.out.println("1. Показать список документов");
        System.out.println("2. Работа с документом");
        System.out.println("3. Переименовать документ");
        System.out.println("4. Удалить документ");
    }

    public static void showDocMenu() {
        System.out.println("МЕНЮ:");
        System.out.println("1. Показать документ");
        System.out.println("2. Вставить строку в начало");
        System.out.println("3. Вставить строку в конец");
        System.out.println("4. Удалить строку"); // спросить, какую строку удалить - сделать сдвиг
        System.out.println("5. Заменить строку");
        System.out.println("6. Очистить строку");
        System.out.println("7. Выход");
    }
}