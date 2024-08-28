package com.web3.studentdetails.controller;

import com.web3.studentdetails.model.StudentDetailsModel;
import com.web3.studentdetails.service.StudentDetailsService;
import java.util.List;

import com.web3.studentdetails.studentexception.WrongID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Application - Student API
 * Student api controller are declared here.
 *
 * @author  Naveen
 * @version 1.0
 * @since   2022-09-21
 */
@RestController
public class StudentDetailsController  {
  /**
   * Student Details service class is autowired.
   */
  @Autowired
  private StudentDetailsService studentDetailsService;

  /**
   * Used to save the details in database.
   * @param studentDetailsModel
   * @return StudentDetailsModel returned
   */
  @PostMapping("/save")
  public ResponseEntity<Object> createStudent(@RequestBody final StudentDetailsModel studentDetailsModel) {
    return studentDetailsService.saveStudent(studentDetailsModel);
  }

  /**
   * Used to get all the details from the database.
   * @return List<StudentDetailsModel> returned.
   */
  @RequestMapping("/get")
  public List<StudentDetailsModel> getAllStudentDetails() {
    return studentDetailsService.allStudentDetails();
  }

  /**
   * Used to get the value of a particular ID.
   * @param id
   * @return StudentDetailsModel returned.
   */
  @GetMapping("/get/{id}")
  public ResponseEntity<Object> getStudentById(@PathVariable final int id) throws WrongID {
    return studentDetailsService.studentDetailsById(id);
  }

  /**
   * Delete all the details from the table.
   * @return String returned.
   */
  @DeleteMapping("/delete")
  public ResponseEntity<Object> deleteStudent() {
    return studentDetailsService.deleteStudent();
  }

  /**
   * Delete particular Id from database.
   * @param id
   * @return String returned.
   */
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Object> deleteStudentById(@PathVariable final int id) {
    return studentDetailsService.deleteStudentDetailsById(id);
  }

  /**
   * Update the particular Details of the Student.
   * @param studentDetailsModel
   * @return String returned.
   */
  @PutMapping("/update")
  public ResponseEntity<Object> updateStudent(@RequestBody final StudentDetailsModel studentDetailsModel) {
    return studentDetailsService.updateStudent(studentDetailsModel);
  }

  /**
   * Get the student details by name and id.
   * @param name
   * @param id
   * @return List<StudentDetailsModel> returned.
   */
  @GetMapping("/get/name/{name}/id/{id}")
  public List<StudentDetailsModel> getStudentByNameAndId(@PathVariable final String name,
                                                   @PathVariable final int id) {
    return  studentDetailsService.studentDetailsByRollNumberAndName(id, name);
  }
}
