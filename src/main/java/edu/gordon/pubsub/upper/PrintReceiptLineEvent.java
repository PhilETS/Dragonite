package edu.gordon.pubsub.upper;

import java.util.EventObject;

public class PrintReceiptLineEvent extends EventObject
{
	private static final long serialVersionUID = 1L;

	public PrintReceiptLineEvent(Object source) 
	{
		super(source);
	}
}
