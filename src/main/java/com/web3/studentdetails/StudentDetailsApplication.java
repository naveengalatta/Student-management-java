package com.web3.studentdetails;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sample restController
 * sample restController to check spring application.
 *
 * @author  Naveen
 * @version 1.0
 * @since   2022-09-21
 */
@RestController
public class StudentDetailsApplication {
  /**
   * Sample Just Check Method.
   * @return Hello Naveen String is returned.
   */
  @RequestMapping("/")
  public String hello() {
    return "Hello Naveen";
  }

}
