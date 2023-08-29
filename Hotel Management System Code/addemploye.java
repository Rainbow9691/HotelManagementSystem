
package hotel.management.system;

import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

public class addemploye extends JFrame implements ActionListener {
    
    JTextField nametext,agetext,salarytext,phonetext,emailtext,adhartext ;
    JRadioButton male,female ;
    JComboBox jobn ;
    JButton submit ;
    
    addemploye(){
        setLayout(null);
        setSize(900,550);
        setLocation(190,160);
        setVisible(true);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2) ;
        getContentPane().setBackground(Color.white);
        
        JLabel image = new JLabel(i3);
        image.setBounds(450,0, 400, 500);
        add(image);
        
        JLabel name = new JLabel("NAME");
        name.setBounds(60,20,100, 30);
        name.setFont(new Font("Raleway",Font.BOLD,24));
        add(name);
        
        nametext = new JTextField();
        nametext.setBounds(230, 20, 200, 30);
        add(nametext);
        
        JLabel age = new JLabel("AGE");
        age.setBounds(60,70,100, 30);
        age.setFont(new Font("Raleway",Font.BOLD,24));
        add(age);
        
        agetext = new JTextField();
        agetext.setBounds(230,70, 200, 30);
        add(agetext);
        
        JLabel gender = new JLabel("GENDER");
        gender.setBounds(60,120,150, 30);
        gender.setFont(new Font("Raleway",Font.BOLD,24));
        add(gender);
        
        JLabel job = new JLabel("JOB");
        job.setBounds(60,170,100, 30);
        job.setFont(new Font("Raleway",Font.BOLD,24));
        add(job);
        
        JLabel salary = new JLabel("SALARY");
        salary.setBounds(60,220,150, 30);
        salary.setFont(new Font("Raleway",Font.BOLD,24));
        add(salary);
        
        salarytext = new JTextField();
        salarytext.setBounds(230,220, 200, 30);
        add(salarytext);
        
        JLabel phone = new JLabel("PHONE");
        phone.setBounds(60,270,130, 30);
        phone.setFont(new Font("Raleway",Font.BOLD,24));
        add(phone);
        
        phonetext = new JTextField();
        phonetext.setBounds(230,270, 200, 30);
        add(phonetext);
        
        JLabel email = new JLabel("E-MAIL");
        email.setBounds(60,320,150, 30);
        email.setFont(new Font("Raleway",Font.BOLD,24));
        add(email);
        
        emailtext = new JTextField();
        emailtext.setBounds(230,320, 200, 30);
        add(emailtext);
        
        JLabel adhar = new JLabel("AADHAR");
        adhar.setBounds(60,370,150, 30);
        adhar.setFont(new Font("Raleway",Font.BOLD,24));
        add(adhar);
        
        adhartext = new JTextField();
        adhartext.setBounds(230,370, 200, 30);
        add(adhartext);
        
        male = new JRadioButton("MALE");
        male.setBounds(230,120,100, 30);
        male.setBackground(Color.white);
        male.setFont(new Font("Raleway",Font.BOLD,15));
        add(male);
        
        female = new JRadioButton("FEMALE");
        female.setBounds(330,120,120, 30);
        female.setBackground(Color.white);
        female.setFont(new Font("Raleway",Font.BOLD,15));
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();  
        gendergroup.add(male);
        gendergroup.add(female);
        
        String jobs[] = {"Front Desk Clerks","Porters","HouseKeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
        jobn = new JComboBox(jobs) ;
        jobn.setBounds(230,170, 200, 30);
        jobn.setBackground(Color.white);
        add(jobn);
        
        submit = new JButton("SUBMIT");
        submit.setBounds(230,440,200,35);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("serif",Font.BOLD,22));
        submit.addActionListener(this);
        add(submit);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String nametextn = nametext.getText() ;
        String agetextn = agetext.getText() ;
        String salarytextn = salarytext.getText() ;
        String phonetextn = phonetext.getText() ;
        String emailtextn = emailtext.getText() ;
        String adhartextn = adhartext.getText() ;
        String jobtext = (String)jobn.getSelectedItem() ;
        
        String gen = "" ;
        if(male.isSelected()){
            gen = "male" ;
        }
        else if(female.isSelected()){
            gen = "female" ;
        }
        if(ae.getSource()==submit){
        if(nametext.equals("")){
            JOptionPane.showMessageDialog(null, "Name field is required!!!");
        }
        else if(agetext.equals("")){
            JOptionPane.showMessageDialog(null, "Age field is required!!!");
        }
        else if(gen.equals("")){
            JOptionPane.showMessageDialog(null, "Please select gender!!!");
        }
        else if(salarytext.equals("")){
            JOptionPane.showMessageDialog(null, "Salary field is require!!!");
        }
        else if(phonetext.equals("")){
            JOptionPane.showMessageDialog(null, "Phone field is required!!!");
        }
        else if(emailtext.equals("")){
            JOptionPane.showMessageDialog(null, "Email field is required!!!");
        }
        else if(adhartext.equals("")){
            JOptionPane.showMessageDialog(null, "Aadhar field is required!!!");
        }
        
        else{
            conn c1 = new conn();
            try{
            String q1 =  "insert into employee values('"+nametextn+"','"+agetextn+"','"+gen+"','"+jobtext+"','"+salarytextn+"','"+phonetextn+"','"+emailtextn+"','"+adhartextn+"')";
            
            c1.s.executeUpdate(q1) ;
            
            JOptionPane.showMessageDialog(null, "Employee Added Successfully");
            setVisible(false);
            
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
        }
    }
        
    
    
    public static void main(String args[]){
      new addemploye();
    }
}
