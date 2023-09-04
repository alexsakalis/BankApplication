package bus;

import java.util.ArrayList;


public class Manager {
	
	//-1- private static data
	//////////////////////////
	 private static  ArrayList<Customer>  listOfCustomers= new  ArrayList<Customer>();
	 private static  ArrayList<Account>  listOfAccounts= new  ArrayList<Account>();

	 
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
	 
 	public static void remove(String code)
 	{
 		for(Customer element : listOfCustomers)
 		{
 			if(element.getCustomerNumber().equals(code))
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
	 public static Customer  search(String key)
	 {
			 for( Customer element : listOfCustomers)
			 {
				                            
				 if(element.getCustomerNumber().equals(key))
				 {
					 return element ;				 
				 }
			 }		 
	   return null;	   
	 }
	 
	 

	 



	
	 
	}

