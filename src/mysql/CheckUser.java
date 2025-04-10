
package mysql;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CheckUser {
    public static void main(String[] args){
        System.out.println("Enter your first name");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        
        System.out.println("Enter your last name");
        String last = sc.nextLine();
        
        String url = "jdbc:mysql://localhost:3306/myData";
        String user = "root";
        String pass = "Ironed?boti2";
        
        String selectQ = "SELECT * FROM users WHERE first_name = ? AND last_name = ?";
        
        Connection con;
        try {
            con = DriverManager.getConnection(url, user, pass);
            PreparedStatement stmt = con.prepareStatement(selectQ);
            
            stmt.setString(1, name);
            stmt.setString(2, last);
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                System.out.println("Welcome "+name+ ", "+last);
            }else{
                System.out.println("User not found");
                System.out.println("Register to use the app");
                MySQLInsert.register();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CheckUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
