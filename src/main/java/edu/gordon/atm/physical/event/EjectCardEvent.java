package edu.gordon.atm.physical.event;

import java.util.EventObject;

public class EjectCardEvent extends EventObject
{
	private static final long serialVersionUID = 1L;
	
	public EjectCardEvent(String source) 
	{
		super(source);
	}
}
