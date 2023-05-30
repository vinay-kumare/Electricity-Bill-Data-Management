import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ViewInformation extends JFrame
{
    ViewInformation(String meter) 
    {
        setBounds(375, 150, 550, 300);
        getContentPane().setBackground(new Color(0X78DEC7));
        setLayout(null);
        
        JLabel heading = new JLabel("CUSTOMER  INFORMATION");
        heading.setBounds(140, 20, 500, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(heading);
        
        JLabel lblname = new JLabel("Name:");
        lblname.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblname.setBounds(125, 80, 100, 40);
        add(lblname);
        
        JLabel name = new JLabel("");
        name.setFont(new Font("Tahoma", Font.BOLD, 16));
        name.setBounds(250, 80, 100, 40);
        add(name);
        
        JLabel lblmeternumber = new JLabel("Meter No:");
        lblmeternumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblmeternumber.setBounds(97, 140, 100, 40);
        add(lblmeternumber);
        
        JLabel meternumber = new JLabel("");
        meternumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        meternumber.setBounds(250, 140, 100, 40);
        add(meternumber);
 
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customers where meter_no = '"+meter+"'");
            while(rs.next()) 
            {
                name.setText(rs.getString("name"));
                meternumber.setText(rs.getString("meter_no"));
            }
        } 
        catch (Exception e) {
        	System.out.print(e);
        }
  
        setVisible(true);
    }
   
    public static void main(String[] args) 
    {
        new ViewInformation("");
    }
}
