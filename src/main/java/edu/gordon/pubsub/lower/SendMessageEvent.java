package edu.gordon.pubsub.lower;

import java.util.EventObject;

public class SendMessageEvent extends EventObject
{
	private static final long serialVersionUID = 1L;

	public SendMessageEvent(Object source) 
	{
		super(source);
	}
}
