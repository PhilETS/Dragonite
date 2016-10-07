package edu.gordon.atm.physical.event;

import java.util.EventObject;

import edu.gordon.atm.broadcaster.BroadcastMoney;

public class DispenseCashEvent extends EventObject
{
	private static final long serialVersionUID = 1L;
	
	public DispenseCashEvent(BroadcastMoney source) 
	{
		super(source);
	}
}
