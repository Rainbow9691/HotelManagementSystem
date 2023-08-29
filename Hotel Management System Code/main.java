package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.* ;

public class main extends JFrame implements ActionListener{
    
    JMenuItem addemployee ,addroom,adddriver ,reception;

    main( ) {

        setLayout(null);
        setSize(1295, 800);
        setLocation(-7, 0);
        setVisible(true);
        getContentPane().setBackground(Color.black);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1290, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1290, 700);
        add(image);

        JLabel head = new JLabel("THE TAJ GROUP WELCOMES YOU");
        head.setBounds(300, 50, 700, 40);
        head.setFont(new Font("Raleway", Font.BOLD, 40));
        head.setForeground(Color.white);
        image.add(head);

        JMenuBar menu = new JMenuBar();
        menu.setBounds(0, 0, 1290, 30);
        // menu.setBackground(Color.black);
        image.add(menu);

        JMenu manage = new JMenu("HOTEL MANAGEMENT");
        manage.setForeground(Color.red);
        menu.add(manage);

        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.blue);
        menu.add(admin);
        
        reception = new JMenuItem("Reception");
        reception.addActionListener(this);
        manage.add(reception) ;
        
        addemployee = new JMenuItem("ADD EMPLOYEE");
        addemployee.addActionListener(this);
        admin.add(addemployee) ;
        
        addroom = new JMenuItem("ADD ROOM");
        addroom.addActionListener(this);
        admin.add(addroom) ;
        
        adddriver = new JMenuItem("ADD DRIVER");
        adddriver.addActionListener(this);
        admin.add(adddriver) ;

    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==addemployee){
//            setVisible(false);
//            new addemploye().setVisible(true);
              new addemploye() ;
        }
        else if(ae.getSource()==addroom){
        new addroom() ;
        }
        else if(ae.getSource()==adddriver){
            new adddriver();
        }
        else if(ae.getSource()==reception){
            new reception() ;
        }
    }
   

    public static void main(String args[]) {
        new main();
    }
}
