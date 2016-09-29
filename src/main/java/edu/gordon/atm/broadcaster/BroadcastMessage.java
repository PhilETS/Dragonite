package edu.gordon.atm.broadcaster;

import edu.gordon.banking.Card;
import edu.gordon.banking.Message;
import edu.gordon.banking.Money;

public class BroadcastMessage extends Message 
{
    public BroadcastMessage(int messageCode, Card card, int pin, 
            int serialNumber, int fromAccount, int toAccount, Money amount)
    {
    	super(messageCode, card, pin, serialNumber, fromAccount, toAccount, amount);
	}
    
    /** Accessor for customer's card
    *
    *  @return the customer's card
    */
    @Override
    public BroadcastCard getCard()
    {
        return convertCard(super.getCard());
    }
    
    private BroadcastCard convertCard(Card card) 
    {
    	return new BroadcastCard(card.getNumber());
	}

	/** Accessor for "from" account
    *
    *  @return the type of the "from" account
    */
    @Override
    public int getFromAccount()
    {
        return super.getFromAccount();
    }
   
   /** Accessor for "to" account
    *
    *  @return the type of the "to" account
    */
    @Override
    public int getToAccount()
    {
        return super.getToAccount();
    }
    
    
    /** Accessor for acmount
     *
     *  @return the transaction amount
     */
    @Override
    public BroadcastMoney getAmount()
    {
    	Money money = super.getAmount();
        return new BroadcastMoney(money.getCents());
    }
    
    /** Accessor for PIN
    *
    *  @return the PIN entered by the customer
    */
    @Override
    public int getPIN()
    {
        return super.getPIN();
    }
    
    /** Accessor for message code
    *
    *  @return the code identifying the type of message
    */
    @Override
    public int getMessageCode()
    {
        return super.getMessageCode();
    }
}
