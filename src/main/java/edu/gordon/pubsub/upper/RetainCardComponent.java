package edu.gordon.pubsub.upper;

import com.google.common.eventbus.Subscribe;

import edu.gordon.simulation.Simulation;

public class RetainCardComponent 
{
	@Subscribe
	public void handleEvent(RetainCardEvent evt) 
	{
		Simulation.retainCard();
	}
}
