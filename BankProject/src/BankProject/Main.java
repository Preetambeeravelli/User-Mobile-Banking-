package BankProject;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input  = new Scanner(System.in);
        CreateAccount myAccount= new CreateAccount();
        DbConnection dbConnection = new DbConnection();

        boolean loggedIn;

        while (true) {

           Mainmenu.mainPage();

            int choice = input.nextInt();

            switch (choice) {

                case 1:
                	CreateAccount.accCre();
                	int balance = myAccount.getBalance();
                    break;

                case 2:

                    System.out.println("\nEnter your Account number:");

                    String userAccount = input.next();

                    System.out.println("Enter your SecurePin:");

                    String userPin = input.next();
                    

                    if (dbConnection.checkLogin(userAccount, userPin)) {

                        System.out.println("\nYou have successfully logged in!\n");

                        loggedIn = true;

                        balance = dbConnection.returnBalance(userAccount, userPin);

                        while (loggedIn) {

                           Mainmenu.secondPage();

                            int accountOption = input.nextInt();

                            switch (accountOption) {

                                case 1:// Gets Balance of the created Account

                                    System.out.println("\n Current Balance in the Account is: " + balance + "\n" );
                             
                                    break;

                                case 2: // Deposit amount

                                   
                                    System.out.println("Enter your deposit amount:");

                                    balance += input.nextInt();

                                    dbConnection.update(userAccount, userPin, balance);

                                    System.out.println("Income was added!\n");
                                    System.out.println("Current Balance in the account is \n" + balance );
                                    
                                

                                    break;
                                    
                                case 3: // Withdraw Amount

                                	
                                    System.out.println("Enter your Withdraw amount:");
                                    int withdrawAmount = input.nextInt();

                                    balance -= withdrawAmount;

                                    dbConnection.update(userAccount, userPin, balance);

                                    System.out.println("You have Succesfully Withdraw " + withdrawAmount+ " from the Account\n");
                                    System.out.println("Current Balance in the account is " + balance + "\n" );
                                	 
                                	
                                    break;
                                    
                                case 7:// details about interest
                                	
                                	Interest.getInterestDetails();
                                	break;	
                                	
                                case 8:// displays credit card eligibility
                                	
								try {
									CreditCard.cardApply();
								} catch (SQLException e) {
									
									e.printStackTrace();
								}
                                	break;
                                	
                                case 9: //calls emi method
                                	Loan.emiCal();
                                	break;

                                case 4:

                                    while (true) {

                                        System.out.println("Transfer\n" +
                                                "Enter Account number:");

                                        String accNum = input.next();

                                        if (!CreateAccount.verifyAcc(accNum)) {

                                            System.out.println("There is no Account with this number." +
                                                    " Please check the account number and try again!\n");
                                            break;
                                        }

                                        if (!dbConnection.checkAccount(accNum) && CreateAccount.verifyAcc(accNum)) {

                                            System.out.println("No Account does exist with that number.\n");

                                            break; }

                                        if (accNum.equals(userAccount)) {

                                            System.out.println("You can't transfer money to the same account!\n");

                                            break;}

                                        if (CreateAccount.verifyAcc(accNum) &&
                                                !(!dbConnection.checkAccount(accNum) && CreateAccount.verifyAcc(accNum))) {

                                            System.out.println("Please enter the amount you want to transfer:");

                                            int amountTransfer = input.nextInt();

                                            if (balance < amountTransfer) {

                                                System.out.println("Not enough Balance in your account!\n");

                                                break;}

                                            // Money to be transferred

                                            int targetBalance = dbConnection.returnBalance(accNum);

                                            dbConnection.update(accNum, amountTransfer + targetBalance);

                                            // Subtract amount from the actual account

                                            dbConnection.update(userAccount, balance - amountTransfer);

                                            System.out.println("Success!\n");

                                            break;} }
                                    		break;

                                case 6:

                                    // Close account

                                    dbConnection.deleteAccount(userAccount);

                                    System.out.println("The account has been closed!\n");

                                    break;

                                case 5:

                                    System.out.println("\nYou have successfully logged out of your account!\n");

                                    loggedIn = false;

                                    break;
                                    
                               

                                case 0:

                                    System.out.println("\nThank you for using our application!");

                                    input.close();

                                    System.exit(0);

                            }

                        }

                    } else {

                        System.out.println("You have entered wrong Account Number or Passcode!\n");
                    }

                    break;

                case 0:

                    System.out.println("\nThank you for using our application \n GoodBye!");

                    input.close();

                    System.exit(0);

            }
        }

    }

                    
}
