package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;  //to use Date class of util package
public class Deposit extends JFrame implements ActionListener{
    //global declaration
    JButton back,deposit;
    JTextField amount;
    String pinnumber;
    Deposit(String pinnumber){
       this.pinnumber=pinnumber;
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT); //from java.awt
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,900,900);
       add(image);
       
       JLabel text=new JLabel("Enter your amount you want to deposit");
       text.setForeground(Color.white);
       text.setBounds(170,300,400,20);
       text.setFont(new Font("Raleway",Font.BOLD,16));
       image.add(text);
       
       amount=new JTextField();
       amount.setFont(new Font("Raleway",Font.BOLD,20));
       amount.setBounds(170,350,320,40);
       image.add(amount);
       
       deposit=new JButton("Deposit");
       deposit.setFont(new Font("Raleway",Font.BOLD,18));
       deposit.addActionListener(this);
       deposit.setBounds(355,485,150,30);
       image.add(deposit);
       
       back=new JButton("Back");
       back.setFont(new Font("Raleway",Font.BOLD,18));
       back.addActionListener(this);
       back.setBounds(170,485,150,30);
       image.add(back);
       
       setTitle("Deposit page");
       setSize(900,900);
       setLocation(300,0);
       setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        else if(e.getSource()==deposit){
            String Amount=amount.getText();
            Date date=new Date();
            if(Amount.equals("")){
              JOptionPane.showMessageDialog(null,"Please Enter the Amount you want to deposit");
              //goo back after depositing to transaction page
              setVisible(false);
              new Transaction(pinnumber).setVisible(true);
            }else{
                //Make Connection to database
                Conn c=new Conn();
                String query="Insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+Amount+"')";
                try{
                    c.s.executeUpdate(query);
                    //Display message to user when successfully amount is Deposited
                    JOptionPane.showMessageDialog(null,"Rs "+Amount+" is Deposited Successfully");
                }catch(Exception d){
                    System.out.println(d);
                }
            }
            
        }
    }
    public static void main(String args[]) {
        new Deposit("");
    }
}
