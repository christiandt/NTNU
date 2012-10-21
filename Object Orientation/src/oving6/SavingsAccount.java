package oving6;

public class SavingsAccount implements Account{
	
	int balance;
	int credit;
	
	public SavingsAccount(){
		this.balance = 0;
	}

	@Override
	public int getBalance() {
		return this.balance;
	}

	@Override
	public int getCredit() {
		return this.credit;
	}

	@Override
	public int deposit(int verdi) {
		if (verdi>0) {
			this.balance += verdi;
		}
		return this.balance;
	}

	@Override
	public int withdraw(int verdi) {
		if(verdi > 0 && verdi <= this.balance){
			this.balance -= verdi;
			return verdi;
		}
		else{
			return 0;			
		}
	}
	
	

}
