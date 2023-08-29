package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Date ;
import java.awt.event.*;
import java.sql.* ;

public class addnewcustomer extends JFrame implements ActionListener {

    JTextField nametext, countrytext, numtext, depositetext, idtext;
    JComboBox allocatebox,idbox;
    JButton addcustomer, back;
    JRadioButton male, female;
    Date date;
    Choice allocateroom ;
    JLabel datetext ;

    addnewcustomer() {

        setLayout(null);
        setSize(900, 550);
        setLocation(190, 160);
        setVisible(true);
        getContentPane().setBackground(Color.white);

        Date date = new Date();

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(410, 430, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(480, 30, 410, 430);
        add(image);

        JLabel newcustomer = new JLabel("New Customer Form");
        newcustomer.setBounds(100, 7, 300, 30);
        newcustomer.setFont(new Font("serif", Font.BOLD, 30));
        newcustomer.setForeground(Color.blue);
        add(newcustomer);

        JLabel id = new JLabel("ID");
        id.setBounds(40, 70, 200, 30);
        id.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(id);
        
        String idn[] = {"Aadhar Card", "Passport","Driving License","Voter-id Card","Ration Card"};

        idbox = new JComboBox(idn);
        idbox.setBounds(260,70, 220, 30);
        idbox.setBackground(Color.white);
        add(idbox);

//        idtext = new JTextField();
//        idtext.setBounds(260, 70, 220, 30);
//        add(idtext);

        JLabel number = new JLabel("Number");
        number.setBounds(40, 110, 200, 30);
        number.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(number);

        numtext = new JTextField();
        numtext.setBounds(260, 110, 220, 30);
        add(numtext);

        JLabel name = new JLabel("Name");
        name.setBounds(40, 150, 200, 30);
        name.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(name);

        nametext = new JTextField();
        nametext.setBounds(260, 150, 220, 30);
        add(nametext);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(40, 190, 200, 30);
        gender.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(gender);

        male = new JRadioButton("MALE");
        male.setBounds(260, 190, 100, 30);
        male.setBackground(Color.white);
        male.setFont(new Font("Raleway", Font.BOLD, 15));
        add(male);

        female = new JRadioButton("FEMALE");
        female.setBounds(370, 190, 120, 30);
        female.setBackground(Color.white);
        female.setFont(new Font("Raleway", Font.BOLD, 15));
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel country = new JLabel("Country");
        country.setBounds(40, 230, 200, 30);
        country.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(country);

        countrytext = new JTextField();
        countrytext.setBounds(260, 230, 220, 30);
        add(countrytext);

        JLabel allocated = new JLabel("Allocated Room Number");
        allocated.setBounds(40, 270, 200, 30);
        allocated.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(allocated);

        allocateroom = new Choice();
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from room where Available = 'Available'");
            
            while(rs.next()){
                allocateroom.add(rs.getString("Room_Number"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        allocateroom.setBounds(260, 275, 220,30);
        add(allocateroom) ;

        JLabel checkin = new JLabel("Check-in-Time");
        checkin.setBounds(40, 310, 200, 30);
        checkin.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(checkin);

        String daten = "" + date;
        datetext = new JLabel(daten);
        datetext.setBounds(260, 310, 220, 30);
        datetext.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(datetext);

        JLabel deposit = new JLabel("Deposit");
        deposit.setBounds(40, 350, 200, 30);
        deposit.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(deposit);

        depositetext = new JTextField();
        depositetext.setBounds(260, 350, 220, 30);
        add(depositetext);

        addcustomer = new JButton("Add Customer");
        addcustomer.setBounds(60, 410, 160, 35);
        addcustomer.setBackground(Color.black);
        addcustomer.setForeground(Color.white);
        addcustomer.setFont(new Font("serif", Font.BOLD, 20));
        addcustomer.addActionListener(this);
        add(addcustomer);

        back = new JButton("Back");
        back.setBounds(290, 408, 160, 36);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFont(new Font("serif", Font.BOLD, 23));
        back.addActionListener(this);
        add(back);
    }

    public void actionPerformed(ActionEvent ae) {

        String namen = nametext.getText();
        String idnn = (String)idbox.getSelectedItem();
        String numn = numtext.getText();
        String countryn = countrytext.getText();
        String depositn = depositetext.getText();
        String datenn = datetext.getText();
        String gen = "";
        if (male.isSelected()) {
            gen = "Male";
        } else if (female.isSelected()) {
            gen = "Female";
        }
        
        String allocaten = (String)allocateroom.getSelectedItem();
        
        if(ae.getSource()==addcustomer){
            
            
          try{  
            if(namen.equals("")){
                JOptionPane.showMessageDialog(null, "Enter the name!!!");
            }
        
            else{
                conn c1 = new conn();
                 
                
               
                c1.s.executeUpdate("insert into customer values('"+idnn+"','"+numn+"','"+namen+"','"+gen+"','"+countryn+"','"+allocaten+"','"+datenn+"','"+depositn+"')");
                c1.s.executeUpdate("update room set Available = 'Occupied' where Room_Number = '"+allocaten+"'");
                JOptionPane.showMessageDialog(null, "Customer Added Successfully");
                setVisible(false);
                new reception();
                
                }
          }
                catch(Exception e){
                    e.printStackTrace();
                }
            
        }
        
        
        else if(ae.getSource()==back){
            setVisible(false);
                new reception();
        }

    }

    public static void main(String args[]) {

        new addnewcustomer();

    }

}
