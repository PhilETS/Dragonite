package edu.gordon.pubsub.upper;

import java.util.EventObject;

public class EjectCardEvent extends EventObject
{
	private static final long serialVersionUID = 1L;

	public EjectCardEvent(Object source) 
	{
		super(source);
	}
}
