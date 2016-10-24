package edu.gordon.pubsub.lower;

import com.google.common.eventbus.Subscribe;
import edu.gordon.atm.broadcaster.MessageFormat;
import edu.gordon.atm.physical.NetworkToBank;

public class SendMessageComponent 
{
	@Subscribe
	public void handleEvent(SendMessageEvent evt) 
	{
		try
		{
			NetworkToBank.receiveSendMessage((MessageFormat)evt.getSource());
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
