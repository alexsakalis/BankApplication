package bus;

public class CreditAccount extends Account {
	
	private float creditLimit;
	private float availableCredit;
	private float interestAmount;
	
	





	public CreditAccount(long accountNumber, int pin, EnumAccountType account, Date openDate, float accountBalance,
			float creditLimit, float interestAmount) throws RaiseException {
		super(accountNumber, pin, account, openDate, accountBalance);
		this.creditLimit = creditLimit;
		this.availableCredit = availableCredit;
		this.interestAmount = interestAmount;
	}


public void makePayment(float amount) {
	this.availableCredit= availableCredit+amount;
}

public void useCreditCard(float amount) {
	this.availableCredit= availableCredit-amount;
}


	public float getCreditLimit() {
		return creditLimit;
	}





	public void setCreditLimit(float creditLimit) {
		this.creditLimit = creditLimit;
	}





	public float getAvailableCredit() {
		return availableCredit;
	}


	public void setAvailableCredit() {
		float balance= (float) this.getAccountBalance();
		this.availableCredit = creditLimit-balance;
	}


	public float getInterestAmount() {
		return interestAmount;
	}


	public void setInterestAmount(float interestAmount) {
		this.interestAmount = interestAmount;
	}


	@Override
	public String toString() {
		return super.toString()+ "CreditAccount [CreditLimit=" + creditLimit + ", availableCredit=" + availableCredit
				+ ", interestAmount=" + interestAmount + "]";
	}
	

	

	
}
