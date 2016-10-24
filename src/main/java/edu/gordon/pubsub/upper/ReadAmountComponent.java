package edu.gordon.pubsub.upper;

import com.google.common.eventbus.Subscribe;

import edu.gordon.simulation.Simulation;

public class ReadAmountComponent 
{
	@Subscribe
	public void handleEvent(ReadAmountEvent evt) 
	{
		Simulation.readAmount(evt.getPrompt(), evt.getMaxValue());
	}
}
