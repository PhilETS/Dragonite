package edu.gordon.simulation;

import com.google.common.eventbus.Subscribe;

import edu.gordon.atm.physical.event.PrintReceiptLineEvent;

public class SimReadPINComponent 
{
	@Subscribe
	public void handleEvent(PrintReceiptLineEvent evt) 
	{
		Simulation.printReceiptLine((String)evt.getSource());
	}
}
