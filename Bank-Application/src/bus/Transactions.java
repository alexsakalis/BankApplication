package bus;

public class Transactions {
	private int transactionNumber;
	private String discription;
	private Date transactionDate;
	private float amount;
	private EnumTransactionType transactionType;
	private float accountBalance;
	private CheckingsAccount account;
	
	
	
	public Transactions(int transactionNumber, String discription, Date transactionDate, float amount,
			EnumTransactionType transactionType, CheckingsAccount account)
	{
		this.transactionNumber = transactionNumber;
		this.discription = discription;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.transactionType = transactionType;
		this.account = account;
	}
	
	

	public Transactions() {
		this.transactionNumber = transactionNumber;
		this.discription = discription;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.transactionType = transactionType;
		this.accountBalance = accountBalance;
		this.account = account;
	}



	public float getAccountBalance() {
		return accountBalance;
	}
	
	public void depositAmmount(SavingsAccount account, float amount)
	{
		accountBalance=account.getSavingsAccountBalance()+amount;
	}
	
	public void depositAmmount(CheckingsAccount account, float amount)
	{
		accountBalance=account.getAccountBalance()+amount;
	}
	
	public void withdrawAmmount(SavingsAccount account, float amount)
	{
		accountBalance=account.getSavingsAccountBalance()-amount;
	}
	
	public void withdrawAmmount(CheckingsAccount account, float amount)
	{
		accountBalance=account.getAccountBalance()-amount;
	}
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(CheckingsAccount account) {
		this.account = account;
	}
	public int getTransactionNumber() {
		return transactionNumber;
	}
	public void setTransactionNumber(int transactionNumber) {
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
	public void setAmount(float amount) {
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
