package banking;

import java.sql.SQLException;
import java.util.Scanner;


public class Main {

public static void main(String[] args) throws ClassNotFoundException, SQLException {
@SuppressWarnings("resource")
Scanner scn=new Scanner(System.in);
while(true) {
System.out.println("1.Open Account");
System.out.println("2.Check Balance");
System.out.println("3.Withdraw Amount");
System.out.println("4.Deposit Amount");
System.out.println("5. Exit");
System.out.println("Enter your choice: ");
int option=scn.nextInt();
switch(option) {
case 1:
System.out.println("Enter Your Name");
String name=scn.next();
System.out.println("Enter initial amount you want to deposit");
int balance=scn.nextInt();
Bank2.AccountOpen(name,balance);
break;
case 2:
System.out.println("Enter Your acc_no");
int id1=scn.nextInt();
Bank2.checkBalance(id1);
break;
case 3:
System.out.println("Enter Your acc_no");
int id2=scn.nextInt();
System.out.println("Enter Amount to withdraw");
int amount1=scn.nextInt();
Bank2.withdrawal(id2,amount1);
break;
case 4:
System.out.println("Enter Your acc_no");
int id3=scn.nextInt();
System.out.println("Enter Amount to deposit");
int amount11=scn.nextInt();
Bank2.deposit(id3,amount11);
break;
case 5:
System.out.println("Exit sucessfully");
return;
default:
System.out.println("Invalid Input");
break;

}
}
}

}
