import java.util.Scanner;
class Bankomat {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int x1 = x / 5000;
		x = x % 5000;
        int x2 = x / 1000;
        x = x % 1000;
        int x3 = x / 500;
        x = x % 500;
        int x4 = x / 100;
        x = x % 100;
        int x5 = x / 50;
        x = x % 50;
        int x6 = x / 10;
        x = x % 10;
        int x7 = x / 5;
        int x8 = x % 5;

		System.out.println ("Банкомат выдал:");
        System.out.println ("Купюр номиналом 5000 рублей - " + x1);
        System.out.println ("Купюр номиналом 1000 рублей - " + x2);
        System.out.println ("Купюр номиналом  500 рублей - " + x3);
        System.out.println ("Купюр номиналом  100 рублей - " + x4);
        System.out.println ("Купюр номиналом   50 рублей - " + x5);
        System.out.println ("Купюр номиналом   10 рублей - " + x6);
        System.out.println ("Монет номиналом    5 рублей - " + x7);
        System.out.println ("Монет номиналом    1  рубль - " + x8);

	}
}