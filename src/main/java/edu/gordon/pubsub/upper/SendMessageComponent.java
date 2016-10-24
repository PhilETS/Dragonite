package edu.gordon.pubsub.upper;

import com.google.common.eventbus.Subscribe;

import edu.gordon.simulation.Simulation;

public class SendMessageComponent 
{
	@Subscribe
	public void handleEvent(SendMessageEvent evt) 
	{
		Simulation.sendMessage(evt.getMessage(), evt.getBalances());
	}
}
