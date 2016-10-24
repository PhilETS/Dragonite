package edu.gordon.pubsub.lower;

import java.util.EventObject;

public class AcceptEnvelopeEvent extends EventObject
{
	private static final long serialVersionUID = 1L;

	public AcceptEnvelopeEvent(Object source) 
	{
		super(source);
	}
}
