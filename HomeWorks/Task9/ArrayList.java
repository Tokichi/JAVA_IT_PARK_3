import java.util.Scanner;

public class ArrayList implements List{


    private int array[] = new int[10];
    private Scanner scanner = new Scanner(System.in);
    private int flag = 0;
    private int iteratorFlag = 0;

    public void addInt() {
        if (flag < array.length) {
            System.out.println("Введите значение для строки");
            array[flag] = scanner.nextInt();
            flag++;
        } else {
            System.out.println("Нет свободных строк");
        }
    }

    public void deleteInt() {
        System.out.println("Введите номер строки, которую хотите удалить");
        int intNum = scanner.nextInt();
        if (intNum <= flag) {
            for (int i = intNum; i < array.length - 1; i++) {
                array[intNum] = array[intNum + 1];
            }
            flag--;
        } else {
            System.out.println("Такой строки не существует");
        }
    }

    public void findInt() {
        System.out.println("Введите значение, которое вы ищите");
        int intNumFind = scanner.nextInt();
        for (int i = 0; i < flag + 1; i++) {
            if (intNumFind == array[i]) {
                System.out.println("Номер строки, содежращей искомое значение: " + i);
                return;
            }
        }
    }

    public void addIndexInt() {
    }

    public int next() {
        return array[iteratorFlag++];
    }

    public boolean hasNext() {
        if (iteratorFlag < flag) {
            return true;
        } else {
            return false;
        }
    }

}
