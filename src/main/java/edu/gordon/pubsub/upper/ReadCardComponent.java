package edu.gordon.pubsub.upper;

import com.google.common.eventbus.Subscribe;

import edu.gordon.simulation.Simulation;

public class ReadCardComponent 
{
	@Subscribe
	public void handleEvent(ReadCardEvent evt) 
	{
		Simulation.readCard();
	}
}
