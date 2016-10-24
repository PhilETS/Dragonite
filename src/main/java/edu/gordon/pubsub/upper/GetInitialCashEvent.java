package edu.gordon.pubsub.upper;

import java.util.EventObject;

public class GetInitialCashEvent extends EventObject
{
	private static final long serialVersionUID = 1L;

	public GetInitialCashEvent(Object source) 
	{
		super(source);
	}
}
