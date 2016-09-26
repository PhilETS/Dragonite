/* * ATM Example system - file Inquiry.java    * * copyright (c) 2001 - Russell C. Bjork * */ package edu.gordon.atm.transaction;import edu.gordon.atm.ATM;import edu.gordon.banking.Receipt;import edu.gordon.atm.Session;import edu.gordon.atm.physical.CardReader;import edu.gordon.atm.physical.CashDispenser;import edu.gordon.atm.physical.CustomerConsole;import edu.gordon.atm.physical.EnvelopeAcceptor;import edu.gordon.atm.physical.NetworkToBank;import edu.gordon.atm.physical.ReceiptPrinter;import edu.gordon.banking.AccountInformation;import edu.gordon.banking.Card;import edu.gordon.banking.Message;import edu.gordon.banking.Money;/** Representation for a balance inquiry transaction */public class Inquiry extends Transaction{    /** Constructor     *     *  @param edu.gordon.atm the ATM used to communicate with customer     *  @param session the session in which the transaction is being performed     *  @param card the customer's card     *  @param pin the PIN entered by the customer     */    public Inquiry(ReceiptPrinter receiptPrinter, NetworkToBank networkToBank, CashDispenser cashDispenser, EnvelopeAcceptor envelopeAcceptor, String bankName, int id, String place, CardReader cardReader, CustomerConsole customerConsole, Card card, int pin)    {        super(receiptPrinter, networkToBank, cashDispenser, envelopeAcceptor, bankName, id, place, cardReader, customerConsole, card, pin);    }        /** Get specifics for the transaction from the customer     *     *  @return message to bank for initiating this transaction     *  @exception CustomerConsole.Cancelled if customer cancelled this transaction     */    protected Message getSpecificsFromCustomer() throws CustomerConsole.Cancelled    {        from = this.customerConsole.readMenuChoice(            "Account to inquire from",            AccountInformation.ACCOUNT_NAMES);        return new Message(Message.INQUIRY,                         card, pin, serialNumber, from, -1, new Money(0));    }        /** Complete an approved transaction     *     *  @return receipt to be printed for this transaction     */    protected Receipt completeTransaction()    {        return new Receipt(this.bankName, this.id, this.place, this.getSerialNumber(), this.card, this.balances) {            {                detailsPortion = new String[2];                detailsPortion[0] = "INQUIRY FROM: " +                                     AccountInformation.ACCOUNT_ABBREVIATIONS[from];                detailsPortion[1] = "";            }        };    }        /** Account to inquire about     */    private int from;    }