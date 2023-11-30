package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transaction extends JFrame implements ActionListener{
    //global declaration of buttons
    JButton deposit,withdrawl,pinchange,enquiry,fastcash,exit,ministatement;
    String pinnumber;
    Transaction(String pinnumber){
        this.pinnumber=pinnumber;
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT); //from java.awt
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,900,900);
       add(image);
       
       JLabel text=new JLabel("Please Select Your Transaction");
       text.setBounds(200,300,700,35);
       text.setFont(new Font("Raleway",Font.BOLD,16));
       text.setForeground(Color.white);
       image.add(text); //don't do add(text) -->add it on frame so it hides you have to add upon image so add on image object
       
       deposit=new JButton("Deposit");
       deposit.setBounds(170,415,150,30);
       deposit.addActionListener(this);
       image.add(deposit);
       
       withdrawl=new JButton(" Cash withdrawl");
       withdrawl.setBounds(355,415,150,30);
       withdrawl.addActionListener(this);
       image.add(withdrawl);
       
       fastcash=new JButton("Fast Cash");
       fastcash.setBounds(170,450,150,30);
       fastcash.addActionListener(this);
       image.add(fastcash);
       
       ministatement=new JButton("Mini Statement");
       ministatement.setBounds(355,450,150,30);
       ministatement.addActionListener(this);
       image.add(ministatement);
       
       pinchange=new JButton("Change Pin");
       pinchange.setBounds(170,485,150,30);
       pinchange.addActionListener(this);
       image.add(pinchange);
       
       enquiry=new JButton("Balance Enquiry");
       enquiry.setBounds(355,485,150,30);
       enquiry.addActionListener(this); // to make know that this button is selected by ActionEvent
       image.add(enquiry);
       
       exit=new JButton("Exit");
       exit.setBounds(355,520,150,30);
       exit.addActionListener(this);
       image.add(exit);
       
       setTitle("SignIn page");
       setSize(900,900);
       setLocation(300,0);
       //setUndecorate() -->by default false and have to write above setVisible()
       setUndecorated(true);//to make above cross option,minimize option remove can come out by exit button
       setVisible(true);
       getContentPane().setBackground(Color.white);
    }
    //implementation of interface method
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==exit){
            System.exit(0);
        }else if(e.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(e.getSource()==withdrawl){
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        }else if(e.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(e.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(e.getSource()==enquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(e.getSource()==ministatement){
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]) {
       new Transaction(""); 
    }
}
