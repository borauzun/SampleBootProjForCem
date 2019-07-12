package com.tbuk.psd2.model.enums;
public enum TransactionStatus {
  INVALID_STATUS(0),                  // invalid status
  PENDING(1),                          // the transaction is pending submission
  PROCESSING(7),                   // the transaction is being processed
  SUCCESS(2),                          // the transaction has been successful
  PENDING_EXTERNAL_AUTHORIZATION(15),  // the transaction requires authorization by the user to complete
//  FAILURE_CANCELED = 10;                // the transaction has been canceled, rolled back
  FAILURE_INSUFFICIENT_FUNDS(3),       // the transaction has failed due to insufficient funds
//  FAILURE_INVALID_CURRENCY(4),         // the transaction has failed due to currency mismatch
//  FAILURE_PERMISSION_DENIED = 6;        // the transaction has failed due to access violation
//  FAILURE_QUOTE_EXPIRED = 11;           // the transaction has failed because the quote has expired
//  FAILURE_INVALID_AMOUNT = 12;          // the transaction has failed due to invalid amount
//  FAILURE_INVALID_QUOTE = 13;           // the transaction has failed due to invalid quote (wrong fx rate)
//  FAILURE_EXPIRED = 14;                 // the transaction has failed to complete within alotted time
  FAILURE_GENERIC(5),                  // the transaction has failed due to other reasons
  SENT(16),                           // legacy transfers only: the transaction has been sent but has not been acknowledged by the bank
  INITIATED(17);                       // the transaction has been initiated but the result is unknown, this may be the final status and may not get updated later
  int tStatus;
	TransactionStatus(int x){tStatus=x;}
	
	public int getTransactionStatus() {return tStatus;}
}