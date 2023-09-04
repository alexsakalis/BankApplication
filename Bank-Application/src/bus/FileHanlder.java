package bus;

import java.io.*;
import java.util.*;

public class FileHanlder {
	
private static String filePathAccount = "src//Data// myAccounts.ser" ;
private static String filePathCustomer = "src//Data// myCustomers.ser" ;
private static String filePathTransaction= "src//Data// myTransactions.ser" ;
	
	public static void writeToFile_Account(ArrayList<Account> list) throws IOException
	{
		FileOutputStream fos = new FileOutputStream(filePathAccount);
		@SuppressWarnings("resource")
		ObjectOutputStream oos = new ObjectOutputStream (fos);		
		oos.writeObject(list);	
		
	}
	
	public static ArrayList<Account>  readFromFile_Account() throws IOException, ClassNotFoundException
	{
		
        FileInputStream fis = new FileInputStream(filePathAccount);
        
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        @SuppressWarnings("unchecked")
		ArrayList<Account> listFromFile = (ArrayList<Account>)ois.readObject();	
		
		ois.close();
		return listFromFile;
	}
	
	public static void writeToFile_Customer(ArrayList<Customer> list) throws IOException
	{
		FileOutputStream fos = new FileOutputStream(filePathCustomer);
		@SuppressWarnings("resource")
		ObjectOutputStream oos = new ObjectOutputStream (fos);		
		oos.writeObject(list);	
		
	}
	
	public static ArrayList<Customer>  readFromFile_Customer() throws IOException, ClassNotFoundException
	{
		
        FileInputStream fis = new FileInputStream(filePathCustomer);
        
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        @SuppressWarnings("unchecked")
		ArrayList<Customer> listFromFile = (ArrayList<Customer>)ois.readObject();	
		
		ois.close();
		return listFromFile;
	}
	
	public static void writeToFile_Transaction(ArrayList<Transaction> list) throws IOException
	{
		FileOutputStream fos = new FileOutputStream(filePathTransaction);
		@SuppressWarnings("resource")
		ObjectOutputStream oos = new ObjectOutputStream (fos);		
		oos.writeObject(list);	
		
	}
	
	public static ArrayList<Transaction>  readFromFile_Transaction() throws IOException, ClassNotFoundException
	{
		
        FileInputStream fis = new FileInputStream(filePathTransaction);
        
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        @SuppressWarnings("unchecked")
		ArrayList<Transaction> listFromFile = (ArrayList<Transaction>)ois.readObject();	
		
		ois.close();
		return listFromFile;
	}
	
	

}
