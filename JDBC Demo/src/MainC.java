import java.sql.*;
import java.util.Scanner;


// Program For Batch Processing

// Batch Processing :- Is Used to insert the multiple rows at a time in the form of batch


public class MainC{
    private static  final String url="jdbc:mysql://localhost:3306/mydb";
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
            Connection connection= DriverManager.getConnection(url,username,password);
//            Statement statement= connection.createStatement();

            String query=("INSERT INTO students(name,age,marks) VALUES(?,?,?)");
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            Scanner sc=new Scanner(System.in);
            while (true)
            {
                System.out.println("Enter The Name:");
                String name=sc.next();
                System.out.println("Enter Age:");
                int age=sc.nextInt();
                System.out.println("Enter Marks:");
                int marks=sc.nextInt();
                System.out.println("Enter More Data(Y/N) : ");
                String choice=sc.next();

                preparedStatement.setString(1,name);
                preparedStatement.setInt(2,age);
                preparedStatement.setInt(3,marks);
//                String query=String.format("INSERT INTO students(name,age,marks) VALUES('%s',%d,%d)",name,age,marks);

                preparedStatement.addBatch();
                if(choice.toUpperCase().equals("N"))
                {
                    break;
                }
            }

            // When The Batch will Execute The Value Comes In the form of an array
            // int arr[]=1 | 0 | 1 | 0 | 1
            // Here Zero Means Query Is Not Executed
            // Here 1 Values Query Is Executed Successfully
            int [] arr=preparedStatement.executeBatch();

            // To Check The Which Query Is Executed Or Not We Iterate Over Array

            for (int i=0;i< arr.length;i++)
            {
                if (arr[i] ==0)
                {
                    System.out.println("Query : " +i+ "is Not Executed Successfully!!");
                }
            }

        }  catch(SQLException e)
        {
            e.printStackTrace();
        }

    }
}
