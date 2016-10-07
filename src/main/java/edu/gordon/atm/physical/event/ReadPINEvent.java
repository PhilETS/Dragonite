package edu.gordon.atm.physical.event;

import java.util.EventObject;

public class ReadPINEvent extends EventObject
{
	private static final long serialVersionUID = 1L;
	
	private String prompt;
	public String getPrompt(){return this.prompt;}
	
	public ReadPINEvent(String prompt, int maxValue) 
	{
		super(maxValue);
		this.prompt = prompt;
	}
}
