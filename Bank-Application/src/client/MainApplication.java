
package client;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Currency;
import java.util.Scanner;

import bus.*;



public class MainApplication 
{
	

	public static void main(String[] args) throws IOException, RaiseException 
	{

		EnumAccountType account;
		Date OpenDate= new Date(30,04,2021);



		
		EnumAccountType accounttype= null;
		EnumTransactionType trasactiontype = null;

		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the Bank.....");
		
		int choice = 0;
		int accountOption=0;
		
	do		
	{

			System.out.println("\n\t\tHow can we help you today\n"
					+ "1 - Create an Account\n"
					+  "2 - Do A Transaction\n"
					+ "3 - Print Transactions\n"
					
					
					);
			choice = scanner.nextInt();
			
			switch(choice) 
			{
			
				case 1:
				
					System.out.println("\n\t\t Do you already have an account?\n"
							+ "1- Yes\n"
							+ "2- Create a new account\n");
				
					accountOption= scanner.nextInt();
						
				
					switch(accountOption) {
				
						case 1:
					
							Customer c1= new Customer();
							System.out.println("\n\t\t Please enter your account number");
							long acntNum= scanner.nextLong();
							c1=BankManager.search(acntNum);
							System.out.println("\n\t\t Please enter your account pin");
							int acntPin= scanner.nextInt();
							if(acntPin != c1.getPin()) 
							{
								System.out.println("Wrong pin");
								break;
							}
					
							else
							{
								System.out.println("\n\t\t Hello " +c1.getFirstName()+" "+ c1.getLastName());
								System.out.println("\n\t\t What kind of account would you like to create?\n"
								+ "1 - Savings Account\n"
								+ "2 - Currency Account\n"
								+ "3 - Credit Account");
						
								int acType = scanner.nextInt();
						
									switch(acType)
									{
										case 1:
											accounttype= EnumAccountType.Savings;
											break;
										
							
										case 2:
											accounttype= EnumAccountType.Currency;
											break;
							
										
										case 3:
											accounttype= EnumAccountType.Credit;
											break;
										
									}
						
						
							long accNumber;
							int accPin;

						
						
						
						System.out.println("\n\t\t What is your account number?");
						accNumber= scanner.nextLong();
						
						System.out.println("\n\t\t What your pin?");
						accPin= scanner.nextInt();
						
						if(accounttype== EnumAccountType.Savings ) 
						{
						
							System.out.println("\n\t\t What is your interest amount?\n");
							float interestAmount = scanner.nextInt();
							SavingsAccount acc= new SavingsAccount(accNumber,accPin,accounttype, OpenDate, 0,interestAmount);
							c1.addAccount(acc);						
							System.out.println("\n\t\t Confirmation: \n" +acc.toString());
						}
						
						if(accounttype== EnumAccountType.Credit ) 
						{
							
							System.out.println("\n\t\t How much would you like your limit to be?\n");
							float creditLimit = scanner.nextInt();
							System.out.println("\n\t\t What is your interest amount?\n");
							float interestAmount = scanner.nextInt();
							CreditAccount acc= new CreditAccount(accNumber,accPin,accounttype, OpenDate, 0,creditLimit, interestAmount);
							c1.addAccount(acc);						
							System.out.println("\n\t\t Confirmation: \n" +acc.toString());
						}
						
						if(accounttype== EnumAccountType.Currency ) 
						{
							System.out.println("What type of currency would you like this account to hold\n"
									+ "1- USD\n"
									+ "2-CAD\n"
									+ "3- EUR\n"
									+ "4- JPY\n"
									+ "5- GBP");
							int curr= scanner.nextInt();
							EnumCurrencyType currencyType = null;
							switch(curr) {
							case 1:
								currencyType= EnumCurrencyType.USD;
								break;
								
							case 2:
								currencyType= EnumCurrencyType.CAD;
								break;
								
							case 3:
								currencyType= EnumCurrencyType.EUR;
								break;
								
							case 4:
								currencyType= EnumCurrencyType.JPY;
								break;
								
							case 5:
								currencyType= EnumCurrencyType.GBP;
								break;
							}
							
							CurrencyAccount acc= new CurrencyAccount(accNumber,accPin,accounttype, OpenDate,0,currencyType);
							c1.addAccount(acc);						
							System.out.println("\n\t\t Confirmation: \n" +acc.toString());
						}
						


						break;
					}

					
					
				case 2: 
					
					
					System.out.println("\n\t\t Please create your Customer account"
							+ "\n Please enter your first name ");

					String fName=scanner.next();
					
					System.out.println("\n\t\t Please enter your last name ");

					String lName=scanner.next();
					
					System.out.println("\n\t\t Please enter your email ");

					String cEmail=scanner.next();
					
					System.out.println("\n\t\t Please enter your Customer ID number ");

					long cNum=scanner.nextLong();
					
					System.out.println("\n\t\t Please enter your Customer pin ");

					int cPin=scanner.nextInt();
					
					
					System.out.println("\n\t\t Please enter your address ");

					String cAddress=scanner.next();
					
					System.out.println("\n\t\t Please enter your Phone Number ");

					String cPNumber=scanner.next();
					
					

					Customer newCustomer = new Customer(fName,lName,cEmail,cNum, cPin, cAddress, cPNumber);
					BankManager.add(newCustomer);
					
					

					System.out.println("\n\t\t Customers must first create a Checkings Account before creating other accounts"
							+ "\n Please enter your perferred Checking account number ");

					
					long acctNumber=scanner.nextLong();
					
					System.out.println("\n\t\t What is the pinn of the account");
					int checkPin= scanner.nextInt();
					EnumAccountType accountType= EnumAccountType.Checkings;

					float amount = 0;
					CheckingsAccount cc1= new CheckingsAccount(acctNumber,checkPin,accountType,OpenDate,amount);
					newCustomer.addAccount(cc1);
					System.out.println(cc1.toString());
					
					
					break;
					
			

				
				}

				break;
				
			case 2:
				
				Customer c1= new Customer();
				System.out.println("\n\t\t Please enter your account number");
				long acntNum= scanner.nextLong();
				c1=BankManager.search(acntNum);
				System.out.println("\n\t\t Please enter your account pin");
				int acntPin= scanner.nextInt();
				if(acntPin != c1.getPin()) {
					System.out.println("Wrong pin");
				}
				else {
					System.out.println("\n\t\t Hello " +c1.getFirstName()+" "+ c1.getLastName());
					
					System.out.println("Which account would you like to access?"
							+ "\n 1- Checking"
							+ "\n 2- Savings"
							+ "\n 3- Credit"
							+ "\n 4- Currency");
					int trans = scanner.nextInt();
					
					switch(trans) 
					{
					case 1:
						System.out.println("Here are your available accounts:\n");
						c1.printChecking();
						break;
						
					case 2:
						System.out.println("Here are your available accounts:\n");
						c1.printSaving();
						break;
						
					case 3:
						System.out.println("Here are your available accounts:\n");
						c1.printCredit();
						break;
						
					case 4:
						System.out.println("Here are your available accounts:\n");
						c1.printCurrency();
						break;
					}

					
					System.out.println("\n\t\t Please enter the account number of the account you would like to access:");
					long accnum= scanner.nextLong();
					
					switch(trans) {
					
					case 1:
						CheckingsAccount checking = null;
						checking=c1.searchChecking(accnum);
						break;
						
					case 2:
						SavingsAccount saving = null;
						saving = c1.searchSaving(accnum);
						break;
						
					case 3:
						CreditAccount credit= null;
						credit= c1.searchCredit(accnum);
						break;
						
					case 4:
						CurrencyAccount currency= null;
						currency= c1.searchCurrency(accnum);
						break;
					}
					
					Account a1= null;
					a1= c1.search(accnum);

					
					
					
					System.out.println("\n\t\t What kind of transaction would you like to do?\n"
							+ "1 - Deposit \n"
							+ "2 - Withdraw\n");
					EnumTransactionType transactionType;
					
					int transType = scanner.nextInt();
					float amount;
					SecureRandom random = new SecureRandom();
					int num = random.nextInt(100000);
					String randomcode = String.format("%05d", num);
					String transactionNumber=randomcode;
					String discription;
					Date transactionDate=null;
					switch(transType) 
					{
					

					
					case 1: 
						transactionType= EnumTransactionType.Deposit;
						
						System.out.println("\n\t\t How much would you like to deposit?");
						amount = scanner.nextFloat();
						discription= "Deposited: $" + amount;
					
						a1.deposit(amount);
						Transaction t1= new Transaction(transactionNumber,discription,OpenDate,amount,transactionType,a1);
						System.out.println(t1.toString());
						a1.add(t1);
						
						
						break;
						
					case 2:
						transactionType= EnumTransactionType.Withdraw;
						System.out.println("\n\t\t How much would you like to withdraw?");
						amount= scanner.nextInt();
						discription= "Withdrew: $" + amount;
						amount=(float) a1.withdraw(amount);	
						Transaction t2= new Transaction(transactionNumber,discription,OpenDate,amount,transactionType,a1);
						System.out.println(t2.toString());
						a1.add(t2);
						break;
						
					}
					
					}
					
				break;
						

				

			case 3:
				Customer c3= new Customer();
				System.out.println("\n\t\t Please enter your account number");
				long acntNumm= scanner.nextLong();
				c3=BankManager.search(acntNumm);
				System.out.println("\n\t\t Please enter your account pin");
				int acntPinn= scanner.nextInt();
				if(acntPinn != c3.getPin()) {
					System.out.println("Wrong pin");
				}
				else 
				{
					System.out.println("\n\t\t Hello " +c3.getFirstName()+" "+ c3.getLastName());
					System.out.println("Here are your available accounts:\n");
					c3.printAccounts();
					CheckingsAccount cc1= null;
					System.out.println("\n\t\t Please enter the account number of the account you would like to access:");
					long accnum= scanner.nextLong();
					Account a1= null;
					a1= c3.search(accnum);
					a1.print();
				}
				break;
		
		}
		
		System.out.println("Thank you for using our Bank app !!!");
		BankManager.seralize_accounts();
		BankManager.seralize_customers();
		Account.serialize_transactions();
	} while (choice!= 9);
	
}



}