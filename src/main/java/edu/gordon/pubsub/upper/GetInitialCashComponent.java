package edu.gordon.pubsub.upper;

import com.google.common.eventbus.Subscribe;

import edu.gordon.simulation.Simulation;

public class GetInitialCashComponent 
{
	@Subscribe
	public void handleEvent(GetInitialCashEvent evt) 
	{
		Simulation.getInitialCash();
	}
}
