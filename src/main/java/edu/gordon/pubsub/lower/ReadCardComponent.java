package edu.gordon.pubsub.lower;

import com.google.common.eventbus.Subscribe;
import edu.gordon.atm.broadcaster.BroadcastCard;
import edu.gordon.atm.physical.CardReader;

public class ReadCardComponent 
{
	@Subscribe
	public void handleEvent(ReadCardEvent evt) 
	{
		try
		{
			if (evt.getSource() == null)
			{
				CardReader.receiveCard(null);
			}
			else
			{
				CardReader.receiveCard((BroadcastCard)evt.getSource());
			}
			//System.out.println(((BroadcastCard) evt.getSource()).getNumber());
			
	   } catch(Exception e){
    	   e.printStackTrace();
       }

	}
}
