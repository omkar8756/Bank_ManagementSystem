package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;
public class FastCash extends JFrame implements ActionListener{
    //global declaration of buttons
    JButton Hun100,Two2000,Five500,Tho1000,Five5000,back,Ten10000;
    String pinnumber;
    FastCash(String pinnmber){
       this.pinnumber=pinnumber;
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT); //from java.awt
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,900,900);
       add(image);
       
       JLabel text=new JLabel("SELECT WITHDRAWL AMOUNT");
       text.setBounds(200,300,700,35);
       text.setFont(new Font("Raleway",Font.BOLD,16));
       text.setForeground(Color.white);
       image.add(text); //don't do add(text) -->add it on frame so it hides you have to add upon image so add on image object
       
       Hun100=new JButton("Rs 100");
       Hun100.setBounds(170,415,150,30);
       Hun100.addActionListener(this);
       image.add(Hun100);
       
       Five500=new JButton("Rs 500");
       Five500.setBounds(355,415,150,30);
       Five500.addActionListener(this);
       image.add(Five500);
       
       Tho1000=new JButton("Rs 1000");
       Tho1000.setBounds(170,450,150,30);
       Tho1000.addActionListener(this);
       image.add(Tho1000);
       
       Two2000=new JButton("Rs 2000");
       Two2000.setBounds(355,450,150,30);
       Two2000.addActionListener(this);
       image.add(Two2000);
       
       Five5000=new JButton("Rs 5000");
       Five5000.setBounds(170,485,150,30);
       Five5000.addActionListener(this);
       image.add(Five5000);
       
       Ten10000=new JButton("Rs 10000");
       Ten10000.setBounds(355,485,150,30);
       Ten10000.addActionListener(this); // to make know that this button is selected by ActionEvent
       image.add( Ten10000);
       
       back=new JButton("Back");
       back.setBounds(355,520,150,30);
       back.addActionListener(this);
       image.add(back);
       
       setTitle("FastCash page");
       setSize(900,900);
       setLocation(300,0);
       //setUndecorate() -->by default false and have to write above setVisible()
       setUndecorated(true);//to make above cross option,minimize option remove can come out by exit button
       setVisible(true);
       getContentPane().setBackground(Color.white);
    }
    //implementation of interface method
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else {
            //Debit amount 
           String Amount=((JButton)e.getSource()).getText().substring(3); //Rs 500 to get 500 only from string
           Conn c=new Conn();
           try{
               //check that is able to withdraw amount run query
               ResultSet rs=c.s.executeQuery("Select * from bank where Pin='"+pinnumber+"'");
               //check whether type is deposit or withdraw 
               int balance=0;
               while(rs.next()){
               if(rs.getString("Type").equals("Deposit"))
               balance+=Integer.parseInt(rs.getString("Amount"));
               else{
                   balance-=Integer.parseInt(rs.getString("Amount"));
               }
               //check whether back option is not selected or amount selected is less than current amount
               if(e.getSource()!=back&&balance<Integer.parseInt(Amount)){
                   JOptionPane.showMessageDialog(null,"Insufficient Balance");
                   return;
               }
               Date date=new Date();
               String query="Insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+Amount+"')";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Rs"+Amount+" debited Successfully");
               //goto transaction page after withdrawl
               setVisible(false);
               new Transaction(pinnumber).setVisible(true);
           }
           }catch(Exception d){
               System.out.println(d);
           }
           
        }
    }
    public static void main(String args[]) {
        new FastCash("");
    }
}
