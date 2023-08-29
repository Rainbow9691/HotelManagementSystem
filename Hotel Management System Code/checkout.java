package hotel.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Date;

public class checkout extends JFrame implements ActionListener {

    Choice customer;
    JTextField amounttext, pendingtext;
    JButton check, checkoutbutton, back;
    JLabel roomtext, checkintext, checkouttext, deposittext, pricetext;

    checkout() {
        setLayout(null);
        setSize(1000, 550);
        setLocation(150, 160);
        getContentPane().setBackground(Color.white);
        setVisible(true);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/sixth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 330, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(490, 80, 450, 330);
        add(image);

        JLabel checkoutheading = new JLabel("Checkout");
        checkoutheading.setBounds(150, 20, 300, 30);
        checkoutheading.setFont(new Font("Raleway", Font.BOLD, 28));
        checkoutheading.setForeground(Color.blue);
        add(checkoutheading);

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
//                roomtext.setText(rs.getString("Room_Number"));
//                checkintext.setText(rs.getString("CheckIn_Time"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        add(customer);
        JLabel roomnum = new JLabel("Room Number");
        roomnum.setBounds(30, 140, 200, 30);
        roomnum.setFont(new Font("Raleway", Font.BOLD, 20));
        roomnum.setForeground(Color.black);
        add(roomnum);

        roomtext = new JLabel();
        roomtext.setBounds(260, 140, 200, 27);
        roomtext.setBackground(Color.white);
        roomtext.setFont(new Font("Raleway", Font.BOLD, 18));
        add(roomtext);

        JLabel checkin = new JLabel("CheckIn Time");
        checkin.setBounds(30, 190, 200, 30);
        checkin.setFont(new Font("Raleway", Font.BOLD, 20));
        checkin.setForeground(Color.black);
        add(checkin);

        checkintext = new JLabel();
        checkintext.setBounds(260, 190, 200, 27);
        checkintext.setBackground(Color.white);
        checkintext.setForeground(Color.green);
        checkintext.setFont(new Font("Raleway", Font.BOLD, 18));
        add(checkintext);

        

        JLabel checkout = new JLabel("Checkout Time");
        checkout.setBounds(30, 240, 200, 30);
        checkout.setFont(new Font("Raleway", Font.BOLD, 20));
        checkout.setForeground(Color.black);
        add(checkout);

        Date date = new Date();

        checkouttext = new JLabel("" + date);
        checkouttext.setBounds(260, 240, 200, 27);
        checkouttext.setBackground(Color.white);
        checkouttext.setForeground(Color.red);
        checkouttext.setFont(new Font("Raleway", Font.BOLD, 18));
        add(checkouttext);
        
        JLabel price = new JLabel("Room Price");
        price.setBounds(30, 290, 200, 30);
        price.setFont(new Font("Raleway", Font.BOLD, 20));
        price.setForeground(Color.black);
        add(price);

        pricetext = new JLabel();
        pricetext.setBounds(260, 290, 200, 27);
        pricetext.setBackground(Color.white);
        pricetext.setForeground(Color.black);
        pricetext.setFont(new Font("Raleway", Font.BOLD, 18));
        add(pricetext);
        
        JLabel deposit = new JLabel("Deposited Amount");
        deposit.setBounds(30, 340, 250, 30);
        deposit.setFont(new Font("Raleway", Font.BOLD, 20));
        deposit.setForeground(Color.black);
        add(deposit);

        deposittext = new JLabel();
        deposittext.setBounds(260, 340, 200, 27);
        deposittext.setBackground(Color.white);
        deposittext.setForeground(Color.black);
        deposittext.setFont(new Font("Raleway", Font.BOLD, 18));
        add(deposittext);

        check = new JButton("Check");
        check.setBounds(30, 410, 120, 30);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.setFont(new Font("serif", Font.BOLD, 18));
        check.addActionListener(this);
        add(check);

        checkoutbutton = new JButton("Checkout");
        checkoutbutton.setBounds(183, 410, 120, 30);
        checkoutbutton.setBackground(Color.red);
        checkoutbutton.setForeground(Color.black);
        checkoutbutton.setFont(new Font("serif", Font.BOLD, 18));
        checkoutbutton.addActionListener(this);
        add(checkoutbutton);

        back = new JButton("Back");
        back.setBounds(337, 410, 120, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFont(new Font("serif", Font.BOLD, 18));
        back.addActionListener(this);
        add(back);

    }

    public void actionPerformed(ActionEvent ae) {
         String str = customer.getSelectedItem();
        if (ae.getSource() == check) {
            
           

        try {
            conn c1 = new conn();

            ResultSet rs2 = c1.s.executeQuery("select * from customer where Number = '" + str + "' ");
            

            while (rs2.next()) {
                roomtext.setText(rs2.getString("Room_Number"));
                checkintext.setText(rs2.getString("CheckIn_Time"));
                deposittext.setText(rs2.getString("Deposit"));
            }
            
            ResultSet rs3 = c1.s.executeQuery("select * from room where Room_Number = '"+roomtext.getText()+"'");
            
            while(rs3.next()){
                pricetext.setText(rs3.getString("Price"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
            
//            try {
//                conn c = new conn();
//
//                ResultSet rs2 = c.s.executeQuery("select * from customer where Number = '" + customer.getSelectedItem() + "'");
//
//                while (rs2.next()) {
//                    String roomnum = rs2.getString("Room_Number");
//                    ResultSet rs = c.s.executeQuery("select * from room where Room_Number = '" + roomnum + "'");
//
//                    while (rs.next()) {
//                        roomtext.setText(rs.getString("Room_Number"));
//                        availabletext.setText(rs.getString("Available"));
//                        cleantext.setText(rs.getString("Cleaning_Status"));
//
//                    }
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        } else if (ae.getSource() == checkoutbutton) {
            String roomt = roomtext.getText();
            

            try {
                conn c = new conn();

                c.s.executeUpdate("delete from customer where Number = '"+customer.getSelectedItem()+"'");
                c.s.executeUpdate("update room set Available = 'Available' where Room_Number = '"+roomt+"'");
                JOptionPane.showMessageDialog(null, "Checkout Successfully");

               
            } catch (Exception e) {
                e.printStackTrace();
            }

            setVisible(false);
            new reception();
        } else {
            setVisible(false);
            new reception();
        }

    }

    public static void main(String args[]) {
        new checkout();
    }

}
