package bus;

import java.io.*;
import java.util.ArrayList;

public class Account implements Serializable {
	

	private static final long serialVersionUID = 2746307921609031903L;
	/**
	 * 
	 */

	private long accountNumber;
	private int pin;
	private EnumAccountType accountType;
	private Date OpenDate;
	private double accountBalance; // switch to double
	private EnumCurrencyType currency;
	

	

		




	public Account(long accountNumber, int pin, EnumAccountType accountType, Date openDate, double accountBalance) throws RaiseException {
		super();
		this.setAccountNumber(accountNumber);
		this.setPin(pin);
		this.setAccountBalance(accountBalance);
		this.accountType = accountType;
		OpenDate = openDate;
		this.currency= EnumCurrencyType.CAD;
		
		// use customer id, which is associated with the customer number in customer class
	}

	
	public EnumCurrencyType getCurrency() {
		return currency;
	}


	public void setCurrency(EnumCurrencyType currency) {
		this.currency = currency;
	}


	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) throws RaiseException 
	{
		Validator.IsNumber(accountBalance);
		this.accountBalance = accountBalance;
	}

	public long getAccountNumber() 
	{
		return accountNumber;
	}
	
	public void setAccountNumber(long accountNumber) throws RaiseException
	{
		Validator.IsNumber(accountNumber);
		this.accountNumber = accountNumber;
	}
	
	public int getPin()
	{
		return pin;
	}
	
	public void setPin(int pin) throws RaiseException 
	{
		String pinn= String.valueOf(pin);
		Validator.isNumeric(pinn);
		this.pin = Integer.parseInt(pinn);  
	}
	
	public EnumAccountType getAccount() {
		return accountType;
	}
	public void setAccount(EnumAccountType accountType) {
		this.accountType = accountType;
	}
	public Date getOpenDate() {
		return OpenDate;
	}
	public void setOpenDate(Date openDate) {
		OpenDate = openDate;
	}

	public double withdraw(double ammount) throws RaiseException {
		double balance=this.getAccountBalance();
		float price=0;
		balance= balance- ammount;
		
		Validator.isPositive((long)ammount);
		this.setAccountBalance(balance);
		
		if(accountType== EnumAccountType.Currency) {
			switch(currency) {
			case USD:
				price= (float) (ammount*1.26);
				this.setAccountBalance((float) ((balance)-(price)));
				break;

			case CAD:
				price= (float) (ammount*1);
				this.setAccountBalance((float) balance-(price));
				break;
				
			case EUR:
				price= (float) (ammount*1.48);
				this.setAccountBalance((float) ((balance)-(price)));
				break;
				
			case JPY:
				price= (float) (ammount*0.011);
				this.setAccountBalance((float) ((balance)-(price)));
				break;
				
			case GBP:
				price= (float) (ammount*1.73);
				this.setAccountBalance((float) ((balance)-(price)));
				break;
			}
		
	}
		return ammount;
	}

	public void deposit(double ammount) throws RaiseException {
		double balance=this.getAccountBalance();
		balance= balance+ ammount;
		Validator.isPositive((long)ammount);
		this.setAccountBalance(balance);
		
		if(accountType== EnumAccountType.Currency) {
			
			switch(currency) {
			case USD:
				
				this.setAccountBalance((float) (ammount*0.78)+balance);
				break;

			case CAD:
				this.setAccountBalance((float) (ammount*1)+balance);
				break;
				
			case EUR:
				this.setAccountBalance((float) (ammount*0.67)+balance);
				break;
				
			case JPY:
				this.setAccountBalance((float) (ammount*87.22)+balance);
				break;
				
			case GBP:
				this.setAccountBalance((float) (ammount*0.58)+balance);
				break;
			}
	}
		else {
			this.setAccountBalance(balance);
		}
	}
//
//	@Override
//	public String toString() {
//		return "Account [accountNumber=" + accountNumber + ", pin=" + pin + ", account=" + account + ", OpenDate="
//				+ OpenDate + "]";
//	}
//	
//	
	

	
	public String printInfo() {
		return "Account [accountNumber=" + accountNumber + ", account=" + accountType + ", OpenDate="
				+ OpenDate + "]";
	}
	
	
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", pin=" + pin + ", accountType=" + accountType + ", OpenDate="
				+ OpenDate + ", accountBalance= $ " + accountBalance +"]";
	}


	//-1- private static data
	//////////////////////////
	 private static  ArrayList<Transaction>  listOfTransactions= new  ArrayList<Transaction>();	
	 private static  ArrayList<Transaction>  LoadedlistOfTransactions= new  ArrayList<Transaction>();	

	 
	 //-2- public static operations
	/////////////////////////////// 	 
     public static void add(Transaction object)
	 {
		 listOfTransactions.add(object );		 
	 }	 
     
	 public static void print()	 
	 {
		 for(Transaction element : listOfTransactions)
		 {
			 System.out.println(element);
			 
		 } 		 
	 } 	 
     
	 public static void serialize_transactions() throws IOException {
		 FileHanlder.writeToFile_Transaction(listOfTransactions);
	 }

	
	 public static void Deserialize_transtions() throws ClassNotFoundException, IOException {
		 LoadedlistOfTransactions= FileHanlder.readFromFile_Transaction();
	 }
//	 public static CheckingsAccount  search(String key)
//	 {
//			 for( CheckingsAccount element : listOfCustomers)
//			 {
//				                            
//				 if(element.getCustomerNumber().equals(key))
//				 {
//					 return element ;				 
//				 }
//			 }		 
//	   return null;	   
//	 }
	

}
