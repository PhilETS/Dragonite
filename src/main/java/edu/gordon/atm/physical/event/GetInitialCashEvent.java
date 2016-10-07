package edu.gordon.atm.physical.event;

import java.util.EventObject;

public class GetInitialCashEvent extends EventObject
{
	private static final long serialVersionUID = 1L;
	
	public GetInitialCashEvent(String source) 
	{
		super(source);
	}
}
