package edu.gordon.pubsub.lower;

import com.google.common.eventbus.Subscribe;
import edu.gordon.atm.broadcaster.BroadcastMoney;
import edu.gordon.atm.physical.OperatorPanel;

public class GetInitialCashComponent 
{
	@Subscribe
	public void handleEvent(GetInitialCashEvent evt) 
	{
		try
		{
			OperatorPanel.receiveGetInitialCash((BroadcastMoney)evt.getSource());
		} 
		catch(Exception e){e.printStackTrace();}

	}
}
