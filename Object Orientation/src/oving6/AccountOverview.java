package oving6;

import java.util.ArrayList;

public class AccountOverview {
	
	ArrayList<Account> accounts = new ArrayList<Account>();
	
	public AccountOverview(){
		accounts.clear();
	}
	
	public int getAccountCount(){
		return accounts.size();
	}
	
	public Account getAccount(int index){
		return accounts.get(index);
	}
	
	public void addAccount(Account account){
		accounts.add(account);
	}
	
	public int getTotalBalance(){
		int total = 0;
		for (int i = 0; i < getAccountCount(); i++) {
			total += accounts.get(i).getBalance();
		}
		return total;
	}
	
	public int getTotalCredit(){
		int total = 0;
		for (int i = 0; i < getAccountCount(); i++) {
			total += accounts.get(i).getCredit();
		}
		return total;	 
	}
	
	public int getTotalFees(){
		int total = 0;
		for (int i = 0; i < getAccountCount(); i++) {
			if(accounts.get(i) instanceof CreditAccount){
				total += ((CreditAccount)getAccount(i)).getFees();
			}
		}
		
		return total;
	}
	

}
