import java.io.IOException;

public class Main {
    public static void printList(Humans list) {
        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.nextName() + " " + iterator.nextAge());
        }
    }


    public static void main(String[] args) throws IOException {
        DataReader reader = new DataReader("inputName.txt");
        Humans humans[] = new Humans[100];
        for (int i = 0; i < 100; i++) {
            humans[i] = new Humans();
        }
        boolean flag = true;
        for (int i = 0; flag; i++) {
            Human human = reader.readHuman();
            flag = !(human.getName() == "Finish");
            if (flag) {
                humans[human.getAge()].addToBegin(human);
            }
        }

        for (int i = 0; i < 100; i++) {

            printList(humans[i]);
        }
    }
}
