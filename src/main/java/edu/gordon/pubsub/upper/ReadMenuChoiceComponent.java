package edu.gordon.pubsub.upper;

import com.google.common.eventbus.Subscribe;

import edu.gordon.simulation.Simulation;

public class ReadMenuChoiceComponent 
{
	@Subscribe
	public void handleEvent(ReadMenuChoiceEvent evt) 
	{
		Simulation.readMenuChoice(evt.getPrompt(), evt.getMenu(), evt.getMaxValue());
	}
}
