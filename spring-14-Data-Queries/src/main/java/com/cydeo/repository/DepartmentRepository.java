package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> {

// Display all departments in Furniture Department
    List<Department> findAllByDepartment(String department);

// Display all departments in the Health Division
    List<Department> findAllByDivision(String division);
    // alternatives:
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

// Display all departments where Division name ends with 'ics'
    List<Department> findByDivisionEndsWith(String pattern);
// Display top 3 Departments where Division name includes 'Hea' without duplicates
    List<Department> findDistinctTop3ByDivisionContains(String pattern);

//  JPQL:

    // retrieve Departments in different Divisions
    @Query("SELECT d FROM Department d WHERE d.division IN ?1")
        // IN - multiple WHERE -> multiple Divisions
    List<Department> retrieveDepartmentDivision(List<String> division);

}
