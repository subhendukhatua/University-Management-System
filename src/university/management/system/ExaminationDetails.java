
package university.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ExaminationDetails extends JFrame implements ActionListener{
    
    JButton submit,cancel;
    JTextField search;
    JTable table;
    ExaminationDetails(){
        
        
        
        
        setSize(1000,475);
        setLocation(300,100);
        
        setLayout(null);
        
        getContentPane().setBackground(Color.white);
        
        
        JLabel heading = new JLabel("Check Result");
        heading.setBounds(80,15,400,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,24));
        add(heading);
        
        search = new JTextField();
        search.setBounds(80,90,200,30);
        search.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(search);
        
        
        //Submit Button
        submit = new JButton("Check Result");
        submit.setBounds(300,90,150,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("serif", Font.BOLD,15));
        submit.addActionListener(this);
        add(submit);
        
        
        
        //Cacel Button
        cancel = new JButton("Back");
        cancel.setBounds(470,90,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("serif", Font.BOLD,15));
        cancel.addActionListener(this);
        add(cancel);
        
        
        table = new JTable();
        table.setFont(new Font("Tahoma",Font.PLAIN,16));
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,130,1000,300);
        add(jsp);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row,2).toString());
            }
        });
        
        
        
        
        
        
        
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            setVisible(false);
            new Marks(search.getText());
            
            
        }else{
            setVisible(false);
        }
    }
          

   
    public static void main(String args[]) {
        new ExaminationDetails();
        
    }
}
