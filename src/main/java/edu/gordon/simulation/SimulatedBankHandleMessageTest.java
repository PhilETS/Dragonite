package edu.gordon.simulation;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.gordon.atm.broadcaster.BroadcastBalances;
import edu.gordon.atm.broadcaster.BroadcastCard;
import edu.gordon.atm.broadcaster.BroadcastMessage;
import edu.gordon.atm.broadcaster.BroadcastMoney;
import edu.gordon.atm.broadcaster.MessageFormat;

public class SimulatedBankHandleMessageTest 
{
	private SimulatedBank simulatedBank = new SimulatedBank();
	
	@Test
	public void handleMessageTestSuccess() 
	{
		int messageCode = 0;
		
		int number = 1;
		BroadcastCard card = new BroadcastCard(number);
		
		int pin = 42;
		
		int withdrawalMoney = 20;
		BroadcastMoney amount = new BroadcastMoney(withdrawalMoney);
		
		int serialNumber = 3;
		int fromAccount = 0;
		int toAccount = -1;
		
		BroadcastMessage message = new BroadcastMessage(messageCode, card, pin, serialNumber, fromAccount, toAccount, amount);
		BroadcastBalances balances = new BroadcastBalances();
		
		MessageFormat messageFormat = simulatedBank.handleMessage(message, balances); 
		assertTrue(messageFormat.getStatus().isSuccess());
	}
	
	@Test
	public void handleMessageTestFailure() 
	{
		int messageCode = 0;
		
		int number = 1;
		BroadcastCard card = new BroadcastCard(number);
		
		//invalid PIN for number 1
		int pin = 46;
		
		int withdrawalMoney = 20;
		BroadcastMoney amount = new BroadcastMoney(withdrawalMoney);
		
		int serialNumber = 3;
		int fromAccount = 0;
		int toAccount = -1;
		
		BroadcastMessage message = new BroadcastMessage(messageCode, card, pin, serialNumber, fromAccount, toAccount, amount);
		BroadcastBalances balances = new BroadcastBalances();
		
		MessageFormat messageFormat = simulatedBank.handleMessage(message, balances);
		assertTrue(messageFormat.getStatus().isInvalidPIN());
	}
}
