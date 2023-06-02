
package university.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;


public class Marks extends JFrame implements ActionListener{
    
    String rollno;
    JButton cancel;
    
    Marks(String rollno){
        this.rollno = rollno;
        
        setSize(500,600);
        setLocation(500,100);
        
        
        
        setLayout(null);
        
        getContentPane().setBackground(Color.white);
        
        
        JLabel heading = new JLabel("Midnapore College(autonomous)");
        heading.setBounds(80,10,500,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        
        JLabel subheading = new JLabel("Result Of Examination-2023");
        subheading.setBounds(80,50,500,30);
        subheading.setFont(new Font("Raleway",Font.ITALIC,25));
        add(subheading);
        
        
        JLabel lblrollno = new JLabel("Roll Number"+ rollno);
        lblrollno.setBounds(60,100,500,20);
        lblrollno.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblrollno);
        
        JLabel lblsemester = new JLabel();
        lblsemester.setBounds(60,130,500,20);
        lblsemester.setFont(new Font("Raleway",Font.PLAIN,18));
        add(lblsemester);
        
        JLabel sub1 = new JLabel();
        sub1.setBounds(100,200,500,20);
        sub1.setFont(new Font("Raleway",Font.PLAIN,18));
        add(sub1);
        
        JLabel sub2 = new JLabel();
        sub2.setBounds(100,230,500,30);
        sub2.setFont(new Font("Raleway",Font.PLAIN,18));
        add(sub2);
        
        JLabel sub3 = new JLabel();
        sub3.setBounds(100,260,500,30);
        sub3.setFont(new Font("Raleway",Font.PLAIN,18));
        add(sub3);
        
        JLabel sub4 = new JLabel();
        sub4.setBounds(100,290,500,30);
        sub4.setFont(new Font("Raleway",Font.PLAIN,18));
        add(sub4);
        
        JLabel sub5 = new JLabel();
        sub5.setBounds(100,320,500,30);
        sub5.setFont(new Font("Raleway",Font.PLAIN,18));
        add(sub5);
        
        try{
            
            Conn c = new Conn();
            ResultSet rs1 = c.s.executeQuery("select *  from subject where rollno = '"+rollno+"'");
            while(rs1.next()){
                sub1.setText(rs1.getString("subject1"));
                sub2.setText(rs1.getString("subject2"));
                sub3.setText(rs1.getString("subject3"));
                sub4.setText(rs1.getString("subject4"));
                sub5.setText(rs1.getString("subject5"));
                
                
                
            }
            
             ResultSet rs2 = c.s.executeQuery("select *  from marks where rollno = '"+rollno+"'");
             while(rs2.next()){
                 sub1.setText(sub1.getText()+ "-------------"+rs2.getString("marks1"));
                 sub2.setText(sub2.getText()+ "-------------"+rs2.getString("marks2"));
                 sub3.setText(sub3.getText()+ "-------------"+rs2.getString("marks3"));
                 sub4.setText(sub4.getText()+ "-------------"+rs2.getString("marks4"));
                 sub5.setText(sub5.getText()+ "-------------"+rs2.getString("marks5"));
                 lblsemester.setText("semester--" + rs2.getString("semester"));
                 
             }
            
             
            
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
        
        
        //Cacel Button
        cancel = new JButton("Back");
        cancel.setBounds(250,500,120,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("serif", Font.BOLD,15));
        cancel.addActionListener(this);
        add(cancel);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        setVisible(true);
   
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }

    
    public static void main(String args[]) {
        new Marks("");
        
    }
}
