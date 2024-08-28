package com.web3.studentdetails.model;


import com.web3.studentdetails.utill.Constant;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Entity;
import java.util.Objects;

/**
 * Spring Application
 * POJO Student class.
 *
 * @author  Naveen
 * @version 1.0
 * @since   2022-09-21
 */
@Entity
public class StudentDetailsModel {
  /**
   * Roll Number is auto generated.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rollNumber_sequence")
  @SequenceGenerator(sequenceName = "rollNumber_sequence", allocationSize = 1, name = "CUSTOM_SEQ")
  private int rollNumber;
  /**
   * name of the student.
   */
  private String name;
  /**
   * Gender of the student.
   */
  private String gender;
  /**
   * Parent name of the student.
   */
  private String parent;
  /**
   * Address of the student.
   */
  private String address;
  /**
   * Date of birth of the student.
   */
  private String dateOfBirth;
  /**
   * Email of the student.
   */
  private String email;
  /**
   * Section of the student.
   */
  private char section;
  /**
   * Standard of the student.
   */
  private int standard;
  /**
   * phoneNumber of the student.
   */
  private long phoneNumber;
  /**
   * Blood Group of the student.
   */
  private String bloodGroup;
  /**
   * Logo of the student.
   */
  private String logo;

  public String getBloodGroup() {
    return bloodGroup;
  }

  public void setBloodGroup(final String bloodGroup) {
    this.bloodGroup = bloodGroup;
  }

  public String getLogo() {
    return logo;
  }

  public void setLogo(final String logo) {
    this.logo = logo;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(final String gender) {
    this.gender = gender;
  }

  public String getParent() {
    return parent;
  }

  public void setParent(final String parent) {
    this.parent = parent;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(final String address) {
    this.address = address;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(final String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public char getSection() {
    return section;
  }

  public void setSection(final char section) {
    this.section = section;
  }

  public int getStandard() {
    return standard;
  }

  public void setStandard(final int standard) {
    this.standard = standard;
  }

  public long getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(final long phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public int getRollNumber() {
    return rollNumber;
  }

  public void setRollNumber(final int rollNumber) {
    this.rollNumber = rollNumber;
  }

  /**
   * toString function overridden.
   * @return String is returned.
   */
  public String toString() {
    return rollNumber + Constant.SPACE + name + Constant.SPACE + gender + Constant.SPACE
            + standard + Constant.SPACE + section + Constant.SPACE
            + parent + Constant.SPACE + address + Constant.SPACE
            + dateOfBirth + Constant.SPACE + phoneNumber + Constant.SPACE + email + "\n";
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StudentDetailsModel that = (StudentDetailsModel) o;
    return rollNumber == that.rollNumber && section == that.section
            && standard == that.standard && phoneNumber == that.phoneNumber
            && Objects.equals(name, that.name) && Objects.equals(gender, that.gender)
            && Objects.equals(parent, that.parent) && Objects.equals(address, that.address)
            && Objects.equals(dateOfBirth, that.dateOfBirth) && Objects.equals(email, that.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rollNumber, name, gender, parent, address, dateOfBirth,
            email, section, standard, phoneNumber);
  }
}
