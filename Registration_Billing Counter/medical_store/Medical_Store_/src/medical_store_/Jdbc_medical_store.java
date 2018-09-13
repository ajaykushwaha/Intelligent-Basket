

import java.sql.*;
 
public class Jdbc_medical_store
{
  
    
public Jdbc_medical_store (){
System.out.println("called---------------------------------");
}
    
  public void conn_fun(){
  
  try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/medical_store","root","root");  
 
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select count(Customer_id)+1 as id From customer;");  
while(rs.next())  
System.out.println(rs.getString("id"));  
con.close();  
}catch(Exception e){ System.out.println(e);}  
  
  }
  
  
   public static void main(String args[]){
    
Jdbc_medical_store a = new Jdbc_medical_store();
        a.conn_fun();
    }
    
  
} 
 