
package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;


public class StudentDetails  extends JFrame implements ActionListener{
    
    Choice crollno;
    JTable table;
    JButton search,print,update,add,cancel;
    
    StudentDetails(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        JLabel heading = new JLabel("Search by Roll Number ");
        heading.setBounds(20,20,150,20);
        add(heading);
        
        
        
        crollno = new Choice();
        crollno.setBounds(180,20,150,20);
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
        
        table = new JTable();
        
        try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception ex){
            ex.printStackTrace();   
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);
        
        add = new JButton("Add");
        add.setBounds(320,70,80,20);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(420,70,80,20);
        cancel.addActionListener(this);
        add(cancel);
        
        
        
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== search){
            String query = "select * from student where rollno = '"+crollno.getSelectedItem()+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs)); 
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
        }else if(e.getSource()==print){
            try{
                table.print();
                
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
        }else if(e.getSource()==update){
            new UpdateStudent();
            
        }else if(e.getSource()==add){
            setVisible(false);
            new AddStudent();
            
        }else{
            setVisible(false);
            
        }
    }

    
    public static void main(String args[]) {
        new StudentDetails();
        
    }
}
