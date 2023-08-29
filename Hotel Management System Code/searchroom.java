package hotel.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class searchroom extends JFrame implements ActionListener {

    JTable table;
    JPanel contentpane;
    JButton load, back;
    JComboBox bedlist;
    JCheckBox check;
    

    searchroom() {

        contentpane = new JPanel();
        contentpane.setLayout(null);
        contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentpane);
        setSize(800, 550);
        setLocation(250, 160);
        setVisible(true);
        getContentPane().setBackground(Color.white);

//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/eight.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(525, 450,Image.SCALE_DEFAULT );
//        ImageIcon i3 = new ImageIcon(i2);
//        
//        JLabel image = new JLabel(i3);
//        image.setBounds(530,30,525,450);
//        contentpane.add(image);
        JLabel search = new JLabel("Search Room");
        search.setBounds(320, 0, 180, 30);
        search.setFont(new Font("Raleway", Font.BOLD, 23));
        search.setForeground(Color.black);
        contentpane.add(search);

        JLabel bed = new JLabel("Room Bed Type");
        bed.setBounds(60, 60, 180, 30);
        bed.setFont(new Font("Raleway", Font.BOLD, 15));
        bed.setForeground(Color.black);
        contentpane.add(bed);

        String[] bedt = {"Single Bed", "Double Bed"};

        bedlist = new JComboBox(bedt);
        bedlist.setBounds(190, 63, 160, 25);
        bedlist.setBackground(Color.white);
        add(bedlist);

        check = new JCheckBox("Only Display Available");
        check.setBounds(460, 60, 250, 30);
        check.setBackground(Color.white);
        check.setFont(new Font("Raleway", Font.BOLD, 15));
        check.setForeground(Color.black);
        add(check);

        JLabel roomnum = new JLabel("Room Number");
        roomnum.setBounds(5, 120, 110, 30);
        roomnum.setFont(new Font("Raleway", Font.BOLD, 13));
        roomnum.setForeground(Color.red);
        contentpane.add(roomnum);

        JLabel available = new JLabel("Availablity");
        available.setBounds(165, 120, 1100, 30);
        available.setFont(new Font("Raleway", Font.BOLD, 13));
        available.setForeground(Color.red);
        contentpane.add(available);

        JLabel cleanstatus = new JLabel("Clean Status");
        cleanstatus.setBounds(325, 120, 110, 30);
        cleanstatus.setFont(new Font("Raleway", Font.BOLD, 13));
        cleanstatus.setForeground(Color.red);
        contentpane.add(cleanstatus);

        JLabel price = new JLabel("Price");
        price.setBounds(485, 120, 110, 30);
        price.setFont(new Font("Raleway", Font.BOLD, 13));
        price.setForeground(Color.red);
        contentpane.add(price);

        JLabel bedtype = new JLabel("Bed Type");
        bedtype.setBounds(645, 120, 110, 30);
        bedtype.setFont(new Font("Raleway", Font.BOLD, 13));
        bedtype.setForeground(Color.red);
        contentpane.add(bedtype);

        table = new JTable();
        table.setBounds(0, 150, 800, 200);
        add(table);
        try {
            conn c = new conn();

            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        load = new JButton("Submit");
        load.setBounds(200, 460, 150, 30);
        load.setFont(new Font("serif", Font.BOLD, 20));
        load.setBackground(Color.black);
        load.setForeground(Color.white);
        load.addActionListener(this);
        contentpane.add(load);

        back = new JButton("Back");
        back.setBounds(420, 460, 150, 30);
        back.setFont(new Font("serif", Font.BOLD, 20));
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        contentpane.add(back);

    }

    public void actionPerformed(ActionEvent ae) {

        String bedtext = (String) bedlist.getSelectedItem();
        if (ae.getSource()==load) {
            try {
                conn c1 = new conn();
                ResultSet rs ;
                if (check.isSelected()) {
                  rs =  c1.s.executeQuery("select * from room where Bed_Type = '" + bedtext + "' and Available = 'Available'");
                } else {

                  rs =  c1.s.executeQuery("select * from room where Bed_type = '" + bedtext + "'");
                }
                
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else if(ae.getSource()==back){
            setVisible(false);
            new reception();
        }
    }

    public static void main(String args[]) {
        new searchroom();
    }

}
