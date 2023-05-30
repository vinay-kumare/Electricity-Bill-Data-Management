import java.sql.*;

public class Conn 
{
    Connection c;
    Statement s;
    Conn() 
    {
        try 
        {
            c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","pass123");
            s = c.createStatement();
        } 
        catch (Exception e) 
        {
        	System.out.print(e);
        }
    }
}