
package hotel.management.system;

import java.awt.Color;
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

public class adddriver extends JFrame implements ActionListener{
    JTextField nametext,modeltext,agetext,locationtext ;
    JComboBox genderbox,availablebox ,cartext;
    JButton addroom,cancel ;
    
    adddriver(){
        setLayout(null);
        setSize(1020,550);
        setLocation(140,160);
        setVisible(true);
        getContentPane().setBackground(Color.white);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(465,330, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(470,90,465, 330);
        add(image);
        
        JLabel driver = new JLabel("Add Driver");
        driver.setBounds(130,25,150,30);
        driver.setFont(new Font("serif",Font.BOLD,30));
        add(driver);
        
        JLabel name = new JLabel("Name");
        name.setBounds(40,90,200,30);
        name.setFont(new Font("Raleway",Font.PLAIN,20));
        add(name);
        
        nametext = new JTextField();
        nametext.setBounds(240,90,200,30);
        add(nametext);
        
        JLabel age = new JLabel("Age");
        age.setBounds(40,140,200,30);
        age.setFont(new Font("Raleway",Font.PLAIN,20));
        add(age);
        
        agetext = new JTextField();
        agetext.setBounds(240,140,200,30);
        add(agetext);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(40,190,200,30);
        gender.setFont(new Font("Raleway",Font.PLAIN,20));
        add(gender);
        
        String gen[] = {"Male","Female"} ;
        
        genderbox = new JComboBox(gen);
        genderbox.setBounds (240, 190, 200, 30);
        genderbox.setBackground(Color.white);
        add(genderbox);
        
        JLabel carcompany = new JLabel("Car Company");
        carcompany.setBounds(40,240,200,30);
        carcompany.setFont(new Font("Raleway",Font.PLAIN,20));
        add(carcompany);
        
        String[] carcom = {"BMW","MERCEDES","SAFARI","FORTUNER","ENDEAVOR","HONDA CITY","INNOVA","HARRIER","VERNA"} ;
        
        cartext = new JComboBox(carcom);
        cartext.setBounds(240,240,200,30);
        cartext.setBackground(Color.white);
        add(cartext);
        
        JLabel carmodel = new JLabel("Car Model");
        carmodel.setBounds(40,290,200,30);
        carmodel.setFont(new Font("Raleway",Font.PLAIN,20));
        add(carmodel);
        
        modeltext = new JTextField();
        modeltext.setBounds(240,290,200,30);
        add(modeltext);
        
        JLabel available = new JLabel("Available");
        available.setBounds(40,340,200,30);
        available.setFont(new Font("Raleway",Font.PLAIN,20));
        add(available);
        
        String avail[] = {"Available","Not Available"} ;
        
        availablebox = new JComboBox(avail);
        availablebox.setBounds (240, 340, 200, 30);
        availablebox.setBackground(Color.white);
        add(availablebox);

        JLabel location = new JLabel("Location");
        location.setBounds(40,390,200,30);
        location.setFont(new Font("Raleway",Font.PLAIN,20));
        add(location);
        
        locationtext = new JTextField();
        locationtext.setBounds(240,390,200,30);
        add(locationtext);
        
        addroom = new JButton("Add Driver");
        addroom.setBounds(50,450,160, 35);
        addroom.setBackground(Color.black);
        addroom.setForeground(Color.white);
        addroom.setFont(new Font("serif",Font.BOLD,20));
        addroom.addActionListener(this);
        add(addroom);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(260,450,160,35);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("serif",Font.BOLD,23));
        cancel.addActionListener(this);
        add(cancel);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String namen = nametext.getText() ;
        String agen = agetext.getText() ;
        String gendern = (String)genderbox.getSelectedItem();
        String carn = (String)cartext.getSelectedItem();
        String modeln = modeltext.getText();
        String availablen = (String)availablebox.getSelectedItem();
        String locationn = locationtext.getText();
        
        
        if(ae.getSource()==addroom){
            conn c3  = new conn();
           try{ 
            if(namen.equals("")){
                JOptionPane.showMessageDialog(null, "Enter the Name!!!");
            }
            else if(agen.equals("")){
                JOptionPane.showMessageDialog(null, "Enter the Age!!!");
            }
            else if(carn.equals("")){
                JOptionPane.showMessageDialog(null, "Enter the Car Company!!!");
            }
            else if(modeln.equals("")){
                JOptionPane.showMessageDialog(null, "Enter the Car Model!!!");
            }
            else if(locationn.equals("")){
                JOptionPane.showMessageDialog(null, "Enter the Location!!!");
            }
            else{
                c3.s.executeUpdate("insert into driver values('"+namen+"','"+agen+"','"+gendern+"','"+carn+"','"+modeln+"','"+availablen+"','"+locationn+"')");
                
                JOptionPane.showMessageDialog(null, "Driver Added Successfully");
                
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
        new adddriver() ;
    }
    
}
