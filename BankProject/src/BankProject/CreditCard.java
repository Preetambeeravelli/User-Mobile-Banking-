package BankProject;
import java.sql.SQLException;
import java.util.Scanner;

public class CreditCard {

	public static void cardApply() throws SQLException {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please Enter Your credit Score:");
		System.out.println("Enter values in the range of 0-1000");
		
		int creditScore = input.nextInt();
		
		switch(creditScore  / 100) {
		
		case 1:
			System.out.println("YOU ARE NOT ELIGIBLE FOR CREDIT CARD");
			break;
		case 2:
			System.out.println("YOU ARE NOT ELIGIBLE FOR CREDIT CARD");
			break;
		case 3:
			System.out.println("YOU ARE NOT ELIGIBLE FOR CREDIT CARD");
			break;
		case 4:
			System.out.println("YOU ARE NOT ELIGIBLE FOR CREDIT CARD");
			break;
		case 5:
			System.out.println("YOU ARE ELIGIBLE FOR CREDIT CARD");
			System.out.println("Your credit limit will be 5000$");
			break;
		case 6:
			System.out.println("YOU ARE ELIGIBLE FOR CREDIT CARD");
			System.out.println("Your credit limit will be 10000$");
			break;
		case 7:
			System.out.println("YOU ARE ELIGIBLE FOR CREDIT CARD");
			System.out.println("Your credit limit will be 15000$");
			break;
		case 8:
			System.out.println("YOU ARE ELIGIBLE FOR CREDIT CARD");
			System.out.println("Your credit limit will be 25000$");
			break;
		case 9:
			System.out.println("YOU ARE ELIGIBLE FOR CREDIT CARD");
			System.out.println("Your credit limit will be 5000$");
			break;
		case 10:
				System.out.println("YOU ARE ELIGIBLE FOR CREDIT CARD");
				System.out.println("Your credit limit will be 5000$");
				break;
				default:
					System.out.println("You have entered wrong creditScore,"
							+ " please try again with coreect range ");
		}
		}
}
