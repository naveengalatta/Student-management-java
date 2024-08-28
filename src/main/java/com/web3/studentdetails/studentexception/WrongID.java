package com.web3.studentdetails.studentexception;

public class WrongID extends RuntimeException {
  /**
   * Constructor which calls Exception class.
   * @param message
   */
  public WrongID(final String message) {
    super(message);
  }
}
