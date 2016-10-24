package edu.gordon.pubsub.upper;

import com.google.common.eventbus.Subscribe;

import edu.gordon.atm.broadcaster.BroadcastMoney;
import edu.gordon.simulation.Simulation;

public class DispenseCashComponent 
{
	@Subscribe
	public void handleEvent(DispenseCashEvent evt) 
	{
		Simulation.dispenseCash((BroadcastMoney) evt.getSource());
	}
}
