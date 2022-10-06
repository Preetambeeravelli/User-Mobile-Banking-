package BankProject;
import java.util.Scanner;
public class Loan {

	
	public static void emiCal() {
		
		
		System.out.println("Please select the type of load you need");
		System.out.println("1: Housing Loan \n" + 
		"2: Auto Loan \n" + "3: personal Loan \n" + "4: Education Loan \n");
		Scanner input = new Scanner(System.in);
		
	int choice = input.nextInt();
		
		switch(choice) {
		
		case 1:
			System.out.println("You have selected Housing loan");
			System.out.println("please enter the amount you need: \n");
			
			double amount = input.nextDouble();
			System.out.println("rate of interest will be 2.56% \n");
			
			System.out.println("please enter the number of"
					+ " months you need loan: \n");
			int month = input.nextInt();
			
			double emi1 = Math.pow(1 + 0.256, month);
			double emi2 = emi1 - 1;
			double emi3 = emi1/emi2;
			double emi = emi3 * amount * 0.256;
			
			System.out.println("Your monthly emi will be: " + emi);
			System.out.println("Thank you for selecting our bank");
			break;
			
		case 2:
			System.out.println("You have selected Auto loan");
			System.out.println("please enter the amount you need: \n");
			
			double amount1 = input.nextDouble();
			System.out.println("rate of interest will be 3.56% \n");
			
			System.out.println("please enter the number of "
					+ "months you need loan: \n");
			int month1 = input.nextInt();
			
			double emi11 = Math.pow(1 + 0.356, month1);
			double emi22 = emi11 - 1;
			double emi33 = emi11/emi22;
			double emii = emi33 * amount1 * 0.356;
			
			System.out.println("Your monthly emi will be: " + emii);
			System.out.println("Thank you for selecting our bank");
			break;
		case 3:
			System.out.println("You have selected Personal loan");
			System.out.println("please enter the amount you need: \n");
			
			double amount2 = input.nextDouble();
			System.out.println("rate of interest will be 4.8% \n");
			
			System.out.println("please enter the number of "
					+ "months you need loan: \n");
			int month2 = input.nextInt();
			
			double emi111 = Math.pow(1 + 0.48, month2);
			double emi222 = emi111 - 1;
			double emi333 = emi111/emi222;
			double emiii = emi333 * amount2 * 0.48;
			
			System.out.println("Your monthly emi will be: " + emiii);
			System.out.println("Thank you for selecting our bank");
			break;
			
		case 4:
			System.out.println("You have Education loan");
			System.out.println("please enter the amount you need: \n");
			
			double amount3 = input.nextDouble();
			System.out.println("rate of interest will be 1.3% \n");
			
			System.out.println("please enter the number of"
					+ " months you need loan: \n");
			int month3 = input.nextInt();
			
			double emi1111 = Math.pow(1 + 0.13, month3);
			double emi2222 = emi1111 - 1;
			double emi3333 = emi1111/emi2222;
			double emiiii = emi3333 * amount3 * 0.13;
			
			System.out.println("Your monthly emi will be: " + emiiii);
			System.out.println("Thank you for selecting our bank");
			break;
			default:
				System.out.println("Please select correct option");
		}
		
		
		
	}
}
