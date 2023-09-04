package bus;

import java.io.IOException;
import java.util.ArrayList;


public class BankManager {
	
	//-1- private static data
	//////////////////////////
	 private static  ArrayList<Customer>  listOfCustomers= new  ArrayList<Customer>();
	 private static  ArrayList<Account>  listOfAccounts= new  ArrayList<Account>();
	 
	 private static  ArrayList<Customer>  LoadedlistOfCustomers= new  ArrayList<Customer>();
	 private static  ArrayList<Account>  LoadedlistOfAccounts= new  ArrayList<Account>();

	 // Add methods to add, delete customer and account
	 
	 
	 //-2- public static operations
	/////////////////////////////// 	 
     public static void add(Customer object)
	 {
		 listOfCustomers.add(object);		 
	 }	
     
     public static void add(Account object)
	 {
		 listOfAccounts.add(object);		 
	 }	
     
	 
     public static void remove(Customer object)
	 {
		 listOfCustomers.remove(object);		 
	 }	 
	
     public static void removeAt(int index)
	 {
		 listOfCustomers.remove(index);		 
	 }	 
	 
 	public static void remove(long code)
 	{
 		for(Customer element : listOfCustomers)
 		{
 			if(element.getCustomerNumber()==(code))
 			{
 				System.out.println("Customer ('"+code+"') has now been deleted\n\n");
 				listOfCustomers.remove(element);
 				break;
 			}
 		}
 	
 	}
	 public static void print()	 
	 {
		 for(Customer element : listOfCustomers)
		 {
			 System.out.println(element);
			 
		 } 		 
	 } 	 
	  	 
	 //-search for a counter by serial number: unique identifier	 
	 public static Customer  search(long key)
	 {
			 for( Customer element : listOfCustomers)
			 {
				                            
				 if(element.getCustomerNumber()==(key))
				 {
					 return element ;				 
				 }
			 }		 
	   return null;	   
	 }
	 
	 

	 public static void seralize_customers() throws IOException {
		 FileHanlder.writeToFile_Customer(listOfCustomers);
	 }
	 
	 public static void seralize_accounts() throws IOException {
		 FileHanlder.writeToFile_Account(listOfAccounts);
	 }

	 public static void Deserialize_accounts() throws ClassNotFoundException, IOException {
		 LoadedlistOfAccounts= FileHanlder.readFromFile_Account();
	 }

	 public static void Deserialize_customers() throws ClassNotFoundException, IOException {
		 LoadedlistOfCustomers= FileHanlder.readFromFile_Customer();
	 }

	
	 
	}

