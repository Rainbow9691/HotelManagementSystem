package hotel.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class pickup extends JFrame implements ActionListener {

    JTable table;
    JPanel contentpane;
    JButton load, back;
    Choice carlist;
    JCheckBox check;
    

    pickup() {

        contentpane = new JPanel();
        contentpane.setLayout(null);
        contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentpane);
        setSize(1100, 550);
        setLocation(100, 160);
        setVisible(true);
        getContentPane().setBackground(Color.white);

//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/eight.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(525, 450,Image.SCALE_DEFAULT );
//        ImageIcon i3 = new ImageIcon(i2);
//        
//        JLabel image = new JLabel(i3);
//        image.setBounds(530,30,525,450);
//        contentpane.add(image);
        JLabel search = new JLabel("Pickup Service");
        search.setBounds(470, 0, 180, 30);
        search.setFont(new Font("Raleway", Font.BOLD, 23));
        search.setForeground(Color.black);
        contentpane.add(search);

        JLabel cartype = new JLabel("Car Type");
        cartype.setBounds(160, 60, 80, 30);
        cartype.setFont(new Font("Raleway", Font.BOLD, 15));
        cartype.setForeground(Color.black);
        contentpane.add(cartype);
       
        carlist = new Choice() ;
        carlist.setBounds(250, 68, 160, 25);
        carlist.setBackground(Color.white);
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            
            while(rs.next()){
             carlist.add(rs.getString("Car_Company"));
               
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        add(carlist);

        check = new JCheckBox("Only Display Available");
        check.setBounds(710, 60, 250, 30);
        check.setBackground(Color.white);
        check.setFont(new Font("Raleway", Font.BOLD, 15));
        check.setForeground(Color.black);
        add(check);

        JLabel name = new JLabel("Name");
        name.setBounds(7, 120, 110, 30);
        name.setFont(new Font("Raleway", Font.BOLD, 13));
        name.setForeground(Color.red);
        contentpane.add(name);

        JLabel age = new JLabel("Age");
        age.setBounds(157, 120, 1100, 30);
        age.setFont(new Font("Raleway", Font.BOLD, 13));
        age.setForeground(Color.red);
        contentpane.add(age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(314, 120, 110, 30);
        gender.setFont(new Font("Raleway", Font.BOLD, 13));
        gender.setForeground(Color.red);
        contentpane.add(gender);

        JLabel company = new JLabel("Car_Company");
        company.setBounds(471, 120, 110, 30);
        company.setFont(new Font("Raleway", Font.BOLD, 13));
        company.setForeground(Color.red);
        contentpane.add(company);

        JLabel model = new JLabel("Car_Model");
        model.setBounds(628, 120, 110, 30);
        model.setFont(new Font("Raleway", Font.BOLD, 13));
        model.setForeground(Color.red);
        contentpane.add(model);
        
        JLabel available = new JLabel("Available");
        available.setBounds(785, 120, 110, 30);
        available.setFont(new Font("Raleway", Font.BOLD, 13));
        available.setForeground(Color.red);
        contentpane.add(available);
        
        JLabel location = new JLabel("Location");
        location.setBounds(942, 120, 110, 30);
        location.setFont(new Font("Raleway", Font.BOLD, 13));
        location.setForeground(Color.red);
        contentpane.add(location);

        table = new JTable();
        table.setBounds(0, 150, 1100, 200);
        add(table);
        try {
            conn c = new conn();

            ResultSet rs = c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        load = new JButton("Submit");
        load.setBounds(350, 460, 150, 30);
        load.setFont(new Font("serif", Font.BOLD, 20));
        load.setBackground(Color.black);
        load.setForeground(Color.white);
        load.addActionListener(this);
        contentpane.add(load);

        back = new JButton("Back");
        back.setBounds(620, 460, 150, 30);
        back.setFont(new Font("serif", Font.BOLD, 20));
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        contentpane.add(back);

    }

    public void actionPerformed(ActionEvent ae) {

        String cartext = (String) carlist.getSelectedItem();
        if (ae.getSource()==load) {
            try {
                conn c1 = new conn();
                ResultSet rs ;
                if (check.isSelected()) {
                  rs =  c1.s.executeQuery("select * from driver where Car_Company = '" + cartext + "' and Available = 'Available'");
                } else {

                  rs =  c1.s.executeQuery("select * from driver where Car_Company = '" + cartext + "'");
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
        new pickup();
    }

}
