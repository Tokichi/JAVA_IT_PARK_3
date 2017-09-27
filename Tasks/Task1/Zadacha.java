import java.util.Scanner;
class Zadacha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
    	int x = scanner.nextInt();
		int x1 = x % 10;
        System.out.println ("Последняя цифра - " + x1);
	}
}