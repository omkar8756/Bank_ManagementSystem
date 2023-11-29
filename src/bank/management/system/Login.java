
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton login,clear,sign;
    JTextField t1;
    JPasswordField t2;
    Login(){
        setLayout(null);
       setTitle("Automated Teller Machine");//to set title to login page
       ImageIcon il=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
       Image i2=il.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
       //typecast i2 image object as can't added in JLabel class only ImageIcon can be added
       ImageIcon i3=new ImageIcon(i2);
       //to palce image over frame or Login page
       JLabel label=new JLabel(i3);
       //set location of image
       label.setBounds(70,10,100,100);
       add(label);
       JLabel text=new JLabel("Welcome to ATM");
       text.setFont(new Font("Osward",Font.BOLD,38));
       text.setBounds(200,40,400,40);
       add(text);
       //Cardno
       JLabel cardno=new JLabel("Card No:");
       cardno.setFont(new Font("Raleway",Font.BOLD,28));
       cardno.setBounds(120,150,150,30);
       add(cardno);
       t1=new JTextField();
       t1.setBounds(300,150,250,30);
       t1.setFont(new Font("Arial",Font.BOLD,14));
       add(t1);
       getContentPane().setBackground(Color.WHITE);
       //Pin
       JLabel pin=new JLabel("Pin:");
       pin.setFont(new Font("Raleway",Font.BOLD,28));
       pin.setBounds(120,220,400,40);
       add(pin);
       t2=new JPasswordField();
       t2.setBounds(300,220,250,30);
       add(t2);
       //Login Button
       login=new JButton("SIGN IN");
       login.setBounds(300,300,100,30);
       login.setBackground(Color.black);
       login.setForeground(Color.white);
       login.addActionListener(this);
       add(login);
       //Clear Button
        clear=new JButton("clear");
       clear.setBounds(450,300,100,30);
       clear.setBackground(Color.black);
       clear.setForeground(Color.white);
       clear.addActionListener(this);
       add(clear);
       //sign up button
       sign=new JButton("sign up");
       sign.setBounds(300, 380, 250, 30);
       sign.setBackground(Color.black);
       sign.setForeground(Color.white);
        sign.addActionListener(this);
       add(sign);
       setSize(800,480);//to give width and height of login page
       setVisible(true);//bydefault page is not visible so using this method it becomes visible
       setLocation(350,200);//by defalut frame opens at top-left(x=0,y=0) so to make according to our location
    }
    //overwrite interface method
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==clear){
            t1.setText("");
            t2.setText("");
        }
        else if(e.getSource()==login){
            Conn c=new Conn();
            String cardnumber=t1.getText();
            String pinnumber=t2.getText();
            String query="select * from login where Cardnumber='"+cardnumber+"' and Pinnumber='"+pinnumber+"'";
            //execute this query
            try{
                //check
                if(cardnumber.equals("")){
                    JOptionPane.showMessageDialog(null,"Enter Card number");
                }
                else if(pinnumber.equals("")){
                    JOptionPane.showMessageDialog(null,"Enter Pin");
                }
                //DDl command so execute executeQuery()-->return data also
                ResultSet rs= c.s.executeQuery(query);//ResultSet class in java.sql 
                //if data is return than make it to open Transaction page
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card number or Pin");
                }
            }catch(Exception d){
                System.out.println(d);
            }
        }
        else if(e.getSource()==sign){
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }     
 
    public static void main(String args[]) {
        // TODO code application logic here
        new Login();
    }
}
