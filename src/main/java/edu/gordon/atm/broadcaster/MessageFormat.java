package edu.gordon.atm.broadcaster;

public class MessageFormat 
{
	private BroadcastStatus status;
	private BroadcastBalances balances;
	
	public BroadcastStatus getStatus()
	{
		return this.status;
	}
	
	public BroadcastBalances getBalances()
	{
		return this.balances;
	}
	
	public MessageFormat(BroadcastStatus status, BroadcastBalances balances)
	{
		this.status=status;
		this.balances=balances;
	}
}
