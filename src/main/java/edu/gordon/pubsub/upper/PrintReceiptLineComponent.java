package edu.gordon.pubsub.upper;

import com.google.common.eventbus.Subscribe;

import edu.gordon.simulation.Simulation;

public class PrintReceiptLineComponent 
{
	@Subscribe
	public void handleEvent(PrintReceiptLineEvent evt) 
	{
		Simulation.printReceiptLine((String)evt.getSource());
	}
}
