/* * ATM Example system - file SimulatedBank.java  * * copyright (c) 2001 - Russell C. Bjork * */ package edu.gordon.simulation;import edu.gordon.atm.broadcaster.BroadcastBalances;import edu.gordon.atm.broadcaster.BroadcastMessage;import edu.gordon.atm.broadcaster.BroadcastMoney;import edu.gordon.atm.broadcaster.BroadcastStatus;import edu.gordon.atm.broadcaster.MessageFormat;/** Simulation of the bank.  A set of simulated accounts is initalized at startup. */public class SimulatedBank{    /** Simulate the handling of a message     *     *  @param message the message to send     *  @param balances (out) balances in customer's account as reported     *         by bank     *  @return status code returned by bank     */    public MessageFormat handleMessage(BroadcastMessage message, BroadcastBalances balances)    {               int cardNumber = message.getCard().getNumber();         if (cardNumber < 1 || cardNumber > PIN.length)            return new MessageFormat(new Failure("Invalid card"),null);            if (message.getPIN() != PIN [ cardNumber ] )            return new MessageFormat(new InvalidPIN(), null);            switch(message.getMessageCode())        {            case BroadcastMessage.WITHDRAWAL:                            return withdrawal(message, balances);                                        case BroadcastMessage.INITIATE_DEPOSIT:                            return initiateDeposit(message);                        case BroadcastMessage.COMPLETE_DEPOSIT:                            return completeDeposit(message, balances);                        case BroadcastMessage.TRANSFER:                            return transfer(message, balances);                        case BroadcastMessage.INQUIRY:                            return inquiry(message, balances);        }                // Need to keep compiler happy                return null;    }    /** Simulate processing of a withdrawal     *     *  @param message the message describing the withdrawal requested     *  @param balances (out) balances in account after withdrawal     *  @return status code derived from current values     */    private MessageFormat withdrawal(BroadcastMessage message, BroadcastBalances balances)    {        int cardNumber = message.getCard().getNumber();                int accountNumber = ACCOUNT_NUMBER [ cardNumber ] [ message.getFromAccount() ];        if (accountNumber == 0)            return new MessageFormat(new Failure("Invalid account type"), null);            BroadcastMoney amount = message.getAmount();                BroadcastMoney limitRemaining = new BroadcastMoney(DAILY_WITHDRAWAL_LIMIT);        limitRemaining.subtract(WITHDRAWALS_TODAY[ cardNumber ]);        if (! amount.lessEqual(limitRemaining))            return new MessageFormat(new Failure("Daily withdrawal limit exceeded"), null);        if (! amount.lessEqual(AVAILABLE_BALANCE [ accountNumber ]))             return new MessageFormat(new Failure("Insufficient available balance"), null);        // Update withdrawals today and account balances once we know everything is        // OK                    WITHDRAWALS_TODAY [ cardNumber ].add(amount);        BALANCE [ accountNumber ].subtract(amount);        AVAILABLE_BALANCE [ accountNumber ].subtract(amount);                // Return updated balances                balances.setBalances(BALANCE [ accountNumber ],                              AVAILABLE_BALANCE [ accountNumber ]);                return new MessageFormat(new Success(), balances);    } 	/** Simulate initiation of a deposit. At this point, the bank only approves     *  the validity of the deposit - no changes to the records are made until     *  the envelope is actually inserted      *     *  @param message the message describing the deposit requested     *  @return status code derived from current values     */    private MessageFormat initiateDeposit(BroadcastMessage message)    {        int cardNumber = message.getCard().getNumber();             int accountNumber = ACCOUNT_NUMBER [ cardNumber ] [ message.getToAccount() ];        if (accountNumber == 0)            return new MessageFormat(new Failure("Invalid account type"), null);                    // Don't update anything yet                    return new MessageFormat(new Success(), null);    }            /** Simulate completion of a deposit     *     *  @param message the message describing the deposit requested     *  @param balances (out) balances (not updated until completed)     *  @return status code - must always be success in this case     */    private MessageFormat completeDeposit(BroadcastMessage message, BroadcastBalances balances)    {        int cardNumber = message.getCard().getNumber();                 int accountNumber = ACCOUNT_NUMBER [ cardNumber ] [ message.getToAccount() ];        if (accountNumber == 0)            return new MessageFormat(new Failure("Invalid account type"), null);                    // Now we can update the balance                BroadcastMoney amount = message.getAmount();        BALANCE [ accountNumber ].add(amount);                // Return updated balances                balances.setBalances(BALANCE [ accountNumber ],                              AVAILABLE_BALANCE [ accountNumber ]);                return new MessageFormat(new Success(), balances);    }            /** Simulate processing of a transfer     *     *  @param message the message describing the transfer requested     *  @param balances (out) balances in "to" account after transfer     *  @return status code derived from current values     */    private MessageFormat transfer(BroadcastMessage message, BroadcastBalances balances)    {        int cardNumber = message.getCard().getNumber();             int fromAccountNumber = ACCOUNT_NUMBER [ cardNumber ] [ message.getFromAccount() ];        if (fromAccountNumber == 0)            return new MessageFormat(new Failure("Invalid from account type"), null);            int toAccountNumber = ACCOUNT_NUMBER [ cardNumber ] [ message.getToAccount() ];        if (toAccountNumber == 0)            return new MessageFormat(new Failure("Invalid to account type"), null);        if (fromAccountNumber == toAccountNumber)            return new MessageFormat(new Failure("Can't transfer money from\n" +                    "an account to itself"), null);            BroadcastMoney amount = message.getAmount();                if (! amount.lessEqual(AVAILABLE_BALANCE [ fromAccountNumber ]))             return new MessageFormat(new Failure("Insufficient available balance"), null);        // Update account balances once we know everything is OK                    BALANCE [ fromAccountNumber ].subtract(amount);        AVAILABLE_BALANCE [ fromAccountNumber ].subtract(amount);        BALANCE [ toAccountNumber ].add(amount);        AVAILABLE_BALANCE [ toAccountNumber ].add(amount);                // Return updated balances                balances.setBalances(BALANCE [ toAccountNumber ],                              AVAILABLE_BALANCE [ toAccountNumber ]);                return new MessageFormat(new Success(), balances);    }         /** Simulate processing of an inquiry     *     *  @param message the message describing the inquiry requested     *  @param balances (out) balances in account     *  @return status code derived from current values     */    private MessageFormat inquiry(BroadcastMessage message, BroadcastBalances balances)    {        int cardNumber = message.getCard().getNumber();         int accountNumber = ACCOUNT_NUMBER [ cardNumber ] [ message.getFromAccount() ];        if (accountNumber == 0)            return new MessageFormat(new Failure("Invalid account type"), null);                // Return requested balances                balances.setBalances(BALANCE [ accountNumber ],                              AVAILABLE_BALANCE [ accountNumber ]);                return new MessageFormat(new Success(), balances);    }         /** Representation for status of a transaction that succeeded     */    private static class Success extends BroadcastStatus    {        public boolean isSuccess()        {            return true;        }                public boolean isInvalidPIN()        {            return false;        }                public String getMessage()        {            return null;        }    }        /** Representation for status of a transaction that failed (for reason other than     *  invalid PIN)     */    private static class Failure extends BroadcastStatus    {        /** Constructor         *         *  @param message description of the failure         */        public Failure(String message)        {            this.message = message;        }                public boolean isSuccess()        {            return false;        }                public boolean isInvalidPIN()        {            return false;        }                public String getMessage()        {            return message;        }                private String message;    }    /** Representation for status of a transaction that failed due to an invalid PIN     */    private static class InvalidPIN extends Failure    {        /** Constructor         *         *  @param message description of the failure         */        public InvalidPIN()        {            super("Invalid PIN");        }                public boolean isInvalidPIN()        {            return true;        }    }        /** PIN for each card.  (Valid card numbers start with 1)     */    private static final int PIN [] =    {         0,  // dummy for nonexistent card 0        42,         1234     };    /** Array of account numbers associated with each card.  For each card,     *  there can be three different types of account, which correspond to     *  the names in class AccountInformation.  0 means no account of this     *  type.   (Valid card numbers start with 1)     */    private static final int ACCOUNT_NUMBER [] [] =    {         { 0, 0, 0 },    // dummies for nonexistent card 0        { 1, 2, 0 },        { 1, 0, 3 }    };    /** Withdrawals so far today on each card.   (Valid card numbers start with 1)     */     private static BroadcastMoney WITHDRAWALS_TODAY [] =    {        new BroadcastMoney(0),   // dummy for nonexistent card 0        new BroadcastMoney(0),        new BroadcastMoney(0)    };        /** Maximum daily withdrawal limit for any one card.       */    private static final BroadcastMoney DAILY_WITHDRAWAL_LIMIT = new BroadcastMoney(300);        /** Balance for each account (will change as program runs, hence not a     *  static final.     */    private BroadcastMoney BALANCE [] =    {        new BroadcastMoney(0),   // dummy for nonexistent account 0        new BroadcastMoney(100),         new BroadcastMoney(1000),        new BroadcastMoney(5000)     };         /** Available alance for each account (will change as program runs, hence     *  not a static final.     */    private BroadcastMoney AVAILABLE_BALANCE [] =    {         new BroadcastMoney(0),   // dummy for nonexistent account 0        new BroadcastMoney(100),         new BroadcastMoney(1000),        new BroadcastMoney(5000)     };}    