package edu.gordon.pubsub.lower;

import com.google.common.eventbus.Subscribe;

import edu.gordon.atm.physical.CustomerConsole;

public class ReadPINComponent 
{
	@Subscribe
	public void handleEvent(ReadPINEvent evt) 
	{
		CustomerConsole.receiveReadPIN((String)evt.getPIN());
	}
}
