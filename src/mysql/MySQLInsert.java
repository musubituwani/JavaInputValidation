
package mysql;

import java.sql.*;
import java.util.*;

public class MySQLInsert {
   public static void register(){
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter your name:");
       String name = sc.nextLine();
       System.out.println("Enter your last name");
       String last = sc.nextLine();
       
       String url = "jdbc:mysql://localhost:3306/myData";
       String user = "root";
       String pass = "Ironed?boti2";
       
       String insertData = "INSERT INTO users(first_name, last_name) VALUES(?, ?)";
       Connection con;
       try {
           con = DriverManager.getConnection(url, user, pass);
           PreparedStatement stmt = con.prepareStatement(insertData);
           
           stmt.setString(1, name);
           stmt.setString(2, last);
           
           int rowInserted = stmt.executeUpdate();
           if(rowInserted> 0){
               System.out.println("User added successfully");
           }
           
       } catch (SQLException ex) {
           ex.printStackTrace();
       }
   } 
}*/