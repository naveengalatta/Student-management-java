package com.web3.studentdetails.service;

import com.web3.studentdetails.model.StudentDetailsModel;
import com.web3.studentdetails.repository.StudentDetailsRepository;
import com.web3.studentdetails.studentexception.WrongID;
import com.web3.studentdetails.utill.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Spring Application
 * starting point of spring application.
 *
 * @author  Naveen
 * @version 1.0
 * @since   2022-09-21
 */
@Service
public class StudentDetailsService {
  /**
   * Student details repository object is created.
   */
  @Autowired
  private StudentDetailsRepository studentDetailsRepository;


  /**
   * To find all the student details.
   * @return List<StudentDetailsModel> is returned.
   */
  public List<StudentDetailsModel> allStudentDetails() {
    //List<StudentDetailsModel> isStudentExist = studentDetailsRepository.findAll();
    return studentDetailsRepository.findAll();
  }

  /**
   * get the student details by ID.
   * @param id
   * @return StudentDetailsModel is returned.
   */
  public ResponseEntity<Object> studentDetailsById(final int id) throws WrongID {
    boolean isStudentExist = studentDetailsRepository.existsById(id);
    if (!isStudentExist) {
      throw new WrongID(id + " does not exist");
    }
    return new ResponseEntity<>(studentDetailsRepository.findById(id).orElse(null), HttpStatus.OK);
    //return studentDetailsRepository.findById(id).orElse(null);
  }

  /**
   * Save the student details in database.
   * @param studentDetailsModel
   * @return student details which is sent is returned.
   */
  public ResponseEntity<Object> saveStudent(final StudentDetailsModel studentDetailsModel) {
    Map<String, String> json = new HashMap<>();
    //Condition
    Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    if (studentDetailsModel.getEmail() == null || "".equals(studentDetailsModel.getEmail())) {
      json.put(Constant.MESSAGE, "Empty email field");
      return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
    }
    Matcher matcher = pattern.matcher(studentDetailsModel.getEmail());
    boolean matchFound = matcher.find();
    if (!matchFound) {
      json.put(Constant.MESSAGE, "Not valid email pattern");
      return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(studentDetailsRepository.save(studentDetailsModel), HttpStatus.OK);
  }

  /**
   * delete student.
   * @return ResponseEntity<Object>
   */
  public ResponseEntity<Object> deleteStudent() {
    Map<String, String> json = new HashMap<>();
    List<StudentDetailsModel> allStudent = studentDetailsRepository.findAll();
    if (allStudent == null) {
      json.put(Constant.MESSAGE, "Deletion fail");
      return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
    } else {
      studentDetailsRepository.deleteAll();
      return new ResponseEntity<>(allStudent, HttpStatus.OK);
    }
  }

  /**
   * deleteStudentDetailsById.
   * @param id
   * @return ResponseEntity<Object>
   */
  public ResponseEntity<Object> deleteStudentDetailsById(final int id) {
    Map<String, String> json = new HashMap<>();
    StudentDetailsModel studentDetailsModel = studentDetailsRepository.findById(id).orElse(null);
    if (studentDetailsModel == null) {
      json.put(Constant.MESSAGE, "Deletion failed");
      return new ResponseEntity<>(json, HttpStatus.NOT_FOUND);
    }
     studentDetailsRepository.deleteById(id);
     return new ResponseEntity<>(studentDetailsModel, HttpStatus.OK);
  }

  /**
   * Update student Details.
   * @param studentDetailsModel
   * @return String is returned.
   */
  public ResponseEntity<Object> updateStudent(final StudentDetailsModel studentDetailsModel) {
    if (studentDetailsRepository.findById(studentDetailsModel.getRollNumber()).orElse(null) == null) {
      Map<String, String> json = new HashMap<>();
      json.put(Constant.MESSAGE, "Updation failed");
      return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
    }
    studentDetailsRepository.save(studentDetailsModel);
    return new ResponseEntity<>(studentDetailsModel, HttpStatus.OK);
  }

  /**
   * Get by RollNumber and Name service.
   * @param rollNumber
   * @param name
   * @return List<StudentDetailsModel> with roll number and name is get.
   */
  public List<StudentDetailsModel> studentDetailsByRollNumberAndName(final int rollNumber, final String name) {
    if (studentDetailsRepository.findByRollNumberAndName(rollNumber, name) == null) {
      return null;
    }
    return studentDetailsRepository.findByRollNumberAndName(rollNumber, name);
  }
}
