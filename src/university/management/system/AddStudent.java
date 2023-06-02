
package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddStudent extends JFrame implements ActionListener {
    
    JLabel labelrollno;
    JTextField tfname,tffname, tfaddress,tfphone,tfemail,tfx,tfxii,tfaadhar;
    JDateChooser dcdob;
    JComboBox cbcourse,cbbranch;
    JButton submit,cancel;
            
            
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong()%9000L)+ 1000L);
    
    AddStudent(){
        setLayout(null);
        
        setSize(900,700);
        setLocation(350,50);
        
        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("Raleway",Font.BOLD,30));
        add(heading);
        
        //Student Name
        JLabel lblname = new JLabel("Name:");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("Raleway",Font.BOLD,20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        //Father's name
        JLabel lblfname = new JLabel("Father's Name:");
        lblfname.setBounds(400,150,200,30);
        lblfname.setFont(new Font("Raleway",Font.BOLD,20));
        add(lblfname);
        
        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        //Roll no
        JLabel lblrollno= new JLabel("Roll Number:");
        lblrollno.setBounds(50,200,200,30);
        lblrollno.setFont(new Font("Raleway",Font.BOLD,20));
        add(lblrollno);
        
        labelrollno = new JLabel("2021"+ first4);
        labelrollno.setBounds(200,200,200,30);
        labelrollno.setFont(new Font("Raleway",Font.BOLD,20));
        add(labelrollno);
        
        //Date of birth
        JLabel lbldob= new JLabel("Date Of Birth:");
        lbldob.setBounds(400,200,200,30);
        lbldob.setFont(new Font("Raleway",Font.BOLD,20));
        add(lbldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(600,200,150,30);
        add(dcdob);
        
        
        //Address
        JLabel lbladdress = new JLabel("Address:");
        lbladdress.setBounds(50,250,200,30);
        lbladdress.setFont(new Font("Raleway",Font.BOLD,20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
        //Ph numner
         JLabel lblphone = new JLabel("Phone:");
        lblphone.setBounds(400,250,200,30);
        lblphone.setFont(new Font("Raleway",Font.BOLD,20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
        
        
        
        //Enail
        JLabel lblemail = new JLabel("Email Id:");
        lblemail.setBounds(50,300,200,30);
        lblemail.setFont(new Font("Raleway",Font.BOLD,20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);
        
        //Class X percentage
         JLabel lblx = new JLabel("Class X (%):");
        lblx.setBounds(400,300,200,30);
        lblx.setFont(new Font("Raleway",Font.BOLD,20));
        add(lblx);
        
        tfx = new JTextField();
        tfx.setBounds(600,300,150,30);
        add(tfx);
        
        
        //Class XII  percentage
        JLabel lblxii = new JLabel("Class XII (%):");
        lblxii.setBounds(50,350,200,30);
        lblxii.setFont(new Font("Raleway",Font.BOLD,20));
        add(lblxii);
        
        
        
        tfxii = new JTextField();
        tfxii.setBounds(200,350,150,30);
        add(tfxii);
        
        
        //Aadhar Number
        JLabel lblaadhar = new JLabel("Aadhar Number:");
        lblaadhar.setBounds(400,350,200,30);
        lblaadhar.setFont(new Font("Raleway",Font.BOLD,20));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(600,350,150,30);
        add(tfaadhar);
        
        //Course
        JLabel lblcourse = new JLabel("Course:");
        lblcourse.setBounds(50,400,200,30);
        lblcourse.setFont(new Font("Raleway",Font.BOLD,20));
        add(lblcourse);
        
        
        String course[] ={"BA","Bsc","MA","Msc","BCA","MCA","BBA","MBA","Bcom","MCom","B.Tech","M.Tech"}; 
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200,400,150,30);
        cbcourse.setBackground(Color.white);
        add(cbcourse);
        
        
        //Branch
        JLabel lblbranch = new JLabel("Branch:");
        lblbranch.setBounds(400,400,200,30);
        lblbranch.setFont(new Font("Raleway",Font.BOLD,20));
        add(lblbranch);
        
        
        String branch[] ={"Computer Science","Computer Application","English","Physics","Mathematics","History","Zoology","Botany","Physiology","Geography","Bengali","Chemistry"}; 
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(600,400,150,30);
        cbbranch.setBackground(Color.white);
        add(cbbranch);
        
        //Submit Button
        submit = new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("serif", Font.BOLD,15));
        submit.addActionListener(this);
        add(submit);
        
        
        
        //Cacel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("serif", Font.BOLD,15));
        cancel.addActionListener(this);
        add(cancel);
        
                

        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== submit){
            String name = tfname.getText();
            String fname = tffname.getText();
            String rollno = labelrollno.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String x = tfx.getText();
            String xii = tfxii.getText();
            String aadhar = tfaadhar.getText();
            String course =(String) cbcourse.getSelectedItem();
            String branch = (String)cbbranch.getSelectedItem();
            
            try{
                
                String query = "insert into student values('"+name+"', '"+fname+"','"+rollno+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+course+"','"+branch+"')";
                Conn con = new Conn();
                con.s.executeUpdate(query); 
                
                JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
                
                setVisible(false);
                
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
            
            
            
        }else{
            setVisible(false);
        
    }
    }

   
    public static void main(String args[]) {
        new AddStudent();
        
    }
}
