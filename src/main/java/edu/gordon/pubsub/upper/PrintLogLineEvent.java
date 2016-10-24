package edu.gordon.pubsub.upper;

import java.util.EventObject;

public class PrintLogLineEvent extends EventObject
{
	private static final long serialVersionUID = 1L;

	public PrintLogLineEvent(Object source) 
	{
		super(source);
	}
}
