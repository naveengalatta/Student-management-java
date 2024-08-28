package com.web3.studentdetails.controller;

import com.web3.studentdetails.model.StudentDetailsModel;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import java.util.Arrays;
import java.util.List;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentDetailsControllerTest {
  /**
   * roll number.
   */
  public int rollNumber = 0;
  /**
   * TestRestTemplate is autowired.
   */
  @Autowired
  private TestRestTemplate testRestTemplate;

  /**
   * createStudentTest_SuccessCase.
   * @throws Exception
   */
  @Test
  @Order(1)
  @RepeatedTest(3)
  public void createStudentTest_SuccessCase() throws Exception {
    //Arrange
    JSONObject requestJSON = new JSONObject();
    requestJSON.put("name","ravi");
    requestJSON.put("gender","male");
    requestJSON.put("parent","sam");
    requestJSON.put("address","Kannyakumari");
    requestJSON.put("dateOfBirth","23/10/2005");
    requestJSON.put("email","w@gmail.com");
    requestJSON.put("section","c");
    requestJSON.put("standard","8");
    requestJSON.put("phoneNumber","9884218765");
    requestJSON.put("bloodGroup","AB-ve");
    requestJSON.put("logo","MonkeyLogo");
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    HttpEntity<String> request = new HttpEntity<>(requestJSON.toString(), headers);
    //Act
    ResponseEntity<StudentDetailsModel> studentDetailsModel = testRestTemplate.exchange("/save", HttpMethod.POST,request, StudentDetailsModel.class);
    StudentDetailsModel createdStudentDetail = studentDetailsModel.getBody();
    //Assert
    Assertions.assertEquals(HttpStatus.OK, studentDetailsModel.getStatusCode());
    rollNumber = createdStudentDetail.getRollNumber();
    Assertions.assertEquals(createdStudentDetail.getName(), requestJSON.getString("name"),"Name does not match");
    Assertions.assertEquals(createdStudentDetail.getGender(), requestJSON.getString("gender"), "Gender does not match");
    Assertions.assertEquals(createdStudentDetail.getParent(), requestJSON.getString("parent"), "Parent does not match");
    Assertions.assertEquals(createdStudentDetail.getAddress(), requestJSON.getString("address"), "Address does not match");
    Assertions.assertEquals(createdStudentDetail.getDateOfBirth(), requestJSON.getString("dateOfBirth"), "DateOfBirth does not match");
    Assertions.assertEquals(createdStudentDetail.getEmail(), requestJSON.getString("email"), "Email does not match");
    Assertions.assertEquals(createdStudentDetail.getSection(), requestJSON.getString("section").charAt(0), "Section does not match");
    Assertions.assertEquals(createdStudentDetail.getStandard(), requestJSON.getInt("standard"), "Standard does not match");
    Assertions.assertEquals(createdStudentDetail.getPhoneNumber(), requestJSON.getLong("phoneNumber"), "PhoneNumber does not match");
    Assertions.assertEquals(createdStudentDetail.getBloodGroup(), requestJSON.getString("bloodGroup"), "BloodGroup does not match");
    Assertions.assertEquals(createdStudentDetail.getLogo(), requestJSON.getString("logo"), "Logo does not match");
  }
  @Test
  @Order(2)
  void getAllStudentDetailsTest_SuccessCase() {
    //Arrange
    HttpHeaders headers = new HttpHeaders();
    headers.set("Accept", "application/json");
    HttpEntity requestEntity = new HttpEntity(null, headers);
    //Act
    ResponseEntity<List<StudentDetailsModel>> response= testRestTemplate.exchange("/get", HttpMethod.GET,
            requestEntity, new ParameterizedTypeReference<List<StudentDetailsModel>>() { });

    //Assert
    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode(), "Http Status is Not 200");
  }
  @Test
  @Order(3)
  void getStudentByIdTest_SuccessCase() {
    //Arrange
    HttpHeaders headers = new HttpHeaders();
    headers.set("Accept", "application/json");
    HttpEntity requestEntity = new HttpEntity(null, headers);
    //Act
    ResponseEntity<StudentDetailsModel> response = testRestTemplate.exchange("/get/"+rollNumber, HttpMethod.GET,
            requestEntity,
            new ParameterizedTypeReference<StudentDetailsModel>() {
            });

    //Assert
    Assertions.assertEquals(HttpStatus.OK, response.getStatusCode(), "Http Status is Not 200");
  }
  /**
   * updateStudentTest SuccessCase
   * @throws JSONException
   */
  @Test
  @Order(4)
  void updateStudentTest_SuccessCase() throws JSONException {
    //Arrange
    JSONObject requestJSON = new JSONObject();
    requestJSON.put("rollNumber", rollNumber);
    requestJSON.put("name","Hema");
    requestJSON.put("gender","female");
    requestJSON.put("parent","Rajesh");
    requestJSON.put("address","Madurai");
    requestJSON.put("dateOfBirth","12/02/2000");
    requestJSON.put("email","hema@gmail.com");
    requestJSON.put("section","h");
    requestJSON.put("standard","12");
    requestJSON.put("phoneNumber","12345678");
    requestJSON.put("bloodGroup","A-ve");
    requestJSON.put("logo","HemaLogo");
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    HttpEntity<String> request = new HttpEntity<>(requestJSON.toString(), headers);

    //Act
    ResponseEntity<StudentDetailsModel> studentDetailsModel = testRestTemplate.exchange("/update",
            HttpMethod.PUT, request, StudentDetailsModel.class);
    StudentDetailsModel createdStudentDetail = studentDetailsModel.getBody();
    //Assert
    Assertions.assertEquals(HttpStatus.OK, studentDetailsModel.getStatusCode());
    Assertions.assertEquals(createdStudentDetail.getName(), requestJSON.getString("name"),"Name does not match");
    Assertions.assertEquals(createdStudentDetail.getGender(), requestJSON.getString("gender"), "Gender does not match");
    Assertions.assertEquals(createdStudentDetail.getParent(), requestJSON.getString("parent"), "Parent does not match");
    Assertions.assertEquals(createdStudentDetail.getAddress(), requestJSON.getString("address"), "Address does not match");
    Assertions.assertEquals(createdStudentDetail.getDateOfBirth(), requestJSON.getString("dateOfBirth"), "DateOfBirth does not match");
    Assertions.assertEquals(createdStudentDetail.getEmail(), requestJSON.getString("email"), "Email does not match");
    Assertions.assertEquals(createdStudentDetail.getSection(), requestJSON.getString("section").charAt(0), "Section does not match");
    Assertions.assertEquals(createdStudentDetail.getStandard(), requestJSON.getInt("standard"), "Standard does not match");
    Assertions.assertEquals(createdStudentDetail.getPhoneNumber(), requestJSON.getLong("phoneNumber"), "PhoneNumber does not match");
    Assertions.assertEquals(createdStudentDetail.getBloodGroup(), requestJSON.getString("bloodGroup"), "BloodGroup does not match");
    Assertions.assertEquals(createdStudentDetail.getLogo(), requestJSON.getString("logo"), "Logo does not match");
  }

  /**
   * deleteStudentById SuccessCase.
   */
  @Test
  @Order(5)
  void deleteStudentById_SuccessCase() {
    //Arrange
    HttpHeaders headers = new HttpHeaders();
    headers.set("Accept", "application/json");
    HttpEntity requestEntity = new HttpEntity(null, headers);
    String url = "/delete/" + rollNumber;
    //Act
    ResponseEntity<StudentDetailsModel> response= testRestTemplate.exchange(url, HttpMethod.DELETE,
            requestEntity, new ParameterizedTypeReference<StudentDetailsModel>() { });
    //Assert
    Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
  }
  /**
   * deleteStudentTest_SuccessCase.
   */
  @Test
  @Order(6)
  void deleteStudentTest_SuccessCase() {
    HttpHeaders headers = new HttpHeaders();
    headers.set("Accept", "application/json");
    HttpEntity requestEntity = new HttpEntity(null, headers);
    //Act
    ResponseEntity<List<StudentDetailsModel>> response= testRestTemplate.exchange("/delete", HttpMethod.DELETE,
            requestEntity, new ParameterizedTypeReference<List<StudentDetailsModel>>() { });
    //Assert
    Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
  }

  /**
   * createStudentTest_FailureCase.
   * @throws Exception
   */
  @Test
  @Order(7)
  public void createStudentTest_FailureCase() throws Exception {
    //Arrange
    JSONObject requestJSON = new JSONObject();
    requestJSON.put("name","ravi");
    requestJSON.put("gender","male");
    requestJSON.put("parent","sam");
    requestJSON.put("address","Kannyakumari");
    requestJSON.put("dateOfBirth","23/10/2005");
    requestJSON.put("email","wgmail.com");
    requestJSON.put("section","c");
    requestJSON.put("standard","8");
    requestJSON.put("phoneNumber","9884218765");
    requestJSON.put("bloodGroup","AB-ve");
    requestJSON.put("logo","MonkeyLogo");
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    HttpEntity<String> request = new HttpEntity<>(requestJSON.toString(), headers);

    //Act
    ResponseEntity<StudentDetailsModel> studentDetailsModel = testRestTemplate.exchange("/save", HttpMethod.POST,request, StudentDetailsModel.class);
    StudentDetailsModel createdStudentDetail = studentDetailsModel.getBody();

    //Assert
    Assertions.assertEquals(studentDetailsModel.getStatusCode(),HttpStatus.BAD_REQUEST);
  }

  /**
   * deleteStudentById_SuccessFailure.
   */
  @Test
  @Order(8)
  void deleteStudentById_SuccessFailure() {
    HttpHeaders headers = new HttpHeaders();
    headers.set("Accept", "application/json");
    HttpEntity requestEntity = new HttpEntity(null, headers);
    String url = "/delete/" + rollNumber;

    //Act
    ResponseEntity<StudentDetailsModel> response= testRestTemplate.exchange(url, HttpMethod.DELETE,
            requestEntity, new ParameterizedTypeReference<StudentDetailsModel>() { });

    //Assert
    Assertions.assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
  }

  /*
  @Test
  @Order(9)
  void getStudentByIdTest_FailureCase() {
    //Arrange
    HttpHeaders headers = new HttpHeaders();
    headers.set("Accept", "application/json");
    HttpEntity requestEntity = new HttpEntity(null, headers);

    //Act
    ResponseEntity<String> response = testRestTemplate.exchange("/get/"+rollNumber, HttpMethod.GET,
            requestEntity,
            new ParameterizedTypeReference<String>() {
            });


    //Assert
    Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode(), "Http Status is Not found is not returned");
  }
*/
}