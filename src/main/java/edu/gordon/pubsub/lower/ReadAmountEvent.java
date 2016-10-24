package edu.gordon.pubsub.lower;

import java.util.EventObject;

public class ReadAmountEvent extends EventObject
{
	private static final long serialVersionUID = 1L;

	public ReadAmountEvent(Object source) 
	{
		super(source);
	}
}
