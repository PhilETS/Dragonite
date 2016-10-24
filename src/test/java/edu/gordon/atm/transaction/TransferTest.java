package edu.gordon.atm.transaction;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import edu.gordon.atm.ATM;
import edu.gordon.atm.broadcaster.BroadcastBalances;
import edu.gordon.atm.broadcaster.BroadcastCard;
import edu.gordon.atm.broadcaster.BroadcastMessage;
import edu.gordon.atm.broadcaster.BroadcastMoney;
import edu.gordon.atm.broadcaster.MessageFormat;
import edu.gordon.atm.physical.CardReader;
import edu.gordon.atm.physical.CashDispenser;
import edu.gordon.atm.physical.CustomerConsole;
import edu.gordon.atm.physical.EnvelopeAcceptor;
import edu.gordon.atm.physical.Log;
import edu.gordon.atm.physical.NetworkToBank;
import edu.gordon.atm.physical.ReceiptPrinter;
import edu.gordon.banking.Card;
import edu.gordon.banking.Message;
import edu.gordon.banking.Money;
import edu.gordon.pubsub.upper.Utilities;
import edu.gordon.simulation.Simulation;

public class TransferTest 
{
	private Transfer transfer;
	private Log log;
	private ReceiptPrinter receiptPrinter;
	private NetworkToBank networkToBank;
	private CashDispenser cashDispenser;
	private EnvelopeAcceptor envelopeAcceptor;
	private String bankname;
	private int id; 
	private String place;
	private CardReader cardReader;
	private CustomerConsole customerConsole;
	private Card card;
	private int pin;
	private ATM theATM;
	@SuppressWarnings("unused")
	private Simulation theSimulation;
	
	@Before
	public void reflect() throws Exception
	{
		theATM = new ATM(42, "Gordon College", "First National Bank of Podunk", null);
		theSimulation = new Simulation(theATM);
		log = new Log();
		receiptPrinter = new ReceiptPrinter();
		networkToBank = new NetworkToBank(log, null);
		cashDispenser = new CashDispenser(log);
		cashDispenser.setInitialCash(new Money(10000));
		envelopeAcceptor = new EnvelopeAcceptor(log);

		bankname = "First National Bank of Podunk";
		id = 42;
		place = "Gordon College";

		cardReader = new CardReader();
		customerConsole = new CustomerConsole();
		card = new Card(1);

		pin = 42;

		transfer = new Transfer(receiptPrinter, networkToBank, cashDispenser, envelopeAcceptor, bankname, id, place, cardReader, customerConsole, card, pin);
	}
	
	@Test
	public void depositTestSuccess() throws Exception
	{
		Utilities.jUnitTest = true;
		Message message = transfer.getSpecificsFromCustomer();
		assertTrue(message.getCard().getNumber() == 1);
		assertTrue(message.getPIN() == 42);
		assertTrue(message.getMessageCode() == 3);
		/*assertTrue(message.getSerialNumber() == 1);*/
		assertTrue(message.getFromAccount() == 1);
		assertTrue(message.getToAccount() == 2);
		assertTrue(message.getAmount().getCents() == new Money(40).getCents());
		//System.out.println(message.getAmount().getCents() +"=="+ new Money(40).getCents());
	}
}
