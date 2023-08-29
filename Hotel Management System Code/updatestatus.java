package hotel.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.* ;

public class updatestatus extends JFrame implements ActionListener {

    Choice customer;
    JTextField roomtext,nametext,checktext,amounttext,pendingtext ;
    JButton check,updatebutton,back ;

    updatestatus() {
        setLayout(null);
        setSize(1000, 550);
        setLocation(150, 160);
        getContentPane().setBackground(Color.white);
        setVisible(true);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/nine.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,330,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(490,40,450, 400);
        add(image);

        JLabel update = new JLabel("Update Status");
        update.setBounds(120, 20, 200, 30);
        update.setFont(new Font("Raleway", Font.BOLD, 23));
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
        roomnum.setBounds(30, 140, 200, 30);
        roomnum.setFont(new Font("Raleway", Font.BOLD, 20));
        roomnum.setForeground(Color.black);
        add(roomnum);

        roomtext = new JTextField();
        roomtext.setBounds(260, 140, 200, 27);
        roomtext.setBackground(Color.white);
        add(roomtext);

        JLabel name = new JLabel("Name");
        name.setBounds(30, 190, 200, 30);
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setForeground(Color.black);
        add(name);

        nametext = new JTextField();
        nametext.setBounds(260, 190, 200, 27);
        nametext.setBackground(Color.white);
        add(nametext);

        JLabel checkin = new JLabel("CheckIn Time");
        checkin.setBounds(30, 240, 200, 30);
        checkin.setFont(new Font("Raleway", Font.BOLD, 20));
        checkin.setForeground(Color.black);
        add(checkin);

        checktext = new JTextField();
        checktext.setBounds(260, 240, 200, 27);
        checktext.setBackground(Color.white);
        add(checktext);

        JLabel amount = new JLabel("Amount Paid");
        amount.setBounds(30, 290, 200, 30);
        amount.setFont(new Font("Raleway", Font.BOLD, 20));
        amount.setForeground(Color.black);
        add(amount);

        amounttext = new JTextField();
        amounttext.setBounds(260, 290, 200, 27);
        amounttext.setBackground(Color.white);
        add(amounttext);

        JLabel pending = new JLabel("Pending Amount");
        pending.setBounds(30, 340, 200, 30);
        pending.setFont(new Font("Raleway", Font.BOLD, 20));
        pending.setForeground(Color.black);
        add(pending);

        pendingtext = new JTextField();
        pendingtext.setBounds(260, 340, 200, 27);
        pendingtext.setBackground(Color.white);
        add(pendingtext);

        check = new JButton("Check");
        check.setBounds(30, 420, 120, 30);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.setFont(new Font("serif",Font.BOLD,18));
        check.addActionListener(this);
        add(check);

        updatebutton = new JButton("Update");
        updatebutton.setBounds(183, 420, 120, 30);
        updatebutton.setBackground(Color.black);
        updatebutton.setForeground(Color.white);
        updatebutton.setFont(new Font("serif",Font.BOLD,18));
        updatebutton.addActionListener(this);
        add(updatebutton);

        back = new JButton("Back");
        back.setBounds(337, 420, 120, 30);
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
                ResultSet rs = c.s.executeQuery("select * from customer where Number = '"+customer.getSelectedItem()+"'");
                
                while(rs.next()){
                    roomtext.setText(rs.getString("Room_Number"));
                    nametext.setText(rs.getString("Name"));
                    checktext.setText(rs.getString("CheckIn_Time"));
                    amounttext.setText(rs.getString("Deposit"));
                    
                }
                
                ResultSet rs2 = c.s.executeQuery("select * from room where Room_Number = '"+roomtext.getText()+"'");
                
                while(rs2.next()){
                    String amountpend = rs2.getString("Price");
                   int pamount = Integer.parseInt(amountpend) - Integer.parseInt(amounttext.getText()) ;
                   pendingtext.setText(""+pamount);
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==updatebutton){
            String roomt = roomtext.getText() ;
            String namet = nametext.getText() ;
            String checkt = checktext.getText() ;
            String amountt = amounttext.getText() ;
            
            try{
                conn c = new conn();
                
                c.s.executeUpdate("update customer set Name = '"+namet+"', Room_Number = '"+roomt+"',CheckIn_Time = '"+checkt+"',Deposit = '"+amountt+"' where Number = '"+customer.getSelectedItem()+"'");
                
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
        new updatestatus();
    }

}
