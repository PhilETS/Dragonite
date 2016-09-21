package edu.gordon.atm.physical;

import edu.gordon.atm.Listener;

public abstract class Subject 
{
	protected Listener listener;
	
	public void addListener(Listener listener) 
	{
		this.listener = listener;
	}
}
