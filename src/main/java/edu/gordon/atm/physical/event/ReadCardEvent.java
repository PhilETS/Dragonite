package edu.gordon.atm.physical.event;

import java.util.EventObject;

public class ReadCardEvent extends EventObject
{
	private static final long serialVersionUID = 1L;
	
	public ReadCardEvent(String source) 
	{
		super(source);
	}
}
