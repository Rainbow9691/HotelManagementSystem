package hotel.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.* ;

public class reception extends JFrame implements ActionListener{

    JButton newcustomer, rooms, department, allemployee, customerinfo, managerinfo, checkout, updatestatus, updateroomstatus, pickupservice, searchroom, logout;

    reception() {
        setLayout(null);
        setSize(900, 560);
        setLocation(190, 140);
        setVisible(true);
        getContentPane().setBackground(Color.white);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/fourth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550, 470, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(280, 20, 550, 470);
        add(image);

        newcustomer = new JButton("New Customer Form");
        newcustomer.setBounds(20, 20, 230, 30);
        newcustomer.setBackground(Color.black);
        newcustomer.setForeground(Color.white);
        newcustomer.setFont(new Font("Raleway", Font.BOLD, 17));
        newcustomer.addActionListener(this);
        add(newcustomer);

        rooms = new JButton("Rooms");
        rooms.setBounds(20, 60, 230, 30);
        rooms.setBackground(Color.black);
        rooms.setForeground(Color.white);
        rooms.setFont(new Font("Raleway", Font.BOLD, 17));
        rooms.addActionListener(this);
        add(rooms);

        department = new JButton("Department");
        department.setBounds(20, 100, 230, 30);
        department.setBackground(Color.black);
        department.setForeground(Color.white);
        department.setFont(new Font("Raleway", Font.BOLD, 17));
        department.addActionListener(this);
        add(department);

        allemployee = new JButton("All Employee");
        allemployee.setBounds(20, 140, 230, 30);
        allemployee.setBackground(Color.black);
        allemployee.setForeground(Color.white);
        allemployee.setFont(new Font("Raleway", Font.BOLD, 17));
        allemployee.addActionListener(this);
        add(allemployee);

        customerinfo = new JButton("Customer Info");
        customerinfo.setBounds(20, 180, 230, 30);
        customerinfo.setBackground(Color.black);
        customerinfo.setForeground(Color.white);
        customerinfo.setFont(new Font("Raleway", Font.BOLD, 17));
        customerinfo.addActionListener(this);
        add(customerinfo);

        managerinfo = new JButton("Manager Info");
        managerinfo.setBounds(20, 220, 230, 30);
        managerinfo.setBackground(Color.black);
        managerinfo.setForeground(Color.white);
        managerinfo.setFont(new Font("Raleway", Font.BOLD, 17));
        managerinfo.addActionListener(this);
        add(managerinfo);

        checkout = new JButton("Checkout");
        checkout.setBounds(20, 260, 230, 30);
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.setFont(new Font("Raleway", Font.BOLD, 17));
        checkout.addActionListener(this);
        add(checkout);

        updatestatus = new JButton("Update Status");
        updatestatus.setBounds(20, 300, 230, 30);
        updatestatus.setBackground(Color.black);
        updatestatus.setForeground(Color.white);
        updatestatus.setFont(new Font("Raleway", Font.BOLD, 17));
        updatestatus.addActionListener(this);
        add(updatestatus);

        updateroomstatus = new JButton("Update Room Status");
        updateroomstatus.setBounds(20, 340, 230, 30);
        updateroomstatus.setBackground(Color.black);
        updateroomstatus.setForeground(Color.white);
        updateroomstatus.setFont(new Font("Raleway", Font.BOLD, 17));
        updateroomstatus.addActionListener(this);
        add(updateroomstatus);

        pickupservice = new JButton("Pickup Service");
        pickupservice.setBounds(20, 380, 230, 30);
        pickupservice.setBackground(Color.black);
        pickupservice.setForeground(Color.white);
        pickupservice.setFont(new Font("Raleway", Font.BOLD, 17));
        pickupservice.addActionListener(this);
        add(pickupservice);

        searchroom = new JButton("Search Room");
        searchroom.setBounds(20, 420, 230, 30);
        searchroom.setBackground(Color.black);
        searchroom.setForeground(Color.white);
        searchroom.setFont(new Font("Raleway", Font.BOLD, 17));
        searchroom.addActionListener(this);
        add(searchroom);

        logout = new JButton("Logout");
        logout.setBounds(20, 460, 230, 30);
        logout.setBackground(Color.black);
        logout.setForeground(Color.white);
        logout.setFont(new Font("Raleway", Font.BOLD, 17));
        logout.addActionListener(this);
        add(logout);

    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==newcustomer){
            setVisible(false);
            new addnewcustomer();
                    
        }
        else if(ae.getSource()==rooms){
            setVisible(false);
            new rooms() ;
        }
        else if(ae.getSource()==department){
            setVisible(false);
            new departments();
        }
        else if(ae.getSource()==allemployee){
            setVisible(false);
            new allemployee();
        }
        else if(ae.getSource()==customerinfo){
            setVisible(false);
            new customerinfo();
        }
        else if(ae.getSource()==managerinfo){
            setVisible(false);
            new managerinfo();
        }
        else if(ae.getSource()==checkout){
            setVisible(false);
            new checkout() ;
        }
        else if(ae.getSource()==updatestatus){
            setVisible(false);
            new updatestatus() ;
        }
        else if(ae.getSource()==updateroomstatus){
            setVisible(false);
            new updateroom() ;
        }
        else if(ae.getSource()==pickupservice){
            setVisible(false) ;
            new pickup() ;
        }
        else if(ae.getSource()==searchroom){
            setVisible(false);
            new searchroom() ;
        }
        else if(ae.getSource()==logout){
            setVisible(false);
            new login();
        }
    }

    public static void main(String args[]) {
        new reception();
    }

}
