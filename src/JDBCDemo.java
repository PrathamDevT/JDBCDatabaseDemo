import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo{
    public static void main(String[] args){
        try{
            String url = "jdbc:mysql://localhost:3306/jdbcdemo";
            String username = "root";
            String password="";
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url,username,password);

            Statement statement=connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from student");

            while (resultSet.next()){
                System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3));
            }

            connection.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}