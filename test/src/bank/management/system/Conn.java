package bank.management.system;
import java.sql.*;
//import java.com.mysql.cj;
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
        //2nd-step Register Driver no need to write below line bcoz already in library of mysql jar file
//            Class.forName(com.mysql.cj.jdbc.Driver);
            //3rd-step Create connection
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","Omkar","Omkar@7860");
            s=c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
