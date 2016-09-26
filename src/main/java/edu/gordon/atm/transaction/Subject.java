package edu.gordon.atm.transaction;

public abstract class Subject 
{
	protected PINListener listener;
	
	public void addListener(PINListener listener) 
	{
		this.listener = listener;
	}
}
