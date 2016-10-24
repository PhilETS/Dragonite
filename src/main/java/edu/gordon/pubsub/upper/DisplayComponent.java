package edu.gordon.pubsub.upper;

import com.google.common.eventbus.Subscribe;

import edu.gordon.simulation.Simulation;

public class DisplayComponent 
{
	@Subscribe
	public void handleEvent(DisplayEvent evt) 
	{
		Simulation.displayMessage((String)evt.getSource());
	}
}
