package edu.gordon.pubsub.upper;

import java.util.EventObject;

public class ReadMenuChoiceEvent extends EventObject
{
	private static final long serialVersionUID = 1L;
	
	private String prompt;
	private String[] menu;
	private int maxValue;
	
	public String getPrompt()
	{
		return this.prompt;
	}
	
	public int getMaxValue()
	{
		return this.maxValue;
	}
	
	public String[] getMenu()
	{
		return this.menu;
	}
		
	public ReadMenuChoiceEvent(Object source, String prompt, String[] menu, int maxValue) 
	{
		super(source);
		this.prompt=prompt;
		this.maxValue=maxValue;
		this.menu=menu;
	}
}
