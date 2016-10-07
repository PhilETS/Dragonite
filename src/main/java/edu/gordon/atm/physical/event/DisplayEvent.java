package edu.gordon.atm.physical.event;

import java.util.EventObject;

public class DisplayEvent extends EventObject
{
	private static final long serialVersionUID = 1L;
	
	public DisplayEvent(String source) 
	{
		super(source);
	}
}
