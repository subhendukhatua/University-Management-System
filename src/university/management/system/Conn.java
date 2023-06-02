
package university.management.system;
import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    
    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            c = DriverManager.getConnection("jdbc:mysql:///universitymanagementsystem","root","Subhendu143@");
            s = c.createStatement();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    
   
}
