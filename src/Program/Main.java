package Program;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	Cashier cashier = new Cashier();
		
	System.out.println("================================");
	System.out.println("\tSELAMAT DATANG ");
	System.out.println("================================");
	
	cashier.order();
	scanner.close();
	}
}
