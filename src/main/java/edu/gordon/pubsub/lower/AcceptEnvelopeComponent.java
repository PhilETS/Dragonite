package edu.gordon.pubsub.lower;

import com.google.common.eventbus.Subscribe;

import edu.gordon.atm.physical.CustomerConsole.Cancelled;
import edu.gordon.atm.physical.EnvelopeAcceptor;

public class AcceptEnvelopeComponent 
{
	@Subscribe
	public void handleEvent(AcceptEnvelopeEvent evt) 
	{
		try 
		{
			EnvelopeAcceptor.receiveEnvelope((String)evt.getSource());
		} 
		catch (Cancelled e) {e.printStackTrace();}
	}
}
