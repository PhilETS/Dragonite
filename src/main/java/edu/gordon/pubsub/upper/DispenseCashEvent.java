package edu.gordon.pubsub.upper;

import java.util.EventObject;

public class DispenseCashEvent extends EventObject
{
	private static final long serialVersionUID = 1L;

	public DispenseCashEvent(Object source) 
	{
		super(source);
	}
}
