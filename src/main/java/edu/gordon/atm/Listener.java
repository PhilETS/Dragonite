package edu.gordon.atm;

import edu.gordon.banking.Balances;
import edu.gordon.banking.Card;
import edu.gordon.banking.Message;
import edu.gordon.banking.Money;
import edu.gordon.banking.Status;

public abstract class Listener
{
	public abstract void ListenDispenseCash(Money amount);
	
	public abstract boolean ListenAcceptEnvelope();

	public abstract String ListenReadPIN(String prompt, int maxValue);
	
	public abstract String ListenReadMenuChoice(String prompt, String[] menu, int maxValue);
	
	public abstract String ListenReadAmount(String prompt, int maxValue);

	public abstract void ListenDisplay(String message);

	public abstract Status ListenSendMessage(Message message, Balances balances);

	public abstract void ListenPrintLogLine(String text);

	public abstract Money ListenGetInitialCash();

	public abstract void ListenPrintReceiptLine(String nextElement);

	public abstract Card ListenReadCard();

	public abstract void ListenEjectCard();
	
	public abstract void ListenRetainCard();
}
