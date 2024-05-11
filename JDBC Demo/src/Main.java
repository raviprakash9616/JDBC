
import java.sql.*;

//CRUD OPERATION USING STATEMENT

public class Main {
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
            Connection con=DriverManager.getConnection(url,username,password);
            // To Execute Sql Query We Have To Use Statement Interface
            Statement statement=con.createStatement();
//            String query=" select *from students";

            // Insert Values In Table
//            String query= String.format("INSERT INTO students(name,age,marks) VALUES('%s',%o,%o)","Ravi",21,98);

            // Update The Values
//            String query=String.format("UPDATE students SET  marks= %d WHERE id=%d",89,2);

            // Delete The Values

            String query="DELETE FROM students WHERE id=2";

            // Here ResultSet Is Used for holding the tables Values
//            ResultSet resultSet=statement.executeQuery(query);
            // For Update We Will Use updateQuery

            // Here Row Will Be get Affected So We Store It Into Int type variable
            int rowAffected=statement.executeUpdate(query);

            // Here We Are iterating on every Column to retrieve the information

//            while(resultSet.next())
//            {
//                int id=resultSet.getInt("id");
//                String name=resultSet.getString("name");
//                int age=resultSet.getInt("age");
//                int marks=resultSet.getInt("marks");
//                System.out.println("ID:"+ id);
//                System.out.println("NAME:"+ name);
//                System.out.println("AGE:"+ age);
//                System.out.println("MARKS:"+ marks);
//            }

            if(rowAffected>0)
            {
                // This Statement for insertion

//                System.out.println("Data Is Inserted Successfully!");

                // This Statement for Update
//                System.out.println("Data Is Updated Successfully!");

                // This Statement For Deletion

                System.out.println("DELETED SUCCESSFULLY");

            } else {

                // System.out.println("NOT INSERTED SUCCESSFULLY");

//                System.out.println("Data Is Not Updated");

                System.out.println("NOT DELETED SUCCESSFULLY");
            }

        } catch (SQLException e){
          e.printStackTrace();
        }
    }
}