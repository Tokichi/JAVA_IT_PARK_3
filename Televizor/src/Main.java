import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalTime currenttime = LocalTime.now();
        String timenow = currenttime.toString();
        System.out.println("Выберите номер канала");
        int numChannel = scanner.nextInt();

        Programs[] channel1 = new Programs[10];
        channel1[0] = new Programs("Передача про слонов","00:00", "01:55");
        channel1[1] = new Programs("Передача про китов","01:55", "04:20");
        channel1[2] = new Programs("Передача про собак","04:20", "07:00");
        channel1[3] = new Programs("Передача про обезьян","07:00", "09:30");
        channel1[4] = new Programs("Передача про лосей","09:30", "12:10");
        channel1[5] = new Programs("Передача про боров","12:10", "14:30");
        channel1[6] = new Programs("Передача про муравьев","14:30", "16:45");
        channel1[7] = new Programs("Передача про бурундуков","16:45", "19:15");
        channel1[8] = new Programs("Передача про бегемотов","19:15", "21:40");
        channel1[9] = new Programs("Передача про черепах","21:40", "24:00");

        for (int i = 0; i < channel1.length; i++){

            if (){

            }
        }


        System.out.println(timenow);



    }
}
