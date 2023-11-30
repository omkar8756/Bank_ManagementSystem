package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class MiniStatement extends JFrame{
    String pinnumber;
    JButton back;
    MiniStatement(String pinnumber){
       this.pinnumber=pinnumber;
       
       JLabel mini=new JLabel();
       add(mini);
       
       JLabel bank=new JLabel("State Bank of India");
       bank.setBounds(130,20,150,20);
       bank.setFont(new Font("Raleway",Font.BOLD,16));
       add(bank);
       
       JLabel card=new JLabel();
       card.setBounds(20,80,300,20);
       add(card);
       
       JLabel Balance=new JLabel();
       Balance.setBounds(40,700,300,120);
       add(Balance);
       
       try{
         Conn c=new Conn();
         ResultSet rs = c.s.executeQuery("select * from login where Pinnumber='"+pinnumber+"'");
         while(rs.next()){
             card.setText("Card Number: "+rs.getString("Card_Number").substring(0,4)+"XXXXXXXX"+rs.getString("Card_Number").substring(12));
         }
       }catch(Exception d){
           System.out.println(d);
       }
       //similarly for all field 
        try{
         Conn c=new Conn();
         int balance=0;
         ResultSet rs = c.s.executeQuery("select * from bank where Pin='"+pinnumber+"'");
         while(rs.next()){
             mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Amount")+"<br><br><html>");
             //to get balance amount
              if(rs.getString("type").equals("Deposit"))
               balance+=Integer.parseInt(rs.getString("Amount"));
              else{
                   balance-=Integer.parseInt(rs.getString("Amount"));
               }
              Balance.setText("Your Current Account Balane is Rs "+balance);
         }
       }catch(Exception d){
           System.out.println(d);
       }mini.setBounds(20,140,400,200);
       
       setTitle("Mini Statement");
       setSize(400,600);
       setLocation(20,20);
//       setUndecorated(true);
       getContentPane().setBackground(Color.white);
       setVisible(true);
    }
    public static void main(String args[]) {
        new MiniStatement("");
    }
}
