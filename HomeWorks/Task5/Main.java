
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int documentcount = 0;
        Document[] documents = new Document[5];
        for (int i = 0; i < documents.length; i++) {
            documents[i] = new Document();
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Menu.showMainMenu();
            int command = scanner.nextInt();

            switch (command) {
                case 1: {
                    showDocuments(documents);
                }
                break;
                case 2: {
                    System.out.println("Введите номер документа");
                    int docNum = scanner.nextInt();
                    DocumentActions.documentAction(documents[docNum]);
                }
                break;
                case 3: {
                    System.out.println("Введите номер документа");
                    int docNum = scanner.nextInt();
                    System.out.println("Введите новое имя документа");
                    String docName = scanner.next();
                    documents[docNum].documetName = docName;
                }
                break;
            }
        }
    }

    static void showDocuments(Document[] documents) {
        for (int i = 0; i < documents.length; i++) {
            String lineToOut = documents[i].documetName == null ? "Документ №" + i : documents[i].documetName;
            System.out.println("i: " + lineToOut);
        }
    }
}