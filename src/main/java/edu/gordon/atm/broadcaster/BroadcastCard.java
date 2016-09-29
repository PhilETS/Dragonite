package edu.gordon.atm.broadcaster;

import edu.gordon.banking.Card;

public class BroadcastCard extends Card 
{
	public BroadcastCard(int number) 
	{
		super(number);
	}
	
	   /** Accessor for number
    *
    *  @return the number of the card
    */
	@Override
    public int getNumber()
    {
        return number;
    }
}
