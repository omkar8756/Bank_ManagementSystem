package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.awt.event.*;
import java.sql.*;
public class PinChange extends JFrame implements ActionListener{
    JButton back,change;
    JPasswordField pin,repin;
    String pinnumber;
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT); //from java.awt
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,900,900);
       add(image);
       
       JLabel text=new JLabel("CHANGE YOUR PIN");
       text.setBounds(250,280,500,35);
       text.setForeground(Color.white);
       text.setFont(new Font("Raleway",Font.BOLD,20));
       image.add(text); 
       
       JLabel pintext=new JLabel("NEW PIN:");
       pintext.setBounds(165,320,180,25);
       pintext.setForeground(Color.white);
       pintext.setFont(new Font("Raleway",Font.BOLD,16));
       image.add(pintext);
       
       pin=new JPasswordField();
       pin.setBounds(330,320,180,25);
       pin.setBackground(Color.white);
       pin.setFont(new Font("Raleway",Font.BOLD,16));
       image.add(pin);
       
       JLabel repintext=new JLabel("Re-Enter NEW PIN:");
       repintext.setBounds(165,360,240,25);
       repintext.setForeground(Color.white);
       repintext.setFont(new Font("Raleway",Font.BOLD,16));
       image.add(repintext); 
       
       repin=new JPasswordField();
       repin.setBounds(330,360,180,25);
       repin.setBackground(Color.white);
       repin.setFont(new Font("Raleway",Font.BOLD,16));
       image.add(repin);
       
       change=new JButton("CHANGE");
       change.setBounds(355,485,150,30);
       change.addActionListener(this);
       image.add(change);
       
       back=new JButton("BACK");
       back.setBounds(165,485,150,30);
       back.addActionListener(this);
       image.add(back);
       
       setTitle("PinChange page");
       setSize(900,900);
       setLocation(300,0);
       //setUndecorate() -->by default false and have to write above setVisible()
       setUndecorated(true);//to make above cross option,minimize option remove can come out by exit button
       setVisible(true);      
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else{
             try{
            String npin=pin.getText();
            String rpin=repin.getText();
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"Entered PIN Does not match");
                return ;
                }
               //Display user if press change button withou entering new pin
               if(npin.equals("")){
                   JOptionPane.showMessageDialog(null,"Please Enter New PIN");
                   return;
               }
                if(rpin.equals("")){
                   JOptionPane.showMessageDialog(null,"Please Re-Enter New PIN");
                   return;
               }
              //After all check when pin is eneterd and equals connect to database for updation
            Conn c=new Conn();
            String query1="update bank set Pin='"+rpin+"' where Pin='"+pinnumber+"'";
            String query2="update login set Pinnumber='"+rpin+"' where Pinnumber='"+pinnumber+"'";
            String query3="update signupthree set Pin_Number='"+rpin+"' where Pin_Number='"+pinnumber+"'";
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            c.s.executeUpdate(query3);
            JOptionPane.showMessageDialog(null,"PIN changed Successfully");
            setVisible(false);
            new Transaction(rpin).setVisible(true);
               
            }catch(Exception d){
              System.out.println(d);
              }
          
             
        }
       
    }
    public static void main(String args[]) {
        new PinChange("");
    }
}
