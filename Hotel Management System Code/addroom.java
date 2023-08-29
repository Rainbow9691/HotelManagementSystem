
package hotel.management.system;

import java.awt.Color;
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

public class addroom extends JFrame implements ActionListener{
    
    JTextField roomnumber,roomprice ;
    JComboBox availableroom,cleanstatus,bed ;
    JButton addroom,cancel ;
    
    addroom(){
        setLayout(null);
        setSize(1020,550);
        setLocation(140,160);
        setVisible(true);
        getContentPane().setBackground(Color.white);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/twelve.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,380, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(470,50, 500, 380);
        add(image);
        
        JLabel room = new JLabel("Add Rooms");
        room.setBounds(100,30,150,30);
        room.setFont(new Font("Raleway",Font.BOLD,24));
        add(room);
        
        JLabel roomnum = new JLabel("Room Number");
        roomnum.setBounds(40,110,200,30);
        roomnum.setFont(new Font("Raleway",Font.PLAIN,20));
        add(roomnum);
        
        roomnumber = new JTextField();
        roomnumber.setBounds(240,110,200,30);
        add(roomnumber);
        
        JLabel available = new JLabel("Available");
        available.setBounds(40,170,200,30);
        available.setFont(new Font("Raleway",Font.PLAIN,20));
        add(available);
        
        String avail[] = {"Available","Occupied"} ;
        
        availableroom = new JComboBox(avail);
        availableroom.setBounds (240, 170, 200, 30);
        availableroom.setBackground(Color.white);
        add(availableroom);
        
        JLabel cleaning = new JLabel("Cleaning Status");
        cleaning.setBounds(40,230,200,30);
        cleaning.setFont(new Font("Raleway",Font.PLAIN,20));
        add(cleaning);
        
        String cleanstat[] = {"Cleaned","Dirty"} ;
        
        cleanstatus = new JComboBox(cleanstat);
        cleanstatus.setBounds (240, 230, 200, 30);
        cleanstatus.setBackground(Color.white);
        add(cleanstatus);
        
        JLabel price = new JLabel("Price");
        price.setBounds(40,290,200,30);
        price.setFont(new Font("Raleway",Font.PLAIN,20));
        add(price);
        
        roomprice = new JTextField();
        roomprice.setBounds(240,290,200,30);
        add(roomprice);
        
        JLabel bedtype = new JLabel("Bed Type");
        bedtype.setBounds(40,350,200,30);
        bedtype.setFont(new Font("Raleway",Font.PLAIN,20));
        add(bedtype);
        
        String bedtyp[] = {"Single Bed","Double Bed"} ;
        
        bed = new JComboBox(bedtyp);
        bed.setBounds (240, 350, 200, 30);
        bed.setBackground(Color.white);
        add(bed);
        
        addroom = new JButton("Add Room");
        addroom.setBounds(50,430,160, 35);
        addroom.setBackground(Color.black);
        addroom.setForeground(Color.white);
        addroom.setFont(new Font("serif",Font.BOLD,20));
        addroom.addActionListener(this);
        add(addroom);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(260,430,160,35);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("serif",Font.BOLD,21));
        cancel.addActionListener(this);
        add(cancel);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String roomn = roomnumber.getText() ;
        String availablen = (String)availableroom.getSelectedItem();
        String cleanstatn = (String)cleanstatus.getSelectedItem();
        String roompricen = roomprice.getText();
        String bedn =(String) bed.getSelectedItem();
        
        if(ae.getSource()==addroom){
            conn c2  = new conn();
           try{ 
            if(roomn.equals("")){
                JOptionPane.showMessageDialog(null, "Enter the room number!!!");
            }
            else if(roompricen.equals("")){
                JOptionPane.showMessageDialog(null, "Enter the room Price!!!");
            }
            else{
                c2.s.executeUpdate("insert into room values('"+roomn+"','"+availablen+"','"+cleanstatn+"','"+roompricen+"','"+bedn+"')");
                
                JOptionPane.showMessageDialog(null, "Room Added Successfully");
                
                setVisible(false);
               
            }
           }
           catch(Exception e){
               e.printStackTrace();
           }
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
        }
        
    }
    
    public static void main(String args[]){
        new addroom() ;
    }
    
}
