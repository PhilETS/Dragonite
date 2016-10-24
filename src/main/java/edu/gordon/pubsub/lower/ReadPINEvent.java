package edu.gordon.pubsub.lower;

import java.util.EventObject;

public class ReadPINEvent extends EventObject
{
	private static final long serialVersionUID = 1L;
	private String pin;
	
	public String getPIN()
	{
		return this.pin;
	}
	
	public ReadPINEvent(Object source, String pin) 
	{
		super(source);
		this.pin=pin;
	}
}
