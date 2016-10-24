package edu.gordon.pubsub.upper;

import java.util.EventObject;

import edu.gordon.atm.broadcaster.BroadcastBalances;
import edu.gordon.atm.broadcaster.BroadcastMessage;

public class SendMessageEvent extends EventObject
{
	private static final long serialVersionUID = 1L;
	
	private BroadcastMessage message;
	private BroadcastBalances balances;
	
	public BroadcastMessage getMessage()
	{
		return this.message;
	}
	
	public BroadcastBalances getBalances()
	{
		return this.balances;
	}
		
	public SendMessageEvent(Object source, BroadcastMessage message, BroadcastBalances balances) 
	{
		super(source);
		this.message=message;
		this.balances=balances;
	}
}
