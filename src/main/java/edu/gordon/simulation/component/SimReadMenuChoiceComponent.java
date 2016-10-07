package edu.gordon.simulation.component;

import com.google.common.eventbus.Subscribe;

import edu.gordon.atm.physical.event.PrintReceiptLineEvent;
import edu.gordon.simulation.Simulation;

public class SimReadMenuChoiceComponent 
{
	@Subscribe
	public void handleEvent(PrintReceiptLineEvent evt) 
	{
		Simulation.printReceiptLine((String)evt.getSource());
	}
}
