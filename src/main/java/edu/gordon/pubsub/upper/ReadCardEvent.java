package edu.gordon.pubsub.upper;

import java.util.EventObject;

public class ReadCardEvent extends EventObject
{
	private static final long serialVersionUID = 1L;

	public ReadCardEvent(Object source) 
	{
		super(source);
	}
}
