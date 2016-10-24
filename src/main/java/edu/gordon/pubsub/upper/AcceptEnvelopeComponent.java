package edu.gordon.pubsub.upper;

import com.google.common.eventbus.Subscribe;

import edu.gordon.simulation.Simulation;

public class AcceptEnvelopeComponent 
{
	@Subscribe
	public void handleEvent(AcceptEnvelopeEvent evt) 
	{
		Simulation.acceptEnvelope();
	}
}
