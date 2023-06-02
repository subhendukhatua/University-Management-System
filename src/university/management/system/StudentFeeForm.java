
package university.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class StudentFeeForm extends JFrame implements ActionListener{
    Choice crollno;
    JComboBox cbcourse,cbbranch,cbsemester;
    JLabel labeltotal;
    JButton update,pay,back;
    
    StudentFeeForm(){
        setLayout(null);
        setSize(900,500);
        setLocation(300,100);
        
        getContentPane().setBackground(Color.white);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpG"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);
        
         JLabel lblrollnumber = new JLabel("Select Roll Number ");
        lblrollnumber.setBounds(40,60,150,20);
        lblrollnumber.setFont(new Font("Raleway",Font.BOLD,16));
        add(lblrollnumber);
        
        
        
        crollno = new Choice();
        crollno.setBounds(200,60,150,20);
        add(crollno);
        
        
        
        try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();   
        }
        
        
        
        
        
        
        
        
        
        //Student Name
        JLabel lblname = new JLabel("Name:");
        lblname.setBounds(40,100,150,20);
        lblname.setFont(new Font("Raleway",Font.BOLD,16));
        add(lblname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(200,100,150,20);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelname);
        
        //Father's name
        JLabel lblfname = new JLabel("Father's Name:");
        lblfname.setBounds(40,140,150,20);
        lblfname.setFont(new Font("Raleway",Font.BOLD,16));
        add(lblfname);
        
        JLabel labelfname = new JLabel();
        labelfname.setBounds(200,140,150,20);
        labelfname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelfname);
        
        
        try{
            Conn c = new Conn();
            String query = "select * from student where rollno = '"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                
                
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
         
        }
        
        
        crollno.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c = new Conn();
                    String query = "select * from student where rollno = '"+crollno.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                        

                    }

                }catch(Exception ex){
                    ex.printStackTrace();

                }
                
            }
        });
        
        //Course
        JLabel lblcourse = new JLabel("Course:");
        lblcourse.setBounds(40,180,150,20);
        lblcourse.setFont(new Font("Raleway",Font.BOLD,16));
        add(lblcourse);
        
        
        String course[] ={"BA","B.sc","MA","M.sc","BCA","MCA","BBA","MBA","Bcom","MCom","B.Tech","M.Tech"}; 
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200,180,150,20);
        cbcourse.setBackground(Color.white);
        add(cbcourse);
        
        
        //Branch
        JLabel lblbranch = new JLabel("Branch:");
        lblbranch.setBounds(40,220,150,20);
        lblbranch.setFont(new Font("Raleway",Font.BOLD,16));
        add(lblbranch);
        
        
        String branch[] ={"Computer Science","Computer Application","English","Physics","Mathematics","History","Zoology","Botany","Physiology","Geography","Bengali","Chemistry"}; 
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(200,220,150,20);
        cbbranch.setBackground(Color.white);
        add(cbbranch);
        
        
        JLabel lblsemester = new JLabel("Semester");
        lblsemester.setBounds(40,260,150,20);
        lblsemester.setFont(new Font("Raleway",Font.BOLD,16));
        add(lblsemester);
        
        
        String semester[]= {"Semester1","Semester2","Semester3","Semester4","Semester5","Semester6"};
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(200,260,150,20);
        cbsemester.setBackground(Color.white);
        add(cbsemester);
        
        JLabel lbltotal = new JLabel("Total Payable");
        lbltotal.setBounds(40,300,150,20);
        lbltotal.setFont(new Font("Raleway",Font.BOLD,16));
        add(lbltotal);
        
        labeltotal = new JLabel();
        labeltotal.setBounds(200,300,150,20);
        labeltotal.setFont(new Font("Raleway",Font.PLAIN,16));
        add(labeltotal);
        
        
        //Submit Button
        update = new JButton("Update");
        update.setBounds(30,380,100,25);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setFont(new Font("serif", Font.BOLD,15));
        update.addActionListener(this);
        add(update);
        
        
        
        //Cacel Button
        pay = new JButton("Pay Fee");
        pay.setBounds(150,380,100,25);
        pay.setBackground(Color.black);
        pay.setForeground(Color.white);
        pay.setFont(new Font("serif", Font.BOLD,15));
        pay.addActionListener(this);
        add(pay);
        
        
        //Back Button 
        back = new JButton("Back");
        back.setBounds(270,380,100,25);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFont(new Font("serif", Font.BOLD,15));
        back.addActionListener(this);
        add(back);
        
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()== update){
            
            String course = (String)cbcourse.getSelectedItem();
            String semester = (String)cbsemester.getSelectedItem();
            try{
                
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from fee where course = '"+course+"'");
                while(rs.next()){
                    
                    labeltotal.setText(rs.getString(semester));
                    
                }
                
                
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
            
        }else if(ae.getSource()== pay){
            
            String rollno = crollno.getSelectedItem();
            String course = (String)cbcourse.getSelectedItem();
            String semester = (String)cbsemester.getSelectedItem();
            String branch = (String)cbbranch.getSelectedItem();
            String total = labeltotal.getText();
            
            try{
                
                Conn c = new Conn();
                String query = "insert into collegefee values('"+rollno+"','"+course+"','"+branch+"','"+semester+"','"+total+"')";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "College Fee Submitted Successfully");
                setVisible(false);
            
               
                
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
            
        }else{
            setVisible(false);
            
        }
    }

    
    public static void main(String args[]) {
        new StudentFeeForm();
       
    }
}
