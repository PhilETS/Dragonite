package edu.gordon.pubsub.upper;

import com.google.common.eventbus.Subscribe;

import edu.gordon.simulation.Simulation;

public class ReadPINComponent 
{
	@Subscribe
	public void handleEvent(ReadPINEvent evt) 
	{
		Simulation.readPIN(evt.getPrompt(), evt.getMaxValue());
	}
}
