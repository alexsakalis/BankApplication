package bus;

public class CheckingsAccount extends Account {
private float fees= 10;
private int transactions=0;

// counter for transactions


public CheckingsAccount(long accountNumber, int pin, EnumAccountType account, Date openDate, float accountBalance) throws RaiseException {
	super(accountNumber, pin, account, openDate, accountBalance);
	this.fees = fees;
}

public void applyTransaction() {
	this.transactions= this.transactions+1;
	if (this.transactions > 5) {
		this.fees = fees+fees;
	}
}

public void deposit(float ammount) throws RaiseException {
	float total= (float) super.getAccountBalance();
	float newtotal=total+ammount;
	super.setAccountBalance(newtotal);
}


public void applyFees() throws RaiseException 
{
this.transactions=this.transactions+1;
	System.out.println("You have made " +this.transactions+ " transactions");
	if (this.transactions<=5){
		float accountBalance;
		accountBalance= (float) (this.getAccountBalance()- this.fees) ;
		this.setAccountBalance(accountBalance);
	}
}




public float getFees() {
	return fees;
}

public void setFees(float fees) {
	this.fees = fees;
}

@Override
public String toString() {
	return super.toString()+ "CheckingsAccount [fees=" + fees + ", transactions=" + transactions + "]";
}





}
