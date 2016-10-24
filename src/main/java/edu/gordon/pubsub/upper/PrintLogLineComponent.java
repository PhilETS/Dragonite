package edu.gordon.pubsub.upper;

import com.google.common.eventbus.Subscribe;

import edu.gordon.simulation.Simulation;

public class PrintLogLineComponent 
{
	@Subscribe
	public void handleEvent(PrintLogLineEvent evt) 
	{
		Simulation.printLogLine((String)evt.getSource());
	}
}
