
package hotel.management.system;

import java.awt.Color;
import javax.swing.* ;
import java.awt.* ;
import java.sql.* ;
import net.proteanit.sql.DbUtils ;
import javax.swing.border.EmptyBorder ;
import java.awt.event.* ;

public class rooms extends JFrame implements ActionListener{
    
    JTable table ;
    JPanel contentpane ;
    JButton load,back ;
    
    rooms(){
        contentpane = new JPanel();
        contentpane.setLayout(null);
        contentpane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentpane);
        setSize(1100,550);
        setLocation(100,160);
        setVisible(true);
        getContentPane().setBackground(Color.white);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(525, 450,Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(530,30,525,450);
        contentpane.add(image);
        
        JLabel roomnum = new JLabel("Room Number");
        roomnum.setBounds(5, 20, 110, 30);
        roomnum.setFont(new Font("Raleway",Font.BOLD,13));
        roomnum.setForeground(Color.red);
        contentpane.add(roomnum);
        
        JLabel available = new JLabel("Availablity");
        available.setBounds(110, 20, 1100, 30);
        available.setFont(new Font("Raleway",Font.BOLD,13));
        available.setForeground(Color.red);
        contentpane.add(available);
        
        JLabel cleanstatus = new JLabel("Clean Status");
        cleanstatus.setBounds(215, 20, 110, 30);
        cleanstatus.setFont(new Font("Raleway",Font.BOLD,13));
        cleanstatus.setForeground(Color.red);
        contentpane.add(cleanstatus);
        
        JLabel price = new JLabel("Price");
        price.setBounds(320, 20, 110, 30);
        price.setFont(new Font("Raleway",Font.BOLD,13));
        price.setForeground(Color.red);
        contentpane.add(price);
        
        JLabel bedtype = new JLabel("Bed Type");
        bedtype.setBounds(430, 20, 110, 30);
        bedtype.setFont(new Font("Raleway",Font.BOLD,13));
        bedtype.setForeground(Color.red);
        contentpane.add(bedtype);
        
        table = new JTable();
        table.setBounds(0,50, 530,400);
        add(table);
        
       
        
        load = new JButton("Load Data");
        load.setBounds(70,460,150,30);
        load.setFont(new Font("serif",Font.BOLD,20));
        load.setBackground(Color.black);
        load.setForeground(Color.white);
        load.addActionListener(this);
        contentpane.add(load);
        
        back = new JButton("Back");
        back.setBounds(250,460,150,30);
        back.setFont(new Font("serif",Font.BOLD,20));
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        contentpane.add(back);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==load){
             try{
            conn c = new conn();
            
           ResultSet rs = c.s.executeQuery("select * from room") ;
           table.setModel(DbUtils.resultSetToTableModel(rs));
           
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new reception() ;
        }
        
    }
    
    
    public static void main(String args[]){
        new rooms() ;
    }
    
}
