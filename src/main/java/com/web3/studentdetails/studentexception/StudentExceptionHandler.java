package com.web3.studentdetails.studentexception;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler extends ResponseEntityExceptionHandler {
  /**
   * User defined exception method.
   * @return ResponseEntity<Object>
   */
  @ExceptionHandler(WrongID.class)
  public ResponseEntity<Object> wrongIDFunction() {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("message", "id not found");
    return new ResponseEntity<Object>(jsonObject, HttpStatus.NOT_FOUND);
  }
}
