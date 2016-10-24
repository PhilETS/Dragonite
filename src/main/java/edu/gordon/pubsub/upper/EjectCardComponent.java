package edu.gordon.pubsub.upper;

import com.google.common.eventbus.Subscribe;

import edu.gordon.simulation.Simulation;

public class EjectCardComponent 
{
	@Subscribe
	public void handleEvent(EjectCardEvent evt) 
	{
		Simulation.ejectCard();
	}
}
