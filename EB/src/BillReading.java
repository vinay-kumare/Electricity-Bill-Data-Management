import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class BillReading extends JFrame
{
	BillReading(String meter) {
        setBounds(365, 150, 625, 400);
        getContentPane().setBackground(new Color(0X78DEC7));
        setLayout(null);

        JLabel heading = new JLabel("BILL  READINGS");
        heading.setBounds(200, 20, 500, 40);
        heading.setFont(new Font("Cambria", Font.BOLD, 22));
        add(heading);

        JLabel lblname = new JLabel("Name:");
        lblname.setFont(new Font("Calibri", Font.BOLD, 17));
        lblname.setBounds(60, 80, 100, 40);
        add(lblname);

        JLabel name = new JLabel("");
        name.setFont(new Font("Calibri", Font.BOLD, 17));
        name.setBounds(170, 80, 250, 40);
        add(name);

        JLabel lblmeternumber = new JLabel("Meter No:");
        lblmeternumber.setFont(new Font("Calibri", Font.BOLD, 17));
        lblmeternumber.setBounds(60, 120, 100, 40);
        add(lblmeternumber);

        JLabel meternumber = new JLabel("");
        meternumber.setFont(new Font("Calibri", Font.BOLD, 17));
        meternumber.setBounds(170, 120, 250, 40);
        add(meternumber);

        JLabel lbladdress = new JLabel("Address:");
        lbladdress.setFont(new Font("Calibri", Font.BOLD, 17));
        lbladdress.setBounds(60, 160, 100, 40);
        add(lbladdress);

        JLabel address = new JLabel("");
        address.setFont(new Font("Calibri", Font.BOLD, 17));
        address.setBounds(170, 160, 250, 40);
        add(address);

        JLabel lblunits = new JLabel("Units Consumed:");
        lblunits.setFont(new Font("Calibri", Font.BOLD, 17));
        lblunits.setBounds(60, 200, 150, 40);
        add(lblunits);

        JLabel units = new JLabel("");
        units.setFont(new Font("Calibri", Font.BOLD, 17));
        units.setBounds(220, 200, 200, 40);
        add(units);

        JLabel lblmonth = new JLabel("Month:");
        lblmonth.setFont(new Font("Calibri", Font.BOLD, 17));
        lblmonth.setBounds(60, 240, 100, 40);
        add(lblmonth);

        JLabel month = new JLabel("");
        month.setFont(new Font("Calibri", Font.BOLD, 17));
        month.setBounds(170, 240, 200, 40);
        add(month);

        JLabel lblcharges = new JLabel("Charges:");
        lblcharges.setFont(new Font("Calibri", Font.BOLD, 17));
        lblcharges.setBounds(320, 80, 100, 40);
        add(lblcharges);

        JLabel charges = new JLabel("");
        charges.setFont(new Font("Calibri", Font.BOLD, 17));
        charges.setBounds(430, 80, 100, 40);
        add(charges);

        JLabel lblamount = new JLabel("Total Bill Amount:  ₹");
        lblamount.setFont(new Font("Calibri", Font.BOLD, 17));
        lblamount.setBounds(320, 120, 180, 40);
        add(lblamount);

        JLabel amount = new JLabel("");
        amount.setFont(new Font("Calibri", Font.BOLD, 17));
        amount.setBounds(470, 120, 100, 40);
        add(amount);
        
        setLayout(new BorderLayout());
        
       // add(p, "Center");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image i2 = i1.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image, "South");
        
        getContentPane().setBackground(new Color(0X78DEC7));
        
        setVisible(true);
 
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from biill where meter = '"+meter+"'");
            while(rs.next()) 
            {
                name.setText(rs.getString("name"));
                meternumber.setText(rs.getString("meter"));
                address.setText(rs.getString("address"));
                units.setText(rs.getString("units"));
                month.setText(rs.getString("month"));
                charges.setText(rs.getString("charges"));
                amount.setText(rs.getString("amount"));
            }
        } 
        catch (Exception e) {
        	System.out.print(e);
        }
  
        setVisible(true);
    }
   
    public static void main(String[] args) 
    {
        new BillReading("");
    }
}
