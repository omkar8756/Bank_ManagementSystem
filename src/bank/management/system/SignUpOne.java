package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*; //for Random class
import java.awt.event.*;//for ActionListener on click of button
import com.toedter.calendar.JDateChooser;
public class SignUpOne extends JFrame implements ActionListener{
    long random;
    JTextField namefield,fnamefield,emailfield,addressfield,cityfield,statefield,pincodefield;
    JDateChooser choose;
    JButton next;
    JRadioButton male,female,other,married,unmarried;
    SignUpOne(){
      Random ran=new Random();
      random=Math.abs((ran.nextLong()%9000L)+1000L);
      JLabel form=new JLabel("APPLICATION Form No. "+random);
      form.setFont(new Font("Arial",Font.BOLD,38));
      form.setBounds(140,20,600,40);
      add(form);
      setLayout(null);
      setTitle("Sign up page");
      setSize(850,800);
      setLocation(350,10);
      setVisible(true);
      JLabel personal=new JLabel("Page 1: Personal Details");
      personal.setBounds(290,80,400,30);
      personal.setFont(new Font("Arial",Font.BOLD,22));
      add(personal);
      
      JLabel name=new JLabel("Name:");
      name.setBounds(100,140,100,30);
      name.setFont(new Font("Raleway",Font.BOLD,20));
      add(name);
      namefield=new JTextField();
      namefield.setBounds(300,140,400,30);
      namefield.setFont(new Font("Arial",Font.BOLD,14));
      add(namefield);
      
      JLabel fname=new JLabel("Father's Name:");
      fname.setBounds(100,190,150,30);
      fname.setFont(new Font("Raleway",Font.BOLD,20));
      add(fname);
      fnamefield=new JTextField();
      fnamefield.setBounds(300,190,400,30);
      fnamefield.setFont(new Font("Arial",Font.BOLD,14));
      add(fnamefield);
      
      JLabel dob=new JLabel("Date of Birth:");
      dob.setBounds(100,240,170,30);
      dob.setFont(new Font("Raleway",Font.BOLD,20));
      add(dob);
      choose=new JDateChooser();
      choose.setBounds(300,240,400,30);
      add(choose);
      
      JLabel gender=new JLabel("Gender:");
      gender.setBounds(100,290,100,30);
      gender.setFont(new Font("Raleway",Font.BOLD,20));
      add(gender);
      male=new JRadioButton("Male");
      male.setBounds(300,290,60,30);
      male.setBackground(Color.white);
      add(male);
      female=new JRadioButton("Female");
      female.setBounds(450,290,120,30);
      female.setBackground(Color.white);
      add(female);
      //Group so that only one can be selected at a time
      ButtonGroup gendergroup=new ButtonGroup();
      gendergroup.add(male);
      gendergroup.add(female);
      
      JLabel email=new JLabel("Email Address:");
      email.setBounds(100,340,150,30);
      email.setFont(new Font("Raleway",Font.BOLD,20));
      add(email);
      emailfield=new JTextField();
      emailfield.setBounds(300,340,400,30);
      emailfield.setFont(new Font("Arial",Font.BOLD,14));
      add(emailfield);
      
      JLabel marital=new JLabel("Marital Status:");
      marital.setBounds(100,420,150,30);
      marital.setFont(new Font("Raleway",Font.BOLD,20));
      add(marital);
      married=new JRadioButton("Married");
      married.setBounds(300,420,80,30);
      married.setBackground(Color.white);
      add(married);
      unmarried=new JRadioButton("Unmarried");
      unmarried.setBounds(450,420,120,30);
      unmarried.setBackground(Color.white);
      add(unmarried);
      other=new JRadioButton("Other");
      other.setBounds(600,420,60,30);
      other.setBackground(Color.white);
      add(other);
      //Group so that only one can be selected at a time
      ButtonGroup maritalgroup=new ButtonGroup();
      maritalgroup.add(married);
      maritalgroup.add(unmarried);
      maritalgroup.add(other);
      
      JLabel address=new JLabel("Address:");
      address.setBounds(100,490,150,30);
      address.setFont(new Font("Raleway",Font.BOLD,20));
      add(address);
      addressfield=new JTextField();
      addressfield.setBounds(300,490,400,30);
      addressfield.setFont(new Font("Arial",Font.BOLD,14));
      add(addressfield);
      
      JLabel city=new JLabel("city:");
      city.setBounds(100,540,100,30);
      city.setFont(new Font("Raleway",Font.BOLD,20));
      add(city);
      cityfield=new JTextField();
      cityfield.setBounds(300,540,400,30);
      cityfield.setFont(new Font("Arial",Font.BOLD,14));
      add(cityfield);
      
      JLabel state=new JLabel("State:");
      state.setBounds(100,590,100,30);
      state.setFont(new Font("Raleway",Font.BOLD,20));
      add(state);
      statefield=new JTextField();
      statefield.setBounds(300,590,400,30);
      statefield.setFont(new Font("Arial",Font.BOLD,14));
      add(statefield);
      
      JLabel pincode=new JLabel("PinCode:");
      pincode.setBounds(100,640,100,30);
      pincode.setFont(new Font("Raleway",Font.BOLD,20));
      add(pincode);
      pincodefield=new JTextField();
      pincodefield.setBounds(300,640,400,30);
      pincodefield.setFont(new Font("Arial",Font.BOLD,14));
      add(pincodefield);
      
      next=new JButton("Next");
      next.setBounds(620,690,80,30);
      next.setBackground(Color.black);
      next.setForeground(Color.white);
      add(next);
      next.addActionListener(this);
      getContentPane().setBackground(Color.WHITE);
    }
    //implementation of interface abstract function
    public void actionPerformed(ActionEvent e){
        String formno=""+random;
        String Name=namefield.getText();
        String Fname=fnamefield.getText();
        String Email=emailfield.getText();
        String Dob=((JTextField)choose.getDateEditor().getUiComponent()).getText();
        String Gender=null;
        if(male.isSelected()){
            Gender="Male";
        }
        else if(female.isSelected()){
            Gender="Female";
        }
        String email=emailfield.getText();
        String marital=null;
        if(married.isSelected()){
            marital="Married";
        }
        else if(unmarried.isSelected()){
            marital="Unmarried";
        }
        else if(other.isSelected()){
            marital="Other";
        }
        String Address=addressfield.getText();
        String City=cityfield.getText();
        String State=statefield.getText();
        String Pincode=pincodefield.getText();
        //Database 
        try{
            if(Name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }
            else if(email.equals("")){
                 JOptionPane.showMessageDialog(null,"Email is Required");
            }
            else if(Address.equals("")){
                 JOptionPane.showMessageDialog(null,"Address is Required");
            }
            else if(City.equals("")){
                 JOptionPane.showMessageDialog(null,"City is Required");
            }
            else if(State.equals("")){
                 JOptionPane.showMessageDialog(null,"State is Required");
            }
            else if(Pincode.equals("")){
                 JOptionPane.showMessageDialog(null,"Pincode is Required");
            }
            else if(Fname.equals("")){
                 JOptionPane.showMessageDialog(null,"Father Name is Required");
            }
            else if(Dob.equals("")){
                 JOptionPane.showMessageDialog(null,"DOB is Required");
            }
            else if(marital.equals("")){
                 JOptionPane.showMessageDialog(null,"Marital status if Required");
            }
            else if(Gender.equals("")){
                 JOptionPane.showMessageDialog(null,"Gender is Required to be selected");
            }else{
                //Built connection with database
                Conn c=new Conn();
                String Query="Insert into signup values('"+formno+"','"+Name+"','"+Gender+"','"+email+"','"+State+"','"+City+"','"+Address+"','"+Dob+"','"+Fname+"','"+marital+"')";
                c.s.executeUpdate(Query);
                //when user enters successfully in signup page1 have to go next page2
                //make current page invisble then goto next by making it visible
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }catch(Exception b){
            System.out.println(b);
        }
        
    }
    public static void main(String args[]) {
        //Object of sinup class
        new SignUpOne();
    }
}
