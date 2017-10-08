import java.io.IOException;
import java.util.Scanner;

public class DocumentActions {
    public static void documentAction(Document document) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Menu.showDocMenu();

            int command = scanner.nextInt();

            switch (command) {
                case 1: {
                    document.showDocument();
                }
                break;
                case 2: {
                    if (document.count == document.lines.length) {
                        System.err.println("Нет места");
                        break;
                    }
                    System.out.println("Введите строку: ");
                    String newLine = scanner.next();
                    document.addLineToBegin(newLine);
                }
                break;
                case 3: {
                    if (document.count == document.lines.length) {
                        System.err.println("Нет места");
                        break;
                    }
                    System.out.println("Введите строку: ");
                    String newLine = scanner.next();
                    document.addLineToEnd(newLine);
                }
                break;
                case 4: {
                    System.out.println("Какую строку удалить?");
                    int numLine = scanner.nextInt();
                    document.deleteLine(numLine);
                }
                break;
                case 5: {
                    System.out.println("Какую строку заменить?");
                    int numLine = scanner.nextInt();
                    System.out.println("Введите строку: ");
                    String newLine = scanner.next();
                    document.changeLine(numLine, newLine);
                }
                break;
                case 6: {
                    System.out.println("Какую строку удалить?");
                    int numLine = scanner.nextInt();
                    document.clearLine(numLine);
                }
                break;
                case 7:
                    return;
            }
        }
    }

}
