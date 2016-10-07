package edu.gordon.atm.physical.event;

import java.util.EventObject;

public class PrintReceiptLineEvent extends EventObject
{
	private static final long serialVersionUID = 1L;
	
	public PrintReceiptLineEvent(String source) 
	{
		super(source);
	}
}
