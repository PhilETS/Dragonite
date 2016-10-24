package edu.gordon.pubsub.lower;

import com.google.common.eventbus.Subscribe;
import edu.gordon.atm.physical.CustomerConsole;

public class ReadMenuChoiceComponent 
{
	@Subscribe
	public void handleEvent(ReadMenuChoiceEvent evt) 
	{
		CustomerConsole.receiveReadMenuChoice((String)evt.getSource());
	}
}
