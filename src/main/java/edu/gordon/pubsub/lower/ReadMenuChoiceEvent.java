package edu.gordon.pubsub.lower;

import java.util.EventObject;

public class ReadMenuChoiceEvent extends EventObject
{
	private static final long serialVersionUID = 1L;

	public ReadMenuChoiceEvent(Object source) 
	{
		super(source);
	}
}
