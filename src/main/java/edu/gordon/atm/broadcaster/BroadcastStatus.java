package edu.gordon.atm.broadcaster;

import edu.gordon.banking.Status;

public abstract class BroadcastStatus extends Status 
{
	 /** See if this status represents success
    *
    *  @return true if this status represents success
    */
	@Override
    public abstract boolean isSuccess();
   
   /** See if this status represents an invalid PIN
    *
    *  @return true if this status represents an invalid PIN
    */
	@Override
    public abstract boolean isInvalidPIN();
   
   /** Accessor for message describing this status (used if status is
    *  not success)
    *
    *  @return description of the problem
    */
    @Override
    public abstract String getMessage();
}