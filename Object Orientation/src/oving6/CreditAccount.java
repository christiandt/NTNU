package oving6;

public class CreditAccount implements Account{

	int balance;
	int credit;
	int fees;
	
	public CreditAccount(int limit){
		this.balance = 0;
		this.credit = limit;
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
		else if(verdi > 0 && verdi > this.balance && (this.balance-verdi-50)>=(-this.credit)){
			this.balance -= verdi;
			this.balance-=50;
			fees +=50;
			return verdi;
		}
		return 0;			
	}
	
	public int getFees(){
		return this.fees;
	}

}
