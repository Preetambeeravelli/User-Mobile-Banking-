package BankProject;
import java.util.Random;
import java.util.Scanner;

public class CreateAccount {
	
	private String accountNumber;
    private String password;
    public int balance;
    static Scanner input = new Scanner(System.in);
    private static final Random rand = new Random();
    static DbConnection dbConnection = new DbConnection();
    static CreateAccount myAccount= new CreateAccount();
    
    
    public static void accCre() {
    
    System.out.println("Enter your first name:");
	String firstName = input.next();
	
	System.out.println("Enter your Last name:");
	String lastName = input.next();
	
	System.out.println("Enter your Age:");
	int age = input.nextInt();
	
	dbConnection.insertdetails(firstName, lastName, age);
    myAccount.setAccountNumber();
    
    System.out.println(
    		"Your Account has been created\n" +
            "Your Account number is:");
    String account = myAccount.getAccountNumber();

    System.out.println(account);

    System.out.println("Your Account SecurePasscode is:");

    myAccount.setSecurePasscode();

    String pin = myAccount.getSecurePasscode();

    System.out.println(pin + "\n");

    int balance = myAccount.getBalance();

    dbConnection.insert(account, pin, balance);
}
    
	public static String createAcc() {
		
		String BIN = "703";
        int controlNumber = 0;
        int checkSum = 0;

        String card = BIN.concat(String.format("%06d", rand.nextInt(10000)));

        String[] cardArr = card.split("");

        // Converting the String to an array of Integers

        int[] cardNumber = new int[9];

        for (int i = 0; i < 9; i++) {

            cardNumber[i] = Integer.parseInt(cardArr[i]);

        }

        //Multiply even digits by 2 and subtract 9

        for (int i = 0; i < cardNumber.length; i++) {

            if (i % 2 == 0) {

                cardNumber[i] *= 2;

                if (cardNumber[i] > 9) {

                    cardNumber[i] -= 9;

                }
            }

        }

        // Calculating the Control number

        for (int j : cardNumber) {

            controlNumber += j;

        }

        // Calculating the checkSum

        while ((controlNumber + checkSum) % 10 != 0) {

            checkSum++;

        }

        // Adding the checkSum and return the complete card Number

        return card.concat(String.valueOf(checkSum));
    	

    }
	 public static boolean verifyAcc(String cardNumber) {

	        int controlNumber = 0;
	        int checkSum = 0;

	        String[] cardArray = cardNumber.split("");

	        // Converting the String to an array of Integers and dropping the last digit

	        int[] cardInt = new int[cardArray.length - 1];

	        for (int i = 0; i < cardInt.length; i++) {

	            cardInt[i] = Integer.parseInt(cardArray[i]);

	        }

	        //Multiply even digits by 2 and subtract 9

	        for (int i = 0; i < cardInt.length; i++) {

	            if (i % 2 == 0) {

	                cardInt[i] *= 2;

	                if (cardInt[i] > 9) {

	                    cardInt[i] -= 9;

	                }
	            }

	        }

	        // Calculating the Control number

	        for (int element : cardInt) {

	            controlNumber += element;

	        }

	        // Calculating the checkSum

	        while ((controlNumber + checkSum) % 10 != 0) {

	            checkSum++;

	        }

	        // verifying the checkSum with the last digit of the card

	        return checkSum == Integer.parseInt(cardArray[cardArray.length - 1]);
	    }
	 
	 
	 public void setAccountNumber() {

	        this.accountNumber = createAcc();
	    }
	 
	 
	 public String getAccountNumber() {

	        return accountNumber;
	    }

	    public void setSecurePasscode() {

	        this.password = String.format("%04d", rand.nextInt(8999) + 1000);
	    }

	    public String getSecurePasscode() {

	        return password;
	    }

	    

	    public int getBalance() {

	        return balance;
	    }

}	
	

