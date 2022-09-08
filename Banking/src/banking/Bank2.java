package banking;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bank2 {
static Connection con= MyConnection.getConnection();
public static void AccountOpen(String name,int balance) throws ClassNotFoundException, SQLException
{
try
{
Statement st=con.createStatement();
ResultSet result=st.executeQuery("SELECT MAX(acc_no) FROM banking");
int max=0;
while(result.next())
{
max=result.getInt("MAX(acc_no)");  
}
max+=10;
String query="INSERT INTO banking (acc_no,user_name,balance) VALUES ("+max+",'"+name+"',"+balance+")";
int count=st.executeUpdate(query);
if(count>0)
{
System.out.println("your account created successfully! your customer id is :"+max);
}
else
{
System.out.println("There is some error while creating your account");
}
}
catch(Exception e)
{
e.printStackTrace();
}
}
public static void checkBalance(int id) throws ClassNotFoundException,SQLException
{
try
{
Statement st=con.createStatement();
ResultSet rset=st.executeQuery("SELECT balance FROM banking WHERE acc_no ="+id+"");
int a=0;
while(rset.next())
{
a=rset.getInt("balance");
}
System.out.println("  Customer id:"+id+"has a current balance:Rs."+a);
}
catch(Exception e)
{
e.printStackTrace();
}
}
public static void deposit(int id ,int  amount) throws ClassNotFoundException,SQLException
{
try
{
Statement st=con.createStatement();
ResultSet rset=st.executeQuery("SELECT balance FROM banking"+" where acc_no="+id+"");
int amt=0;
	while(rset.next())
		amt=rset.getInt(1);
	      amt+=amount;
		@SuppressWarnings("unused")
		ResultSet rs=st.executeQuery("UPDATE banking " + "SET balance="+amt+" where acc_no="+id+"");
		ResultSet rsett=st.executeQuery("SELECT user_name,balance FROM banking " + "where acc_no= "+id+"");
		int amtt=0;
		String name="";
		while(rsett.next()) {
			name=rsett.getString("user_name");
			amtt = rsett.getInt("balance");
		}
		System.out.println("Customer name :" +name+ " With Customer id : "+ id + "Deposit amount Rs."+amount+"has a current balance : Rs."+amtt);

}

catch(Exception e)
{
e.printStackTrace();
}
}



public static void withdrawal(int id,int amount) throws ClassNotFoundException,SQLException
{
try
{
Statement st=con.createStatement();
ResultSet rset=st.executeQuery("SELECT balance FROM Banking " + "  where acc_no="+id+"");
int amt=0;
while(rset.next())
	amt=rset.getInt(1);
if(amt<amount){
	System.out.println("You Don't have sufficient balance");
}
else{
	amt-=amount;
	@SuppressWarnings("unused")
	ResultSet rs=st.executeQuery("UPDATE banking " + "SET balance="+amt+" where acc_no="+id+"");
	ResultSet rsett=st.executeQuery("SELECT user_name,balance FROM banking " + "where acc_no= "+id+"");
	int amtt=0;
	String name="";
	while(rsett.next()) {
		name=rsett.getString("user_name");
		amtt=rsett.getInt("balance");
	}
	System.out.println("Customer name :" +name+ " With Customer id : "+ id + "Withdrawl amount Rs."+amtt);
	
}

}
catch(Exception e)
{
e.printStackTrace();
}
}
}