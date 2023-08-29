
package hotel.management.system;

import java.awt.Color;
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.sql.* ;

public class login extends JFrame implements ActionListener{
    
    JTextField username ;
    JPasswordField password ;
    JButton login , cancel ;
    
    login(){
        setLayout(null);
        setSize(750,400);
        setLocation(260,100);
        getContentPane().setBackground(Color.white);
        setVisible(true);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(280, 280,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2) ;
        
        JLabel image = new JLabel(i3) ;
        add(image) ;
        image.setBounds(450, 20, 280, 280);
        
        JLabel user = new JLabel("Username");
        user.setBounds(60, 80, 120, 30);
        user.setFont(new Font("Raleway",Font.BOLD,20));
        add(user);
        
        username = new JTextField() ;
        username.setBounds(220, 80, 230, 30);
        add(username);
        
        JLabel pass = new JLabel("Password");
        pass.setBounds(60,130, 120, 30);
        pass.setFont(new Font("Raleway",Font.BOLD,20));
        add(pass);
        
        password = new JPasswordField() ;
        password.setBounds(220, 130,230, 30);
        add(password);
        
        login = new JButton("Login");
        login.setBounds(100, 220, 130, 30);
        login.setFont(new Font("Raleway",Font.BOLD,17));
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(280, 220, 130, 30);
        cancel.setFont(new Font("Raleway",Font.BOLD,17));
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String usern = username.getText() ;
        String passn = password.getText() ;
        if(ae.getSource()==login){ 
            conn c1 = new conn();
        try{
           
            
            ResultSet rs = c1.s.executeQuery("select * from login");
            
            while(rs.next()){
                if(rs.getString("username").equals(usern) && rs.getString("password").equals(passn)){
                    setVisible(false);
                    new main().setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect username and password !!");
                }
            }
           
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }
        else if(ae.getSource()==cancel){
            username.setText("");
            password.setText("");
        }
    }
          
    public static void main(String args[]){
     new login() ;
    }
}
