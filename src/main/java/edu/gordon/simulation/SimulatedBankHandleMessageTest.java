package edu.gordon.simulation;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.gordon.banking.Balances;
import edu.gordon.banking.Card;
import edu.gordon.banking.Message;
import edu.gordon.banking.Money;
import edu.gordon.banking.Status;

public class SimulatedBankHandleMessageTest 
{
	private SimulatedBank simulatedBank = new SimulatedBank();
	
	@Test
	public void handleMessageTestSuccess() 
	{
		int messageCode = 0;
		
		int number = 1;
		Card card = new Card(number);
		
		int pin = 42;
		
		int withdrawalMoney = 20;
		Money amount = new Money(withdrawalMoney);
		
		int serialNumber = 3;
		int fromAccount = 0;
		int toAccount = -1;
		
		Message message = new Message(messageCode, card, pin, serialNumber, fromAccount, toAccount, amount);
		Balances balances = new Balances();
		
		Status status = simulatedBank.handleMessage(message, balances);
		assertTrue(status.isSuccess());
	}
	
	@Test
	public void handleMessageTestFailure() 
	{
		int messageCode = 0;
		
		int number = 1;
		Card card = new Card(number);
		
		//invalid PIN for number 1
		int pin = 46;
		
		int withdrawalMoney = 20;
		Money amount = new Money(withdrawalMoney);
		
		int serialNumber = 3;
		int fromAccount = 0;
		int toAccount = -1;
		
		Message message = new Message(messageCode, card, pin, serialNumber, fromAccount, toAccount, amount);
		Balances balances = new Balances();
		
		Status status = simulatedBank.handleMessage(message, balances);
		assertTrue(status.isInvalidPIN());
	}
}
