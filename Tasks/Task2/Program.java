import java.util.Scanner;
class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		int x = scanner.nextInt();

		int x0;
		int x1;
		int x2;
		int x3;
		int x4;
		int x5;
		int x6;
		int x7;

		x0 = x % 2;
		x = x / 2;
		x1 = x % 2;
		x = x % 2;
		x2 = x1 / 2;
		x = x % 2;
		x3 = x2 / 2;
		x = x % 2;
		x4 = x3 / 2;
		x = x % 2;
		x5 = x / 2;
		x = x % 2;
		x6 = x5 / 2;
		x = x % 2;
		x7 = x6 / 2;


		
		System.out.println(x7 + "" 
			+ x6 + "" 
			+ x5 + "" 
			+ x4 + ""
			+ x3 + ""
			+ x2 + ""
			+ x1 + ""
			+ x0);

	}
}