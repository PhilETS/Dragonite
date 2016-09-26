package edu.gordon.atm.physical;


public abstract class Subject 
{
	protected Listener listener;
	
	public void addListener(Listener listener) 
	{
		this.listener = listener;
	}
}
