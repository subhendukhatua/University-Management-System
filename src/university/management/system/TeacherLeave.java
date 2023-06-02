
package university.management.system;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;

public class TeacherLeave extends JFrame implements ActionListener{
    
    Choice cEmpId,ctime;
    JDateChooser dcdate;
    JButton submit,cancel;
    TeacherLeave(){
        
        
        
        setSize(500,550);
        setLocation(550,100);
        setLayout(null);
        
        getContentPane().setBackground(Color.white);
        
        JLabel heading = new JLabel("Apply Leave(Teacher)");
        heading.setBounds(60,50,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        
        
        JLabel lblrollno = new JLabel("Search by Employee ID");
        lblrollno.setBounds(60,100,200,20);
        lblrollno.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblrollno);
        
        
        
        cEmpId = new Choice();
        cEmpId.setBounds(60,130,200,20);
        add(cEmpId);
        
        
        
        try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()){
                cEmpId.add(rs.getString("empId"));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();   
        }
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60,180,200,20);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(60,210,200,25);
        add(dcdate);
        
        
        
        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(60,260,200,20);
        lbltime.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbltime);
        
        
        
        ctime = new Choice();
        ctime.setBounds(60,290,200,20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);
        
        
        //Submit Button
        submit = new JButton("Submit");
        submit.setBounds(60,350,100,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("serif", Font.BOLD,15));
        submit.addActionListener(this);
        add(submit);
        
        
        
        //Cacel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(200,350,100,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("serif", Font.BOLD,15));
        cancel.addActionListener(this);
        add(cancel);
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== submit){
            String empid = cEmpId.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();
            
            
            String query = "insert into teacherleave values('"+empid+"','"+date+"','"+duration+"')";
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
                
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }

   
    public static void main(String args[]) {
        new TeacherLeave();
    }
}
