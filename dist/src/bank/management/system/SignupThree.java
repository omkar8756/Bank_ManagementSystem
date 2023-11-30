package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*; //random class
public class SignupThree extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    SignupThree(String formno){
        this.formno=formno;
        setSize(800,820);
        setLocation(350,0);
        setVisible(true);
        setLayout(null);
        //to change page color first select all by getContentPane() -->to select whole frame
        getContentPane().setBackground(Color.white);
       setTitle("Page for Account Details");
        JLabel l1=new JLabel("Page 3:Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        JLabel type=new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);
        
        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(100,180,150,20);
        r1.setBackground(Color.white);
        add(r1);
        
        r2=new JRadioButton("Current Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(350,180,150,20);
        r2.setBackground(Color.white);
        add(r2);
        
        r3=new JRadioButton("Fixed Deposit Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(100,220,200,20);
        r3.setBackground(Color.white);
        add(r3);
        
        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(350,220,250,20);
        r4.setBackground(Color.white);
        add(r4);
        
        ButtonGroup groupaccount=new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel card=new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,350,30);
        add(card);
        
        JLabel number=new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300,280,30);
        add(number);
        
        JLabel carddetail=new JLabel("Your 16 Digit card number");
        carddetail.setFont(new Font("Raleway",Font.BOLD,12));
        carddetail.setBounds(100,330,300,20);
        add(carddetail);
        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);
        
        JLabel pinnumber=new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pinnumber.setBounds(330,370,200,30);
        add(pinnumber);
        
        JLabel pindetail=new JLabel("Your 4 Digit Password");
        pindetail.setFont(new Font("Raleway",Font.BOLD,12));
        pindetail.setBounds(100,400,200,20);
        add(pindetail);
        
        JLabel services=new JLabel("Services Required:");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,440,240,30);
        add(services);
        
        c1=new JCheckBox("ATM Card");
        c1.setBounds(100,500,150,30);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBackground(Color.white);
        add(c1);
        
        c2=new JCheckBox("Internet Banking");
        c2.setBounds(300,500,150,30);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBackground(Color.white);
        add(c2);
        
        c3=new JCheckBox("Mobile Banking");
        c3.setBounds(100,550,150,30);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBackground(Color.white);
        add(c3);
        
        c4=new JCheckBox("Email & SMS Alert");
        c4.setBounds(300,550,200,30);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBackground(Color.white);
        add(c4);
        
        c5=new JCheckBox("Cheque Book");
        c5.setBounds(100,600,150,30);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBackground(Color.white);
        add(c5);
        
        c6=new JCheckBox("E-Statement");
        c6.setBounds(300,600,200,30);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBackground(Color.white);
        add(c6);
        
        c7=new JCheckBox("I Hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setBounds(100,670,640,25);
        c7.setFont(new Font("Raleway",Font.BOLD,13));
        c7.setBackground(Color.white);
        add(c7);
        
        submit=new JButton("Submit");
        submit.setFont(new Font("Raleway",Font.BOLD,13));
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBounds(250,720,110,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel=new JButton("Cancel");
        cancel.setFont(new Font("Raleway",Font.BOLD,13));
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(380,720,130,30);
        cancel.addActionListener(this);
        add(cancel);      
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==submit){
            String accounttype=null;
            if(r1.isSelected())
                accounttype="Saving Account";
            else if(r2.isSelected())
                accounttype="Current Account";
            else if(r3.isSelected())
                accounttype="Fixed Deposit Account";
            else if(r4.isSelected())
                accounttype="Recurring Deposit Account";
            //generate 16 digit account number randomly
            Random ran=new Random();
            String Cardnumber= ""+Math.abs((ran.nextLong()%90000000L)+5040936000000000L);  
            String pinnumber=""+Math.abs((ran.nextLong()%9000L)+1000L);
            String facility="";
            if(c1.isSelected()){
                facility+=" ATM Card";
            }
            else if(c2.isSelected()){
                facility+=" Internet Banking";
            }
            else if(c3.isSelected()){
                facility+=" Mobile Banking";
            }
            else if(c4.isSelected()){
                facility+=" Email & SMS Banking";
            }
            else if(c5.isSelected()){
                facility+=" Cheque Box";
            }
            else if(c6.isSelected()){
                facility+=" E-Statement";
            }
            //Database Connectivity
          try{
              //check that field is selected
              if(accounttype.equals("")){
                  JOptionPane.showMessageDialog(null,"Select Account type");
              }else{
               Conn c=new Conn();
               String Query1="Insert into signupthree values('"+formno+"','"+accounttype+"','"+Cardnumber+"','"+pinnumber+"','"+facility+"')";
               String Query2="Insert into login values('"+formno+"','"+Cardnumber+"','"+pinnumber+"')";
               c.s.executeUpdate(Query1);
               c.s.executeUpdate(Query2);
               JOptionPane.showMessageDialog(null,"Card Number: "+Cardnumber+"\nPin :"+pinnumber);
               //Can't create 0 balance account as created account in bank
                setVisible(false);
                new Deposit(pinnumber).setVisible(false);
              }
          }catch(Exception d){
              System.out.println(d);
          }          
        }
        else if(e.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String args[]) {
       new SignupThree("");
    }
}
