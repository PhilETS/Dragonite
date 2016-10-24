package edu.gordon.pubsub.lower;

import com.google.common.eventbus.Subscribe;
import edu.gordon.atm.physical.CustomerConsole;

public class ReadAmountComponent 
{
	@Subscribe
	public void handleEvent(ReadAmountEvent evt) 
	{
		CustomerConsole.receiveReadAmount((String)evt.getSource());
	}
}
