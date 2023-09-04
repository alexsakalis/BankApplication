package bus2;
import Data.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


import bus.RaiseException;


public class CustomerDB {
	

	
	
public static String AddCustomer(Customer newCustomer) throws SQLException, NumberFormatException, RaiseException {
    Connection con = null;
    
    con = ConnectionDB.getConnection();

    String query ="";
    Statement stmt = null;
    ResultSet rs = null;

    String request = null;
Customer aCus = new Customer();
aCus = CustomerDB.SearchCustomer(newCustomer.getCustomerNumber());
if (aCus.getFirstName() != "") {
	String errormsg ="This Id number already exists\n"
			+ aCus;
	return errormsg;
}else 
{

   

    Customer aCustomer = new Customer();
	aCustomer= newCustomer;
	
     
     
     request = "INSERT INTO customers(firstname, lastname, email, customernumber, pin, address, phonenumber) values ('"
    		 + aCustomer.getFirstName() + "','"
    		 + aCustomer.getLastName() + "','"
    		 + aCustomer.getEmail() + "','"
    		 + aCustomer.getCustomerNumber() + "','"
    		 + aCustomer.getPin() + "','"
    		 + aCustomer.getAddress() + "','"
    		 + aCustomer.getPhonenumber() + "')";
   
    stmt = con.createStatement();
    stmt.executeUpdate(request);
    con.commit();
   
    String msg = "Customer ID: " +aCustomer.getCustomerNumber()+"\n"
    			+"First Name: " +aCustomer.getFirstName()+"\n"
    		+"Last Name: " +aCustomer.getLastName()+"\n"
    		+"Email: " +aCustomer.getEmail()+"\n"
    		+"Pinn : " +aCustomer.getPin()+"\n"
    		+"Address: " +aCustomer.getAddress()+"\n"
    		+"Phone Number: " +aCustomer.getPhonenumber()+"\n"+
    		"Has successfully been added";
    return msg;

}


}
	
public static Customer SearchCustomer(long id_key) throws SQLException, NumberFormatException, RaiseException {
    Scanner scan = new Scanner(System.in);
    Connection con = null;
    
    con = ConnectionDB.getConnection();
    ArrayList<Customer> CustomerList = null;
    String query ="";
    Statement stmt = null;
    ResultSet rs = null;
    String id, fn, ln, email, pin, address, phonenumber;
    String request = null;
    Customer aCustomer = new Customer();
    query = "select * from customers where customernumber = " + id_key;
    stmt = con.createStatement();
    rs= stmt.executeQuery(query);
    
    CustomerList = new ArrayList<Customer>();
    
   

    while(rs.next())
    {
        id = rs.getString(1);
        fn = rs.getString(1);
        ln = rs.getString(2);
        email = rs.getString(3);
        id= rs.getString(4);
        pin= rs.getString(5);
        address= rs.getString(6);
        phonenumber= rs.getString(7);
        
        
        Customer aStud = new Customer(fn,ln, email, Long.parseLong(id), Integer.parseInt(pin), address, phonenumber);
        aCustomer= aStud;
    

    }
    return aCustomer;
    
}

public static String RemoveCustomer(Customer aCustomer) throws SQLException, NumberFormatException, RaiseException {
	
    Connection con = null;
con = ConnectionDB.getConnection();
    String query ="";
  Statement stmt = null;
    ResultSet rs = null;
   String request = null;
Customer aCus = new Customer();
long cnum = aCustomer.getCustomerNumber();
aCus = CustomerDB.SearchCustomer(cnum);
if (aCus.getFirstName() == "") {
	String errormsg="This Id number does not exist";
	return errormsg;
}else 
{
    request = "DELETE FROM customers WHERE customernumber = " + aCus.getCustomerNumber();
    stmt = con.createStatement();
    stmt.executeQuery(request);
    
    String msg="Customer: \n"
    +"Customer ID: " +aCus.getCustomerNumber()+"\n"
	+"First Name: " +aCus.getFirstName()+"\n"
+"Last Name: " +aCus.getLastName()+"\n"
+"Email: " +aCus.getEmail()+"\n"
+"Pinn : " +aCus.getPin()+"\n"
+"Address: " +aCus.getAddress()+"\n"
+"Phone Number: " +aCus.getPhonenumber()+"\n"+
"Has successfully been deleted";

    return msg;
}

}


public static String UpdateCustomer(Customer newCustomer) throws SQLException, NumberFormatException, RaiseException {
    Scanner scan = new Scanner(System.in);
    Connection con = null;
    
    con = ConnectionDB.getConnection();
//    ArrayList<Customer> CustomerList = null;
    String query ="";
    Statement stmt = null;
    ResultSet rs = null;
//    String id, fn, ln;
    String request = null;
Customer aCust = new Customer();
//System.out.println("id? : ");
//int id_key;
//id_key = scan.nextInt();
aCust = CustomerDB.SearchCustomer(newCustomer.getCustomerNumber());
if (aCust == null) {
	String errormsg="This Id number does not exist";
	return errormsg;
}else 
{


   
    Customer aCustomer = new Customer();
    aCustomer=newCustomer;
   
    request = "UPDATE customers"
    		+ " SET firstname = '"+aCustomer.getFirstName()+"' , lastname = '"+aCustomer.getLastName()+"'"
    				+ ", email = '"+aCustomer.getEmail()+"' , pin = '"+aCustomer.getPin()+"'"
    				+ ", address = '"+aCustomer.getAddress()+"' , phonenumber = '"+aCustomer.getPhonenumber()+"'"
    		+ " WHERE customernumber = " +aCustomer.getCustomerNumber();
    stmt = con.createStatement();
    stmt.executeUpdate(request);
    con.commit();
   
    String msg="Old Account:\n"
    +"Customer ID: "+ aCust.getCustomerNumber()+"\n"
    + "First Name : " + aCust.getFirstName()+"\n"
    + "Last Name : " + aCust.getLastName()+"\n"
    + "Email : " + aCust.getEmail()+"\n"
    + "Pinn : " + aCust.getPin()+"\n"
    + "Address : " + aCust.getAddress()+"\n"
    + "Phone Number : " + aCust.getPhonenumber()+"\n"
    +"\n\n--------------\n\n"
    +"New updated account:"
    +"Customer ID: "+ aCustomer.getCustomerNumber()+"\n"
    + "First Name : " + aCustomer.getFirstName()+"\n"
    + "Last Name : " + aCustomer.getLastName()+"\n"
    + "Email : " + aCustomer.getEmail()+"\n"
    + "Pinn : " + aCustomer.getPin()+"\n"
    + "Address : " + aCustomer.getAddress()+"\n"
    + "Phone Number : " + aCustomer.getPhonenumber()+"\n"
    +" Has sucesssfully been Updated";
    return msg;
//    System.out.println("\n\n--------------\n\n");
}

}

public static ArrayList<Customer> DisplayAllCustomers() throws SQLException, NumberFormatException, RaiseException {
	
    Connection con = null;
    
    con = ConnectionDB.getConnection();
    ArrayList<Customer> CustomerList = null;
    String query ="";
    Statement stmt = null;
    ResultSet rs = null;
    String id, fn, ln, email, pin, address, phonenumber;
    String request = null;
    query = "Select * from customers";
    
    stmt = con.createStatement();
    rs = stmt.executeQuery(query);
    
    CustomerList = new ArrayList<Customer>();
    Customer aCustomer;
	while(rs.next())
    {
        fn = rs.getString(1);
        ln = rs.getString(2);
        email = rs.getString(3);
        id= rs.getString(4);
        pin= rs.getString(5);
        address= rs.getString(6);
        phonenumber= rs.getString(7);
       
        aCustomer = new Customer(fn,ln, email, Long.parseLong(id), Integer.parseInt(pin), address, phonenumber);
        CustomerList.add(aCustomer);
    }
	
	return CustomerList;
}
	

}
