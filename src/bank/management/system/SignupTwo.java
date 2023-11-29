package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//for ActionListener on click of button
public class SignupTwo extends JFrame implements ActionListener{
    JTextField aadharfield,pan;
    JButton next;
    JComboBox religion,category,income,education,occupation;
    JRadioButton existyes,existno,senioryes,seniorno;
    String formno;
    SignupTwo(String formno){
        this.formno=formno;
      setLayout(null);
      setTitle("NEW ACCOUNT APPLICATION - Page 2");
      setSize(850,830);
      setLocation(350,10);
      setVisible(true);
      JLabel personal=new JLabel("Page 2: Additional Details");
      personal.setBounds(290,80,400,30);
      personal.setFont(new Font("Arial",Font.BOLD,22));
      add(personal);
      
      JLabel name=new JLabel("Religion:");
      name.setBounds(100,140,100,30);
      name.setFont(new Font("Raleway",Font.BOLD,20));
      add(name);
      String valreligion[]={"","Hindu","Muslim","Sikh","Christian","Other"};
      religion=new JComboBox(valreligion);
      religion.setBounds(300,140,400,30);
      religion.setFont(new Font("Arial",Font.BOLD,14));
      add(religion);
      
      JLabel fname=new JLabel("Category:");
      fname.setBounds(100,190,150,30);
      fname.setFont(new Font("Raleway",Font.BOLD,20));
      add(fname);
      String valcategory[]={"","General","General EWS","OBC","SC","ST","Other"};
      category=new JComboBox(valcategory);
      category.setBounds(300,190,400,30);
      category.setFont(new Font("Arial",Font.BOLD,14));
      add(category);
      
      JLabel dob=new JLabel("Income:");
      dob.setBounds(100,240,170,30);
      dob.setFont(new Font("Raleway",Font.BOLD,20));
      add(dob);
      String valincome[]={"","Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
      income=new JComboBox(valincome);
      income.setBounds(300,240,400,30);
      add(income);
      
      JLabel gender=new JLabel("Educational");
      gender.setBounds(100,290,150,30);
      gender.setFont(new Font("Raleway",Font.BOLD,20));
      add(gender);
      
      JLabel email=new JLabel("Qualification:");
      email.setBounds(100,310,150,30);
      email.setFont(new Font("Raleway",Font.BOLD,20));
      add(email);
      String []valeducation={"","Post Graduate","Under Graduate","Doctrate","Higher Secondary passed","Matrix Passed","Student","Other"};
      education=new JComboBox(valeducation);
      education.setBounds(300,310,400,30);
      education.setFont(new Font("Arial",Font.BOLD,14));
      add(education);
      
      JLabel marital=new JLabel("Occupation:");
      marital.setBounds(100,370,150,30);
      marital.setFont(new Font("Raleway",Font.BOLD,20));
      add(marital);
      String valoccupation[]={"","Engineer","Doctor","Business Man","Teacher","Manager","Other"};
      occupation=new JComboBox(valoccupation);
      occupation.setBounds(300,370,400,30);
      occupation.setFont(new Font("Arial",Font.BOLD,14));
      add(occupation);
      
      JLabel address=new JLabel("PAN Number:");
      address.setBounds(100,450,150,30);
      address.setFont(new Font("Raleway",Font.BOLD,20));
      add(address);
      pan=new JTextField();
      pan.setBounds(300,450,400,30);
      pan.setFont(new Font("Arial",Font.BOLD,14));
      add(pan);
      
      JLabel aadhar=new JLabel("Aadhar Number:");
      aadhar.setBounds(100,500,190,30);
      aadhar.setFont(new Font("Raleway",Font.BOLD,20));
      add(aadhar);
      aadharfield=new JTextField();
      aadharfield.setBounds(300,500,400,30);
      aadharfield.setFont(new Font("Arial",Font.BOLD,14));
      add(aadharfield);
      
      JLabel pincode=new JLabel("Senior Citizen:");
      pincode.setBounds(100,550,150,30);
      pincode.setFont(new Font("Raleway",Font.BOLD,20));
      add(pincode);
      senioryes=new JRadioButton("Yes");
      senioryes.setBounds(300,550,80,30);
      senioryes.setFont(new Font("Raleway",Font.BOLD,18));
      senioryes.setBackground(Color.white);
      add(senioryes);
      seniorno=new JRadioButton("No");
      seniorno.setBounds(450,550,80,30);
      seniorno.setFont(new Font("Raleway",Font.BOLD,18));
      seniorno.setBackground(Color.white);
      add(seniorno);
      ButtonGroup seniorgroup=new ButtonGroup();
      seniorgroup.add(senioryes);
      seniorgroup.add(seniorno);
      
      JLabel exist=new JLabel("Existing Account:");
      exist.setBounds(100,600,190,30);
      exist.setFont(new Font("Raleway",Font.BOLD,20));
      add(exist);
      existyes=new JRadioButton("Yes");
      existyes.setBounds(300,600,80,30);
      existyes.setFont(new Font("Raleway",Font.BOLD,18));
      existyes.setBackground(Color.white);
      add(existyes);
      existno=new JRadioButton("No");
      existno.setBounds(450,600,80,30);
      existno.setFont(new Font("Raleway",Font.BOLD,18));
      existno.setBackground(Color.white);
      add(existno);
      ButtonGroup existgroup=new ButtonGroup();
      existgroup.add(existyes);
      existgroup.add(existno);
      
      
      next=new JButton("Next");
      next.setBounds(620,700,80,30);
      next.setBackground(Color.black);
      next.setForeground(Color.white);
      add(next);
      next.addActionListener(this);
      getContentPane().setBackground(Color.WHITE);
    }
    //implementation of interface abstract function
    public void actionPerformed(ActionEvent e){
        String Religion=(String)religion.getSelectedItem();
        String Category=(String)category.getSelectedItem();
        String Income=(String)income.getSelectedItem();
        String Education=(String)education.getSelectedItem();
        String Occupation=(String)occupation.getSelectedItem();
        String Pan=pan.getText();
        String Aadhar=aadharfield.getText();
        String Existingaccount=null;
        if(existyes.isSelected()){
            Existingaccount="Yes";
        }
        else if(existno.isSelected()){
            Existingaccount="No";
        }
        String Seniorcitizen=null;
        if(senioryes.isSelected()){
            Seniorcitizen="Yes";
        }
        else if(seniorno.isSelected()){
            Seniorcitizen="No";
        }
        //Database 
        try{
              if(Religion.equals("")){
                  JOptionPane.showMessageDialog(null,"Fill Religion Field");
              }
              else if(Category.equals(""))
                  JOptionPane.showMessageDialog(null,"Fill Category Field");
              else if(Income.equals(""))
                  JOptionPane.showMessageDialog(null,"Fill Income Field");
              else if(Education.equals(""))
                  JOptionPane.showMessageDialog(null,"Fill Education Field");
              else if(Occupation.equals(""))
                  JOptionPane.showMessageDialog(null,"Fill Occupation Field");
              else if(Pan.equals(""))
                  JOptionPane.showMessageDialog(null,"Fill Pan Field");
              else if(Aadhar.equals(""))
                  JOptionPane.showMessageDialog(null,"Fill Aadhar Field");
              else if(Existingaccount.equals(""))
                  JOptionPane.showMessageDialog(null,"Fill Existing Account Field");
              else if(Seniorcitizen.equals(""))
                  JOptionPane.showMessageDialog(null,"Fill Senior Citizen Field");
                //Built connection with database
              else{
                Conn c=new Conn();
                String Query="Insert into signuptwo values('"+formno+"','"+Religion+"','"+Category+"','"+Income+"','"+Education+"','"+Occupation+"','"+Pan+"','"+Aadhar+"','"+Existingaccount+"','"+Seniorcitizen+"')";
                c.s.executeUpdate(Query);
              }
                //Signup3 page when page 2 is successfully created
                setVisible(false);
                SignupThree x=new SignupThree(formno);
                x.setVisible(true);
        }catch(Exception d){
            System.out.println(d);
        }
        
    }
    public static void main(String args[]) {
        // TODO code application logic here
        new SignupTwo("");
    }
}
