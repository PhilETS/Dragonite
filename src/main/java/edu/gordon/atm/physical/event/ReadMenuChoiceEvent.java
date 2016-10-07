package edu.gordon.atm.physical.event;

import java.util.EventObject;

public class ReadMenuChoiceEvent extends EventObject
{
	private static final long serialVersionUID = 1L;
	
	private String prompt;
	public String getPrompt(){return this.prompt;}
	
	private String[] menu;
	public String[] getMenu(){return this.menu;}
	
	public ReadMenuChoiceEvent(String prompt, String[] menu, int source) 
	{
		super(source);
	}
}
