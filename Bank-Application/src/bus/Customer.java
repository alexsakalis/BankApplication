package bus;

import java.io.*;
import java.util.ArrayList;

public class Customer implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4440743275116957253L;
	private String firstName;
	private String lastName;
	private String email;
	private long customerNumber;
	private int pin;
	private String address;
	private String phonenumber;
	
	// add address class, and phone number
	
	public Customer() {
		super();
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.customerNumber = 0;
		this.pin = 0000;
		this.address= "";
		this.phonenumber="";
	}


	public Customer(String firstName, String lastName, String email, long customerNumber, int pin, String address, String phonenumber) throws RaiseException {

		this.setCustomerNumber(customerNumber);
		this.setEmail(email);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPin(pin);
		this.setAddress(address);
		this.setPhonenumber(phonenumber);
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}





	public int getPin() {
		return pin;
	}


	public void setPin(int pin) throws RaiseException {
		Validator.IsNumber(pin);
		this.pin = pin;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) throws RaiseException {
		Validator.isAlphabetic(firstName);
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) throws RaiseException {
		Validator.isAlphabetic(lastName);
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getCustomerNumber() {
		return customerNumber;
	}


	public void setCustomerNumber(long customerNumber) throws RaiseException {
		Validator.IsNumber(customerNumber);
		this.customerNumber = customerNumber;
	}


	//-1- private static data //// use hashmap
	//////////////////////////
	 private static  ArrayList<Account>  listOfAccounts= new  ArrayList<Account>();	
	 private static  ArrayList<CheckingsAccount>  listOfCheckingAccounts= new  ArrayList<CheckingsAccount>();	
	 private static  ArrayList<SavingsAccount>  listOfSavingAccounts= new  ArrayList<SavingsAccount>();	
	 private static  ArrayList<CurrencyAccount>  listOfCurrencyAccounts= new  ArrayList<CurrencyAccount>();	
	 private static  ArrayList<CreditAccount>  listOfCreditAccounts= new  ArrayList<CreditAccount>();	

	 
	 //-2- public static operations
	/////////////////////////////// 	 
     public void addAccount(Account object)
	 {
		 listOfAccounts.add(object);	
		   if(object instanceof CheckingsAccount)
		   {			   
			   listOfCheckingAccounts.add((CheckingsAccount) object);
		   }  
		   if(object instanceof SavingsAccount)
		   {			   
			   listOfSavingAccounts.add((SavingsAccount) object);
		   } 
		   if(object instanceof CurrencyAccount)
		   {			   
			   listOfCurrencyAccounts.add((CurrencyAccount) object);
		   }  
		   if(object instanceof CreditAccount)
		   {			   
			   listOfCreditAccounts.add((CreditAccount) object);
		   }  
	 }	 
     
	 public static void printAccounts()	 
	 {
		 for(Account element : listOfAccounts)
		 {
			 System.out.println(element);
			 
		 } 		 
	 } 	
	 
	 public static void printChecking()	 
	 {
		 for(Account element : listOfCheckingAccounts)
		 {
			 System.out.println(element);
			 
		 } 		 
	 } 	
	 
	 public static void printSaving()	 
	 {
		 for(Account element : listOfSavingAccounts)
		 {
			 System.out.println(element);
			 
		 } 		 
	 } 	
	 
	 public static void printCurrency()	 
	 {
		 for(Account element : listOfCurrencyAccounts)
		 {
			 System.out.println(element);
			 
		 } 		 
	 } 	
	 public static void printCredit()	 
	 {
		 for(Account element : listOfCreditAccounts)
		 {
			 System.out.println(element);
			 
		 } 		 
	 } 	
	 public static Account  search(long key)
	 {
			 for( Account element : listOfAccounts)
			 {
				                            
				 if(element.getAccountNumber()==(key))
				 {
					 return element ;				 
				 }
			 }		 
	   return null;	   
	 }
	 
	 
	 public static CheckingsAccount  searchChecking(long key)
	 {
			 for( CheckingsAccount element : listOfCheckingAccounts)
			 {
				                            
				 if(element.getAccountNumber()==(key))
				 {
					 return element ;				 
				 }
			 }		 
	   return null;	   
	 }
	 
	 
	 public static SavingsAccount  searchSaving(long key)
	 {
			 for( SavingsAccount element : listOfSavingAccounts)
			 {
				                            
				 if(element.getAccountNumber()==(key))
				 {
					 return element ;				 
				 }
			 }		 
	   return null;	   
	 }
	 
	 public static CurrencyAccount  searchCurrency(long key)
	 {
			 for( CurrencyAccount element : listOfCurrencyAccounts)
			 {
				                            
				 if(element.getAccountNumber()==(key))
				 {
					 return element ;				 
				 }
			 }		 
	   return null;	   
	 }
	 
	 
	 public static CreditAccount  searchCredit(long key)
	 {
			 for( CreditAccount element : listOfCreditAccounts)
			 {
				                            
				 if(element.getAccountNumber()==(key))
				 {
					 return element ;				 
				 }
			 }		 
	   return null;	   
	 }


	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", customerNumber="
				+ customerNumber + ", pin=" + pin + ", address=" + address + ", phonenumber=" + phonenumber + "]";
	}






	
	
}
