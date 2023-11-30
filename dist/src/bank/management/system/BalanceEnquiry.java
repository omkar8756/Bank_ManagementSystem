package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class BalanceEnquiry extends JFrame implements ActionListener{
    JButton back;
    String pinnumber;
    BalanceEnquiry(String pinnumber){
        this.pinnumber=pinnumber;
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT); //from java.awt
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,900,900);
       add(image);
       
       back=new JButton("Back");
       back.setBounds(165,520,150,30);
       back.addActionListener(this);
       image.add(back);
       
       //display balance
        int balance=0;
       Conn c=new Conn();
           try{
               //check that is able to withdraw amount run query
               ResultSet rs=c.s.executeQuery("Select * from bank where Pin='"+pinnumber+"'");
               //check whether type is deposit or withdraw 
              while(rs.next()){
                if(rs.getString("type").equals("Deposit"))
                balance+=Integer.parseInt(rs.getString("Amount"));
                else{
                   balance-=Integer.parseInt(rs.getString("Amount"));
                }
              }
           }catch(Exception d){
                       System.out.println(d);
                    }
         JLabel text=new JLabel("Your Current Account Balance is Rs "+balance);
         text.setForeground(Color.white);
         text.setBounds(170,300,400,30);
         image.add(text);
       
       setTitle("Balance Enquiry");
       setSize(900,900);
       setLocation(300,0);
       setUndecorated(true);
       setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
    public static void main(String args[]) {
        new BalanceEnquiry("");
    }
}
