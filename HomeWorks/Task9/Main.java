import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        List arrayList = new ArrayList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Menu.showMenu();
            int command = scanner.nextInt();
            switch (command){
                case 1:{
                    arrayList.addInt();
                }
                break;
                case 2:{
                    arrayList.deleteInt();
                }
                break;
                case 3:{
                    arrayList.findInt();
                }
                break;
                case 4:{
                    arrayList.addIndexInt();
                }
                break;
                case 5:{
                    while (arrayList.hasNext()){
                        System.out.println(arrayList.next());
                    }
                }
                break;
            }
        }
    }
}
