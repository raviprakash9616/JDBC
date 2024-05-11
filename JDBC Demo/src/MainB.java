import java.sql.*;


// CRUD OPERATION USING PREPARED STATEMENT

public class MainB {

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

            // Query for insert data in the table
//            String query="INSERT INTO students(name,age,marks) VALUES(?,?,?) ";


            // Query For Retrieve The Data From Table
//            String query="SELECT marks FROM students WHERE id=?";

            // QUERY FOR UPDATE

//            String query="UPDATE students SET marks = ? WHERE id= ?";

            // Query For Delete

            String query="DELETE FROM students WHERE id=?";


            // To Execute Sql Query We Have To Use Statement Interface
//            Statement statement=con.createStatement();

            // Here Prepared Statement is used for if we have to execute same query again and again then prepared statement is very efficient
            PreparedStatement preparedStatement= connection.prepareStatement(query);
//            preparedStatement.setString(1,"Amit");
//            preparedStatement.setInt(2,23);
//            preparedStatement.setInt(3,99);

//              Updating Value
              preparedStatement.setInt(1,77);
              preparedStatement.setInt(2,3);


                // here i Am reteriving the information

//            preparedStatement.setInt(2,1);

                int rowsAffected=preparedStatement.executeUpdate();
                if(rowsAffected>0)
                {
//                    System.out.println("Data Inserted Successfully");

                    System.out.println("Data Updated Successfully:");
                }  else {
//                    System.out.println("Data Is Not Inserted Successfully");
                    System.out.println("Data is not Updated Successfully");
                }
//            ResultSet resultSet= preparedStatement.executeQuery();
//            if(resultSet.next())
//            {
//               int  marks= resultSet.getInt("marks");
//                System.out.println("Marks:" + marks);
//            } else {
//                System.out.println("Results Not Found!!");
//            }

        }  catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
