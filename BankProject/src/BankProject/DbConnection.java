package BankProject;

import java.sql.*;

public class DbConnection {

	private  Connection connect() {

		   String url = "jdbc:mysql://localhost:3306/BankData";
		   String user = "bank";
		   String password = "Securepassword";
		  
		 

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(url,user,password);

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return connection;
    }
	
	 public void insert(String number, String pin, Integer balance) {

	        String sql = "INSERT INTO accountDetails(number, pin, balance) VALUES(?, ?, ?)";

	        try (Connection conn = this.connect();
	             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

	            preparedStatement.setString(1, number);
	            preparedStatement.setString(2, pin);
	            preparedStatement.setInt(3, balance);

	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {

	            System.out.println(e.getMessage());
	        }
	    }
	 
	 public void insertdetails(String firstname, String lastname, Integer age) {

	        String sql = "INSERT INTO accountDetails(firstname, lastname, age) VALUES(?, ?, ?)";

	        try (Connection conn = this.connect();
	             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

	            preparedStatement.setString(1, firstname);
	            preparedStatement.setString(2, lastname);
	            preparedStatement.setInt(3, age);
	        

	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {

	            System.out.println(e.getMessage());
	        }
	    }

	    public void update(String number, String pin, Integer balance) {

	        String sql = "UPDATE accountDetails SET balance = ? WHERE number = ? AND pin = ?";

	        try (Connection conn = this.connect();
	             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

	            preparedStatement.setInt(1, balance);
	            preparedStatement.setString(2, number);
	            preparedStatement.setString(3, pin);

	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {

	            System.out.println(e.getMessage());
	        }
	    }
	    

	    public void update(String number, Integer balance) {

	        String sql = "UPDATE accountDetails SET balance = ? WHERE number = ?";

	        try (Connection conn = this.connect();
	             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

	            preparedStatement.setInt(1, balance);
	            preparedStatement.setString(2, number);

	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {

	            System.out.println(e.getMessage());
	        }
	    }



	    public boolean checkLogin(String userAccount, String userPin) {

	        // This method is used to verify if the credentials exist in the database

	        String savedAccount, savedPass;

	        String query = "SELECT * FROM accountDetails";

	        try (Connection conn = this.connect();

	             Statement statement = conn.createStatement();
	             ResultSet resultSet = statement.executeQuery(query)) {

	            while (resultSet.next()) {

	                savedAccount = resultSet.getString("number");

	                savedPass = resultSet.getString("pin");

	                if (userAccount.equals(savedAccount) && userPin.equals(savedPass)) {

	                    return true;

	                }

	            }


	        } catch (SQLException exception) {

	            exception.printStackTrace();
	        }

	        return false;
	    }

	    public boolean checkAccount(String cardTransfer) {

	        // This method is used to check if an Account exists in the database

	        String savedCard;

	        String query = "SELECT * FROM accountDetails";

	        try (Connection conn = this.connect();

	             Statement statement = conn.createStatement();
	             ResultSet resultSet = statement.executeQuery(query)) {

	            while (resultSet.next()) {

	                savedCard = resultSet.getString("number");

	                if (cardTransfer.equals(savedCard)) {

	                    return true;

	                }

	            }

	        } catch (SQLException exception) {

	            exception.printStackTrace();
	        }

	        return false;

	    }

	    public int returnBalance(String userAccount, String userPin) {

	        String savedAccount, savedPass;

	        int currentBalance = 0;

	        String query = "SELECT * FROM accountDetails";

	        try (Connection conn = this.connect();

	             Statement statement = conn.createStatement();
	             ResultSet resultSet = statement.executeQuery(query)) {

	            while (resultSet.next()) {

	                savedAccount = resultSet.getString("number");

	                savedPass = resultSet.getString("pin");

	                if (userAccount.equals(savedAccount) && userPin.equals(savedPass)) {

	                    currentBalance = resultSet.getInt("balance");

	                    break;

	                }

	            }

	        } catch (SQLException exception) {

	            exception.printStackTrace();
	        }

	        return currentBalance;
	    }

	    public int returnBalance(String userAccount) {

	        String savedAccount;

	        int currentBalance = 0;

	        String query = "SELECT * FROM accountDetails";

	        try (Connection conn = this.connect();

	             Statement statement = conn.createStatement();
	             ResultSet resultSet = statement.executeQuery(query)) {

	            while (resultSet.next()) {

	                savedAccount = resultSet.getString("number");

	                if (userAccount.equals(savedAccount)) {

	                    currentBalance = resultSet.getInt("balance");

	                    break;

	                }

	            }

	        } catch (SQLException exception) {

	            exception.printStackTrace();
	        }

	        return currentBalance;
	    }

	    public void deleteAccount(String accountNumber) {

	        String query = "DELETE FROM acountDetails WHERE number = ?";

	        try (Connection conn = this.connect();
	             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

	            preparedStatement.setString(1, accountNumber);

	            preparedStatement.executeUpdate();


	        } catch (SQLException exception) {

	            exception.printStackTrace();
	        }

	    }

	}