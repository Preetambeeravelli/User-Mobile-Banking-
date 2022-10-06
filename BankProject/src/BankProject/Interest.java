package BankProject;

import java.util.Scanner;

public class Interest {

	public static void getInterestDetails() {
		
    Scanner input = new Scanner(System.in);
		
    double principal;
		
		System.out.println("Enter The amount you want to deposit");
		principal = input.nextDouble();
		
		System.out.println("The interest rate will be 0.06%");
		
		System.out.println("Enter number of years you want to invest");
		int tenure = input.nextInt();
		
		System.out.printf("%s%20s%n","year","Amount on deposit");
		System.out.println();
		
		for(int year =1 ; year <= tenure ; ++year) {
			 double amount = principal * Math.pow(1.00 + 0.06, year);
			 System.out.printf("%2d%,20.2f%n",year,amount);
		}
	
	}
}
