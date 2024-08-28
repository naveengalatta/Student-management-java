package com.web3.studentdetails.repository;

import com.web3.studentdetails.model.StudentDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * This interface is used as DAO.
 */
@Repository
public interface StudentDetailsRepository extends JpaRepository<StudentDetailsModel, Integer> {
  /**
   * Student is found by RollNumber and Name.
   * @param rollNumber
   * @param name
   * @return List<StudentDetailsModel> is returned.
   */
  List<StudentDetailsModel> findByRollNumberAndName(int rollNumber, String name);
}
