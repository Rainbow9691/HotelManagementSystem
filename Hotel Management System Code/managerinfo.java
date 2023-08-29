package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.* ;
import java.sql.* ;
import net.proteanit.sql.DbUtils ;
import java.awt.event.* ;

public class managerinfo extends JFrame implements ActionListener{
    
    JTable table ;
    JButton back ;
    
    public managerinfo(){
        setLayout(null);
        setSize(1000,530);
        setLocation(150,160);
        setVisible(true);
        getContentPane().setBackground(Color.white);
        
        JLabel name = new JLabel("Name");
        name.setBounds(5, 10, 122, 30);
        name.setFont(new Font("Raleway",Font.BOLD,18));
       
        name.setForeground(Color.red);
        add(name);
        
        JLabel age = new JLabel("Age");
        age.setBounds(131, 10, 112, 30);
        age.setFont(new Font("Raleway",Font.BOLD,18));
       // department.setFont(new Font("Raleway",Font.BOLD,20));
        age.setForeground(Color.red);
        add(age);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(253, 10, 112, 30);
        gender.setFont(new Font("Raleway",Font.BOLD,18));
       // department.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setForeground(Color.red);
        add(gender);
        
        JLabel job = new JLabel("Job");
        job.setBounds(376, 10, 112, 30);
        job.setFont(new Font("Raleway",Font.BOLD,18));
       // department.setFont(new Font("Raleway",Font.BOLD,20));
        job.setForeground(Color.red);
        add(job);
        
        JLabel salary = new JLabel("Salary");
        salary.setBounds(497, 10,112, 30);
        salary.setFont(new Font("Raleway",Font.BOLD,18));
       // department.setFont(new Font("Raleway",Font.BOLD,20));
        salary.setForeground(Color.red);
        add(salary);
        
        JLabel phone = new JLabel("Phone");
        phone.setBounds(622, 10, 112, 30);
        phone.setFont(new Font("Raleway",Font.BOLD,18));
       // department.setFont(new Font("Raleway",Font.BOLD,20));
        phone.setForeground(Color.red);
        add(phone);
        
        JLabel email = new JLabel("E-mail");
        email.setBounds(745, 10, 112, 30);
        email.setFont(new Font("Raleway",Font.BOLD,18));
       // department.setFont(new Font("Raleway",Font.BOLD,20));
        email.setForeground(Color.red);
        add(email);
        
        JLabel adhar = new JLabel("Aadhar");
        adhar.setBounds(871, 10, 112, 30);
        adhar.setFont(new Font("Raleway",Font.BOLD,18));
       // department.setFont(new Font("Raleway",Font.BOLD,20));
        adhar.setForeground(Color.red);
        add(adhar);
        
        
        
        table = new JTable() ;
        table.setBounds(0,50,990, 390);
        
        try{
            conn c = new conn();
            
            ResultSet rs = c.s.executeQuery("select * from employee where job = 'Manager'");
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        add(table) ;
        
        
        back = new JButton("Back");
        back.setBounds(420,440,150,30);
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
        new managerinfo() ;
    }
    
}