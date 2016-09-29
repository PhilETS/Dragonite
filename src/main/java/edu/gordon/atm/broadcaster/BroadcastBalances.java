package edu.gordon.atm.broadcaster;

import edu.gordon.banking.Balances;
import edu.gordon.banking.Money;

public class BroadcastBalances extends Balances 
{
	public BroadcastBalances() 
	{
	}
	
    /** Mutator.  Fill in values
    *
    *  @param total the total balance in the account
    *  @param available the available balance
    */
	public void setBalances(BroadcastMoney total, BroadcastMoney available)
    {
        this.total = total;
        this.available = available;
    }
}
