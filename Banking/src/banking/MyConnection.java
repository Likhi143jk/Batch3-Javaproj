package banking;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
public class MyConnection{
static Connection connect=null;
public static Connection getConnection()
{
try{
Class.forName("oracle.jdbc.driver.OracleDriver");

connect =  DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl.iiht.tech","scott","tiger");

if(connect!=null){
System.out.println("ConnectionEstablished");
}
else{
System.out.println("can't connect");
}
}
catch(Exception e){
e.printStackTrace();
System.out.println("Connection Failed");
}
return connect;
}
public Statement createStatement() {
	// TODO Auto-generated method stub
	return null;
}
}
