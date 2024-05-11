import java.sql.*;
import java.util.Scanner;

// Transaction Handling

public class MainD {
    private static  final String url="jdbc:mysql://localhost:3306/lenden";
    private static final String username="root";
    private static final String password="Ravi8079@$";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }  catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        try
        {
            Connection con= DriverManager.getConnection(url,username,password);

            con.setAutoCommit(false);

            String debit_query="UPDATE accounts SET balance =balance-? WHERE account_number=?";
            String credit_query="UPDATE accounts SET balance =balance + ? WHERE account_number=?";

            PreparedStatement debitPreparedStatement= con.prepareStatement(debit_query);
            PreparedStatement creditPreparedStatement=con.prepareStatement(credit_query);


            Scanner sc=new Scanner(System.in);
            System.out.println("Enter Account_Number:");
            int account_number=sc.nextInt();
            System.out.println("Enter The Amount:");
            double amount=sc.nextDouble();

            debitPreparedStatement.setDouble(1,amount);
            debitPreparedStatement.setInt(2,account_number);
            creditPreparedStatement.setDouble(1,amount);
            creditPreparedStatement.setInt(2,102);

            debitPreparedStatement.executeUpdate();
            creditPreparedStatement.executeUpdate();

            if(isSufficient(con,account_number,amount))
            {
                con.commit();
                System.out.println("Transaction Successfully:");
            } else
            {
                con.rollback();
                System.out.println("Transaction Failed!!");
            }



        }  catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    static boolean isSufficient(Connection connection,int account_number,double amount) {
        try {
            String query = "SELECT balance FROM accounts WHERE account_number= ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, account_number);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                double current_balance = resultSet.getDouble("balance");

                if (amount > current_balance) {
                    return false;
                } else {
                    return true;
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
