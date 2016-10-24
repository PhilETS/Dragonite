package edu.gordon.pubsub.upper;

import java.util.EventObject;

public class DisplayEvent extends EventObject
{
	private static final long serialVersionUID = 1L;
		
	public DisplayEvent(Object source) 
	{
		super(source);
	}
}
