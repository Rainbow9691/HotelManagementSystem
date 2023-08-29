
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.* ;
import java.sql.* ;
import net.proteanit.sql.DbUtils ;
import java.awt.event.* ;
 
public class customerinfo extends JFrame implements ActionListener{
    
    JTable table ;
    JButton back ;
    
     public customerinfo(){
        setLayout(null);
        setSize(1100,530);
        setLocation(100,160);
        setVisible(true);
        getContentPane().setBackground(Color.white);
        
        JLabel id = new JLabel("Identification");
        id.setBounds(0, 10, 122, 30);
        id.setFont(new Font("Raleway",Font.BOLD,18));
       
        id.setForeground(Color.red);
        add(id);
        
        JLabel number = new JLabel("Number");
        number.setBounds(142, 10, 120, 30);
        number.setFont(new Font("Raleway",Font.BOLD,18));
       // department.setFont(new Font("Raleway",Font.BOLD,20));
        number.setForeground(Color.red);
        add(number);
        
        JLabel name = new JLabel("Name");
        name.setBounds(277, 10, 112, 30);
        name.setFont(new Font("Raleway",Font.BOLD,18));
       // department.setFont(new Font("Raleway",Font.BOLD,20));
        name.setForeground(Color.red);
        add(name);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(413, 10, 122, 30);
        gender.setFont(new Font("Raleway",Font.BOLD,18));
       // department.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setForeground(Color.red);
        add(gender);
        
        JLabel country = new JLabel("Country");
        country.setBounds(551, 10,120, 30);
        country.setFont(new Font("Raleway",Font.BOLD,18));
       // department.setFont(new Font("Raleway",Font.BOLD,20));
        country.setForeground(Color.red);
        add(country);
        
        JLabel roomno = new JLabel("Room no.");
        roomno.setBounds(690, 10, 125, 30);
        roomno.setFont(new Font("Raleway",Font.BOLD,18));
       // department.setFont(new Font("Raleway",Font.BOLD,20));
        roomno.setForeground(Color.red);
        add(roomno);
        
        JLabel checkin = new JLabel("Check-In");
        checkin.setBounds(827, 10, 125, 30);
        checkin.setFont(new Font("Raleway",Font.BOLD,18));
       // department.setFont(new Font("Raleway",Font.BOLD,20));
        checkin.setForeground(Color.red);
        add(checkin);
        
        JLabel deposit = new JLabel("Deposit");
        deposit.setBounds(965, 10, 112, 30);
        deposit.setFont(new Font("Raleway",Font.BOLD,18));
       // department.setFont(new Font("Raleway",Font.BOLD,20));
        deposit.setForeground(Color.red);
        add(deposit);
        
        
        
        table = new JTable() ;
        table.setBounds(0,50,1100, 390);
        
        try{
            conn c = new conn();
            
            ResultSet rs = c.s.executeQuery("select * from customer");
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        add(table) ;
        
        
        back = new JButton("Back");
        back.setBounds(470,440,150,30);
        back.setFont(new Font("serif",Font.BOLD,20));
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new reception();
        }
    }
    
    public static void main(String args[]){
        new customerinfo() ;
    }
    
}

    

