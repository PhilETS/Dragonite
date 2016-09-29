package edu.gordon.atm.physical;

import edu.gordon.atm.broadcaster.BroadcastBalances;
import edu.gordon.atm.broadcaster.BroadcastCard;
import edu.gordon.atm.broadcaster.BroadcastMessage;
import edu.gordon.atm.broadcaster.BroadcastMoney;
import edu.gordon.atm.broadcaster.MessageFormat;

public abstract class Listener
{
	public abstract void ListenDispenseCash(BroadcastMoney amount);
	
	public abstract boolean ListenAcceptEnvelope();

	public abstract String ListenReadPIN(String prompt, int maxValue);
	
	public abstract String ListenReadMenuChoice(String prompt, String[] menu, int maxValue);
	
	public abstract String ListenReadAmount(String prompt, int maxValue);

	public abstract void ListenDisplay(String message);

	public abstract MessageFormat ListenSendMessage(BroadcastMessage message, BroadcastBalances balances);

	public abstract void ListenPrintLogLine(String text);

	public abstract BroadcastMoney ListenGetInitialCash();

	public abstract void ListenPrintReceiptLine(String nextElement);

	public abstract BroadcastCard ListenReadCard();

	public abstract void ListenEjectCard();
	
	public abstract void ListenRetainCard();
}
