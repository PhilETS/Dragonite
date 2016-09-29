package edu.gordon.atm.broadcaster;

import edu.gordon.banking.Money;

public class BroadcastMoney extends Money 
{
	public BroadcastMoney(int dollars) 
	{
		super(dollars);
	}
	
    /** Copy constructor
    *
    *  @param toCopy the Money object to copy
    */
   public BroadcastMoney(BroadcastMoney toCopy)
   {
	   super(toCopy);
       this.cents = toCopy.getCents();
   }
   
   public BroadcastMoney(long cents)
   {
	   super(cents);
   }

   @Override
   public String toString()
   {
	   return super.toString();
   }
   
   /** Add an amount of money to this
   *
   *  @param amountToAdd the amount to add
   */
   @Override
   public void add(Money amountToAdd)
   {
       super.add(amountToAdd);;
   }
   
   /** Subtract an amount of money from this
   *
   *  @param amountToSubtract the amount to subtract
   *
   *  Precondition: amount must be <= this amount
   */
   @Override
   public void subtract(Money amountToSubtract)
   {
       super.subtract(amountToSubtract);
   }
  
  /** Compare this to another amount
  *
  *  @param compareTo the amount to compare to
  *  @return true if this amount is <= compareTo amount
  */
  @Override
  public boolean lessEqual(Money compareTo)
  {
      return super.lessEqual(compareTo);
  }
}
