import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.sql.*;

public class CalculateBill extends JFrame implements ActionListener
{
    JTextField tfunits;
    JButton next;
    JLabel lblname, labeladdress;
    Choice meternumber, cmonth;
    
    CalculateBill() 
    {
        setSize(600, 500);
        setLocation(400, 150);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(0X78DEC7));
        add(p);
        
        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(120, 20, 400, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        p.add(heading);
        
        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(100, 80, 100, 20);
        p.add(lblmeternumber);
        
        meternumber = new Choice();
        
        try 
        {
            Conn c  = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customers");
            while(rs.next()) 
            {
                meternumber.add(rs.getString("meter_no"));
            }
        }
        catch (Exception e) {
        }
        
        meternumber.setBounds(240, 80, 200, 20);
        p.add(meternumber);
        
        JLabel lblmeterno = new JLabel("Name");
        lblmeterno.setBounds(100, 120, 100, 20);
        p.add(lblmeterno);
        
        lblname = new JLabel("");
        lblname.setBounds(240, 120, 100, 20);
        p.add(lblname);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(100, 160, 100, 20);
        p.add(lbladdress);
        
        labeladdress = new JLabel();
        labeladdress.setBounds(240, 160, 200, 20);
        p.add(labeladdress);
        
        // In this block we are retriving data of meternumber.getSelectedItem()
        try 
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customers where meter_no = '"+meternumber.getSelectedItem()+"'");
           
            while(rs.next()) 
            {
                lblname.setText(rs.getString("name"));
                labeladdress.setText(rs.getString("address"));
            }
        } 
        catch (Exception e) {
        }
        
        meternumber.addItemListener(new ItemListener() 
        {
            public void itemStateChanged(ItemEvent ie) {
                try 
                {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from customers where meter_no = '"+meternumber.getSelectedItem()+"'");
                    
                    while(rs.next()) 
                    {
                        lblname.setText(rs.getString("name"));
                        labeladdress.setText(rs.getString("address"));
                    }
                } catch (Exception e) 
                {
                }
            }
        });
        
        JLabel lblcity = new JLabel("Units Consumed");
        lblcity.setBounds(100, 200, 100, 20);
        p.add(lblcity);
        
        tfunits = new JTextField();
        tfunits.setBounds(240, 200, 200, 20);
        p.add(tfunits);
        
        JLabel lblstate = new JLabel("Month");
        lblstate.setBounds(100, 240, 100, 20);
        p.add(lblstate);
        
        cmonth = new Choice();
        cmonth.setBounds(240, 240, 200, 20);
        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");
        p.add(cmonth);
        
        next = new JButton("Submit");
        next.setBounds(250, 350, 100,25);
        //next.setBackground(Color.BLACK);
        //next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);
        
        setLayout(new BorderLayout());
        
        add(p,"Center");
        
        //getContentPane().setBackground(new Color(0X78DEC7));
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) 
    {
    	if (ae.getSource() == next) 
        {
    		String meter = meternumber.getSelectedItem();
    		String name = lblname.getText();
    	    String address = labeladdress.getText();
            String units = tfunits.getText();
            int unit = Integer.parseInt(units);
            
            double charges = unit*5;
            double amount = charges+40;  // Rs 5 per unit & 40= Fixed Fee
            
            String month = cmonth.getSelectedItem();
            
            String query = "insert into biill values('"+meter+"', '"+name+"', '"+address+"', '"+unit+"', '"+month+"', '"+charges+"', '"+amount+"')";
            
            try 
            {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
                setVisible(false);
            } 
            catch (Exception e) 
            {
            	System.out.print(e);
            }
        }
       // JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
        
    }
    
    public static void main(String[] args) 
    {
        new CalculateBill();
    }
}
