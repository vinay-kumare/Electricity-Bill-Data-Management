import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
    JButton login, cancel, signup;
    JTextField username, password;
    Choice logginin;
    Login() 
    {
        super("Login Page");
        getContentPane().setBackground(new Color(0X78DEC7));
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(350, 120, 100, 20);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblusername);
        
        username = new JTextField();
        username.setBounds(460, 120, 150, 20);
        add(username);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblpassword.setBounds(350, 160, 100, 20);
        add(lblpassword);
        
        password = new JTextField();
        password.setBounds(460, 160, 150, 20);
        add(password);
        
        JLabel loggininas = new JLabel("Loggin in as");
        loggininas.setFont(new Font("Tahoma", Font.BOLD, 16));
        loggininas.setBounds(350, 200, 100, 20);
        add(loggininas);
        
        logginin = new Choice();
        logginin.add("Admin");
        logginin.add("Customer");
        logginin.setBounds(460, 200, 150, 20);
        add(logginin);
        
        login = new JButton("Login");
        //login.setFont(new Font("Tahoma",Font.PLAIN, 16));
        login.setBounds(350, 260, 100, 30);
        //login.setBackground(Color.orange);
        login.addActionListener(this);
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 330, 100, 30);
        //cancel.setBackground(Color.orange);
        cancel.addActionListener(this);
        add(cancel);
        
        signup = new JButton("Signup");
        //signup.setBackground(Color.orange);
        signup.setBounds(550, 260, 100, 30);
        signup.addActionListener(this);
        add(signup);
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i8 = i7.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image = new JLabel(i9);
        image.setBounds(40, 70, 250, 250);
        add(image);
        
        setSize(840, 500);
        setLocation(200, 100);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource() == login) 
        {
            String susername = username.getText();
            String spassword = password.getText();
            String user = logginin.getSelectedItem();
            
            try 
            {
                Conn c = new Conn();
                String query = "select * from login where username = '"+susername+"' and password = '"+spassword+"' and userr = '"+user+"'";
                
                ResultSet rs = c.s.executeQuery(query);
                
                if (rs.next()) 
                {
                    String meter = rs.getString("meter_no");
                    setVisible(false);
                    new Home(user, meter);
                } 
                else 
                {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    username.setText("");
                    password.setText("");
                } 
            } 
            catch (Exception e) 
            {
            	System.out.print(e);
            }
        } 
        else if (ae.getSource() == cancel) 
        {
            setVisible(false);
        } 
        else if (ae.getSource() == signup) 
        {
            setVisible(false);
            new Signup();
        }
    }
    
    public static void main(String[] args) 
    {
        new Login();
    }
}