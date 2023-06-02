
package university.management.system;
import java.awt.*;
import javax.swing.*;

public class About extends JFrame{
    
    About(){
        
        
        setSize(700,500);
        setLocation(400,150);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/my.jpG"));
        Image i2 = i1.getImage().getScaledInstance(150,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,300,200);
        add(image);
        
        
        JLabel heading = new JLabel("<html>College<br/>Management System</html>");
        heading.setBounds(70,20,350,130);
        heading.setFont(new Font("Tahoma", Font.BOLD,25));
        add(heading);
        
        JLabel name = new JLabel("Devloped By: Subhendu Khatua");
        name.setBounds(70,220,350,40);
        name.setFont(new Font("Tahoma", Font.BOLD,20));
        add(name);
        
        JLabel rollno = new JLabel("Roll No: 6511,Midnapore College(autonomous)");
        rollno.setBounds(70,280,500,40);
        rollno.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(rollno);
        
         JLabel contact = new JLabel("Email:Subhendukhatua143@gmaiil.com");
        contact.setBounds(70,330,400,40);
        contact.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(contact);
        
        
        
        setVisible(true);
        
    }

    
    public static void main(String args[]) {
        
        new About();
        
    }
}
