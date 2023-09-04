package bus;

public class SavingsAccount extends Account {
	
private float annualInterest;
private float annualGain;
private float extraFees;

	




	public SavingsAccount(long accountNumber, int pin, EnumAccountType account, Date openDate, float accountBalance,
		float annualInterest) throws RaiseException {
	super(accountNumber, pin, account, openDate, accountBalance);
	this.annualInterest = annualInterest;
	this.annualGain = annualGain;
	this.extraFees = extraFees;
}


	@Override
public String toString() {
	return super.toString()+" SavingsAccount [annualInterest=" + annualInterest + ", annualGain=" + annualGain + ", extraFees="
			+ extraFees + "]";
}


	public float getAnnualInterest() {
	return annualInterest;
}


public void setAnnualInterest(float annualInterest) {
	this.annualInterest = annualInterest;
}


public float getAnnualGain() {
	return annualGain;
}


public void setAnnualGain(float annualGain) {
	this.annualGain = annualGain;
}


public float getExtraFees() {
	return extraFees;
}


public void setExtraFees(float extraFees) {
	this.extraFees = extraFees;
}

public void applyFees() throws RaiseException {
	float balance=(float) this.getAccountBalance();
	balance= balance- extraFees;
	this.setAccountBalance(balance);
}






}
