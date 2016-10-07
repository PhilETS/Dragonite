package edu.gordon.atm.physical.event;

import java.util.EventObject;

public class ReadAmountEvent extends EventObject
{
	private static final long serialVersionUID = 1L;
	
	private String prompt;
	public String getPrompt(){return this.prompt;}
	
	public ReadAmountEvent(String prompt, int source) 
	{
		super(source);
	}
}
