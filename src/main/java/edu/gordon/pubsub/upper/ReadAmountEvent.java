package edu.gordon.pubsub.upper;

import java.util.EventObject;

public class ReadAmountEvent extends EventObject
{
	private static final long serialVersionUID = 1L;
	
	private String prompt;
	private int maxValue;
	
	public String getPrompt()
	{
		return this.prompt;
	}
	
	public int getMaxValue()
	{
		return this.maxValue;
	}
		
	public ReadAmountEvent(Object source, String prompt, int maxValue) 
	{
		super(source);
		this.prompt=prompt;
		this.maxValue=maxValue;
	}
}
