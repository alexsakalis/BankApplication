package bus;

public class CurrencyAccount extends Account{

EnumCurrencyType currency;

public CurrencyAccount(long accountNumber, int pin, EnumAccountType account, Date openDate, float accountBalance,
		EnumCurrencyType currency) throws RaiseException {
	super(accountNumber, pin, account, openDate, accountBalance);
	this.currency = currency;
}

public void deposit (float amount) throws RaiseException {
	EnumCurrencyType currency= this.currency;
	float balance=(float) this.getAccountBalance();
	switch(currency) {
	case USD:
		
		this.setAccountBalance((float) (amount*0.78)+balance);
		break;

	case CAD:
		this.setAccountBalance((float) (amount*1)+balance);
		break;
		
	case EUR:
		this.setAccountBalance((float) (amount*0.67)+balance);
		break;
		
	case JPY:
		this.setAccountBalance((float) (amount*87.22)+balance);
		break;
		
	case GBP:
		this.setAccountBalance((float) (amount*0.58)+balance);
		break;
	}
}

public float withdraw (float amount) throws RaiseException {
	EnumCurrencyType currency= this.currency;
	float price=0;
	float balance=(float) this.getAccountBalance();
	switch(currency) {
	case USD:
		price= (float) (amount*1.26);
		this.setAccountBalance((float) ((balance)-(price)));
		break;

	case CAD:
		price= (float) (amount*1);
		this.setAccountBalance((float) balance-(price));
		break;
		
	case EUR:
		price= (float) (amount*1.48);
		this.setAccountBalance((float) ((balance)-(price)));
		break;
		
	case JPY:
		price= (float) (amount*0.011);
		this.setAccountBalance((float) ((balance)-(price)));
		break;
		
	case GBP:
		price= (float) (amount*1.73);
		this.setAccountBalance((float) ((balance)-(price)));
		break;
	}
	return price;
}
public EnumCurrencyType getCurrency() {
	return currency;
}

public void setCurrency(EnumCurrencyType currency) {
	this.currency = currency;
}

@Override
public String toString() {
	return super.toString()+ "CurrencyAccount [currency=" + currency + "]";
}
	

}
