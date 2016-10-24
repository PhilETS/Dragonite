package edu.gordon.simulation;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import edu.gordon.atm.broadcaster.BroadcastBalances;
import edu.gordon.atm.broadcaster.BroadcastCard;
import edu.gordon.atm.broadcaster.BroadcastMessage;
import edu.gordon.atm.broadcaster.BroadcastMoney;
import edu.gordon.atm.broadcaster.MessageFormat;

public class SimulatedBankWithdrawalTest 
{
	private SimulatedBank simulatedBank;
	private String METHOD_NAME = "withdrawal";
	private Method m;
	@SuppressWarnings("rawtypes")
	private Class[] parameterTypes;
	private Object[] parameters;

	
	@Before
	public void reflect() throws Exception
	{
		simulatedBank = new SimulatedBank();
        parameterTypes = new Class[2];
        parameterTypes[0] = BroadcastMessage.class;
        parameterTypes[1] = BroadcastBalances.class;
        m = simulatedBank.getClass().getDeclaredMethod(METHOD_NAME, parameterTypes);
        m.setAccessible(true);
	}
	
	@Test
	public void withdrawalTestSuccess() throws Exception
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
		
		parameters = new Object[2];
		parameters[0] = message;
		parameters[1] = balances;
		MessageFormat messageFormat = (MessageFormat)m.invoke(simulatedBank, parameters);
		assertTrue(messageFormat.getStatus().isSuccess());
	}
}
