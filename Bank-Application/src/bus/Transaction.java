package bus;

import java.io.*;

public class Transaction implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3183880079587282303L;
	private String transactionNumber;
	private String discription;
	private Date transactionDate;
	private float amount;
	private EnumTransactionType transactionType;
	private float Balance;
	private Account account;
	
	
	
	public Transaction(String transactionNumber, String discription, Date transactionDate, float amount,
			EnumTransactionType transactionType, Account account) throws RaiseException
	{
		this.setTransactionNumber(transactionNumber);
		this.setAmount(amount);
		this.discription = discription;
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
		this.account = account;
	}
	

	public Transaction() {
		this.transactionNumber = transactionNumber;
		this.discription = discription;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.transactionType = transactionType;
		this.Balance = Balance;
		this.account = account;
	}



	public float getAccountBalance() {
		return Balance;
	}
	
	public void depositAmmount(Account account, float amount)
	{
		Balance=(float) (account.getAccountBalance()+amount);
	}
	

	
	public void withdrawAmmount(Account account, float amount)
	{
		Balance=(float) (account.getAccountBalance()-amount);
	}
	

	
	public Account getAccount() {
		return account;
	}
	public void setAccount(CheckingsAccount account) {
		this.account = account;
	}
	public String getTransactionNumber() {
		
		return transactionNumber;
	}
	public void setTransactionNumber(String transactionNumber) throws RaiseException 
	{

		this.transactionNumber = transactionNumber;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) throws RaiseException {
		Validator.IsNumber(amount);
		this.amount = amount;
	}
	public EnumTransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(EnumTransactionType transactionType) {
		this.transactionType = transactionType;
	}
	@Override
	public String toString() {
		return "Transactions [transactionNumber=" + transactionNumber + ", discription=" + discription
				+ ", transactionDate=" + transactionDate + ", amount=" + amount + ", transactionType=" + transactionType
				+ ", \n Account information =" + account.toString() + "]\n";
	}
	
//	@Override
//	public String toString() {
//		return "Transactions [transactionNumber=" + transactionNumber + ", discription=" + discription
//				+ ", transactionDate=" + transactionDate + ", amount=" + amount + ", transactionType=" + transactionType
//				+ "]";
//	}
	
	
	
	
	

}
