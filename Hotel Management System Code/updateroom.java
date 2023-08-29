package hotel.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.* ;

public class updateroom extends JFrame implements ActionListener {

    Choice customer;
    JTextField roomtext,availabletext,cleantext,amounttext,pendingtext ;
    JButton check,updatebutton,back ;

    updateroom() {
        setLayout(null);
        setSize(1000, 550);
        setLocation(150, 160);
        getContentPane().setBackground(Color.white);
        setVisible(true);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,330,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(490,80,450, 330);
        add(image);

        JLabel update = new JLabel("Update Room Status");
        update.setBounds(90, 20, 300, 30);
        update.setFont(new Font("Raleway", Font.BOLD, 26));
        update.setForeground(Color.blue);
        add(update);

        JLabel cid = new JLabel("Customer Id");
        cid.setBounds(30, 90, 200, 30);
        cid.setFont(new Font("Raleway", Font.BOLD, 20));
        cid.setForeground(Color.black);
        add(cid);

        customer = new Choice();
        customer.setBounds(260, 92, 200, 40);
        customer.setFont(new Font("Raleway", Font.BOLD, 15));

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer ");

            while (rs.next()) {
                customer.add(rs.getString("Number"));
            }

            add(customer);

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel roomnum = new JLabel("Room Number");
        roomnum.setBounds(30, 150, 200, 30);
        roomnum.setFont(new Font("Raleway", Font.BOLD, 20));
        roomnum.setForeground(Color.black);
        add(roomnum);

        roomtext = new JTextField();
        roomtext.setBounds(260,150, 200, 27);
        roomtext.setBackground(Color.white);
        add(roomtext);

        JLabel available = new JLabel("Availibility");
        available.setBounds(30, 210, 200, 30);
        available.setFont(new Font("Raleway", Font.BOLD, 20));
        available.setForeground(Color.black);
        add(available);

        availabletext = new JTextField();
        availabletext.setBounds(260, 210, 200, 27);
        availabletext.setBackground(Color.white);
        add(availabletext);

        JLabel cleanstat = new JLabel("Cleaning Status");
        cleanstat.setBounds(30, 270, 200, 30);
        cleanstat.setFont(new Font("Raleway", Font.BOLD, 20));
        cleanstat.setForeground(Color.black);
        add(cleanstat);

        cleantext = new JTextField();
        cleantext.setBounds(260, 270, 200, 27);
        cleantext.setBackground(Color.white);
        add(cleantext);

        check = new JButton("Check");
        check.setBounds(30, 380, 120, 30);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.setFont(new Font("serif",Font.BOLD,18));
        check.addActionListener(this);
        add(check);

        updatebutton = new JButton("Update");
        updatebutton.setBounds(183, 380, 120, 30);
        updatebutton.setBackground(Color.black);
        updatebutton.setForeground(Color.white);
        updatebutton.setFont(new Font("serif",Font.BOLD,18));
        updatebutton.addActionListener(this);
        add(updatebutton);

        back = new JButton("Back");
        back.setBounds(337, 380, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFont(new Font("serif",Font.BOLD,18));
        back.addActionListener(this);
        add(back);
        
       
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==check){
            try{
                conn c = new conn() ;
                
                ResultSet rs2 = c.s.executeQuery("select * from customer where Number = '"+customer.getSelectedItem()+"'");
                
                while(rs2.next()){
                    String roomnum = rs2.getString("Room_Number");
                    ResultSet rs = c.s.executeQuery("select * from room where Room_Number = '"+roomnum+"'");
                
                while(rs.next()){
                    roomtext.setText(rs.getString("Room_Number"));
                    availabletext.setText(rs.getString("Available"));
                    cleantext.setText(rs.getString("Cleaning_Status"));
                    
                    
                }
                }
                
                
                
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==updatebutton){
            String roomt = roomtext.getText() ;
            String availablet = availabletext.getText() ;
            String cleant = cleantext.getText() ;
            
            
            try{
                conn c = new conn();
                
                c.s.executeUpdate("update room set Available = '"+availablet+"', Room_Number = '"+roomt+"',Cleaning_Status = '"+cleant+"' where Room_Number = '"+roomt+"'");
                
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
            }catch(Exception e){
                e.printStackTrace();
            }
            
            setVisible(false);
            new reception();
        }
        else{
            setVisible(false);
            new reception();
        }
        
    }
    

    public static void main(String args[]) {
        new updateroom();
    }

}