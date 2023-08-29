
package hotel.management.system;

import javax.swing.* ;
import java.awt.* ;
import java.sql.* ;
import net.proteanit.sql.DbUtils ;
import java.awt.event.* ;


public class departments extends JFrame implements ActionListener{
    
    
    JButton back ;
    
    departments(){
        
        setLayout(null);
        setSize(600,500);
        setLocation(330,160);
        getContentPane().setBackground(Color.white);
        setVisible(true);
        
        JLabel department = new JLabel("Department");
        department.setBounds(0, 20, 150, 30);
        department.setFont(new Font("Raleway",Font.BOLD,20));
       // department.setFont(new Font("Raleway",Font.BOLD,20));
        department.setForeground(Color.red);
        add(department);
        
        JLabel budget = new JLabel("Budget");
        budget.setBounds(300, 20, 150, 30);
        budget.setFont(new Font("Raleway",Font.BOLD,20));
        //budget.setFont(new Font("Raleway",Font.BOLD,20));
        budget.setForeground(Color.red);
        add(budget);
        
        JTable table = new JTable();
        table.setBounds(0,70,600,320 );
        try{
            conn c = new conn();
            
           ResultSet rs = c.s.executeQuery("select * from department");
           
           table.setModel(DbUtils.resultSetToTableModel(rs));
           
            
        }
       catch(Exception e){
           e.printStackTrace();
       }
        
        add(table) ;
        
        back = new JButton("Back");
        back.setBounds(210,400,150,30);
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
        new departments() ;
    }

    
    
}
