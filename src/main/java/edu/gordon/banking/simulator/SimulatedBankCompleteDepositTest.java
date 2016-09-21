package edu.gordon.banking.simulator;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import edu.gordon.banking.Balances;
import edu.gordon.banking.Card;
import edu.gordon.banking.Message;
import edu.gordon.banking.Money;
import edu.gordon.banking.Status;

public class SimulatedBankCompleteDepositTest 
{
	private SimulatedBank simulatedBank;
	private String METHOD_NAME = "completeDeposit";
	private Method m;
	@SuppressWarnings("rawtypes")
	private Class[] parameterTypes;
	private Object[] parameters;

	
	@Before
	public void reflect() throws Exception
	{
		simulatedBank = new SimulatedBank();
        parameterTypes = new Class[2];
        parameterTypes[0] = Message.class;
        parameterTypes[1] = Balances.class;
        m = simulatedBank.getClass().getDeclaredMethod(METHOD_NAME, parameterTypes);
        m.setAccessible(true);
	}
	
	@Test
	public void depositTest() throws Exception
	{
		int messageCode = 0;
		
		int number = 1;
		Card card = new Card(number);
		
		int pin = 42;
		
		int depositMoney = 20;
		Money amount = new Money(depositMoney);
		
		int serialNumber = 3;
		int fromAccount = 0;
		int toAccount = 1;
		
		Message message = new Message(messageCode, card, pin, serialNumber, fromAccount, toAccount, amount);
		Balances balances = new Balances();
		
		parameters = new Object[2];
		parameters[0] = message;
		parameters[1] = balances;
		Status status = (Status)m.invoke(simulatedBank, parameters);
		assertTrue(status.isSuccess());
	}

}
