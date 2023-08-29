package hotel.management.system;

import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

public class startpage extends JFrame implements ActionListener {
    
    JButton next ;
    JLabel hotel ;
    
    startpage(){
        
        setLayout(null ) ;
        setSize(900,500);
        setVisible(true);
        setLocation(200,80);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(890, 465, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,890,465);
        add(image);
        
        next = new JButton("Next") ;
        next.setBounds(720, 390, 120,35);
        next.setBackground(Color.red);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,22));
        next.addActionListener(this);
        image.add(next);
        
        hotel = new JLabel("HOTEL MANAGEMENT SYSTEM");
        hotel.setBounds(30,390,700,40);
        hotel.setFont(new Font("serif",Font.PLAIN,35));
        hotel.setForeground(Color.white);
        image.add(hotel);
        
        while(true){
                hotel.setVisible(false);
                try{
                Thread.sleep(500);
            }
        
        catch(Exception e){
            e.printStackTrace();
        }
                hotel.setVisible(true);
    
        try{
           Thread.sleep(800);
            }
        
        catch(Exception e){
            e.printStackTrace();
        }
            }
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){
            setVisible(false);
            new login().setVisible(true);
        }
        
        
            
        
    }

    public static void main(String[] args) {
        new startpage();
    }
    
}
