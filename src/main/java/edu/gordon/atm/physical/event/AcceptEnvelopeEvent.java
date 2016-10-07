package edu.gordon.atm.physical.event;

import java.util.EventObject;

public class AcceptEnvelopeEvent extends EventObject
{
	private static final long serialVersionUID = 1L;
	
	public AcceptEnvelopeEvent(String source) 
	{
		super(source);
	}
}
