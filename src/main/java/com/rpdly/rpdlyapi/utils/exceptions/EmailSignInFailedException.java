package com.rpdly.rpdlyapi.utils.exceptions;

public class EmailSignInFailedException extends RuntimeException{

  public EmailSignInFailedException(String msg) {
    super(msg);
  }

  public EmailSignInFailedException() {
    super();
  }
}
