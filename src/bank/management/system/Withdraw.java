package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;  //for Date class
public class Withdraw extends JFrame implements ActionListener {
    //global declaration
    JButton back,withdraw;
    JTextField amount;
    String pinnumber;
    Withdraw(String Pinnumber){
       this.pinnumber=pinnumber;
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT); //from java.awt
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,900,900);
       add(image);
       
       JLabel text=new JLabel("Enter your amount you want to withdraw");
       text.setForeground(Color.white);
       text.setBounds(170,300,400,20);
       text.setFont(new Font("Raleway",Font.BOLD,16));
       image.add(text);
       
       amount=new JTextField();
       amount.setFont(new Font("Raleway",Font.BOLD,20));
       amount.setBounds(170,350,320,40);
       image.add(amount);
       
       withdraw=new JButton("Withdraw");
       withdraw.setFont(new Font("Raleway",Font.BOLD,18));
       withdraw.addActionListener(this);
       withdraw.setBounds(355,485,150,30);
       image.add(withdraw);
       
       back=new JButton("Back");
       back.setFont(new Font("Raleway",Font.BOLD,18));
       back.addActionListener(this);
       back.setBounds(170,485,150,30);
       image.add(back);
       
       setTitle("Withdraw page");
       setSize(900,900);
       setLocation(300,0);
       setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        else if(e.getSource()==withdraw){
            String Amount=amount.getText();
            Date date=new Date();
            if(Amount.equals("")){
              JOptionPane.showMessageDialog(null,"Please Enter the Amount you want to Withdraw");
              //goo back after depositing to transaction page
              setVisible(false);
              new Transaction(pinnumber).setVisible(true);
            }else{
                //Make Connection to database
                Conn c=new Conn();
                String query="Insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+Amount+"')";
                try{
                    c.s.executeUpdate(query);
                    //Display message to user when successfully amount is Withdraw
                    JOptionPane.showMessageDialog(null,"Rs "+Amount+" is Withdraw Successfully");
                }catch(Exception d){
                    System.out.println(d);
                }
            }
            
        }
    }
    
    public static void main(String args[]) {
         new Withdraw("");
    }
}
