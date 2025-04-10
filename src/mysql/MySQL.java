
package mysql;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MySQL {


    @SuppressWarnings("ConvertToTryWithResources")
    public static void sqlConnect() {
        // TODO code application logic here
        String url = "jdbc:mysql://localhost:3306/POEDataa";
        String user = "root";
        String pass = "Ironed?boti2";
        
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Database connection success");
            
            Statement stmt = con.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS users(id INT AUTO_INCREMENT PRIMARY KEY, first_name VARCHAR(100), last_name VARCHAR(100), phone VARCHAR(100))";
            stmt.execute(sql);
            System.out.println("Table created successfully");
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
