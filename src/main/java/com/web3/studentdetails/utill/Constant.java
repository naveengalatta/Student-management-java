package com.web3.studentdetails.utill;

import com.web3.studentdetails.model.StudentDetailsModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Constant class
 * used to declare constant values.
 *
 * @author  Naveen
 * @version 1.0
 * @since   2022-09-21
 */
public final class Constant {
  /**
   * private constructor is created.
   */
  private Constant() {

  }

  /**
   * List is made for static storage.
   */
  public static final List<StudentDetailsModel> LIST = new ArrayList<>();
  /**
   * auto increment the roll number.
   */
  public static final int ROLL_NUMBER = 0;
  /**
   * constant string.
   */
  public static final String CREATED_SUCCESSFULLY = "Created successfully";
  /**
   * constant string.
   */
  public static final String NOT_CREATED_SUCCESSFULLY = "Not created successfully";
  /**
   * constant string.
   */
  public static final String UPDATED_SUCCESSFULLY = "Updated successfully";
  /**
   * constant string.
   */
  public static final String NOT_UPDATED_SUCCESSFULLY = "Not updated successfully";
  /**
   * constant string.
   */
  public static final String DELETED_SUCCESSFULLY = "Deleted successfully";
  /**
   * constant string.
   */
  public static final String NOT_DELETED_SUCCESSFULLY = "Not deleted successfully";
  /**
   * constant string.
   */
  public static final String SPACE = " ";
  /**
   * constant string.
   */
  public static final String MESSAGE = "message";
}
