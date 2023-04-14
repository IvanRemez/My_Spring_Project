package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

// Display all employees with email address ""
    List<Employee> findByEmail(String email);

// Display all employees with first name "" and last name ""
    // OR show all employees with email address ""
    List<Employee> findByFirstNameAndLastNameOrEmail(
            String firstName, String lastName, String email);

// Display all employees where first name is NOT ""
    List<Employee> findByFirstNameIsNot(String firstName);

// Display all employees where last name starts with ""
    List<Employee> findByLastNameStartsWith(String pattern);

// Display all employees with salaries higher than ""
    List<Employee> findBySalaryGreaterThan(Integer salary);
    // salaries lower than ""
    List<Employee> findBySalaryLessThan(Integer salary);

// Display all employees that have been hired between "" and ""
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

// Display all employees where salaries greater than AND equal to ""
    // In Salary order
    List<Employee> findBySalaryGreaterThanEqualOrderBySalary(Integer salary);

// Display top 3 employees making less than ""
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

// Display all employees that do NOT have email address
    List<Employee> findByEmailIsNull();

// -----------JPQL--------------

    @Query("SELECT e FROM Employee e WHERE e.email='bmanueau0@dion.ne.jp'")
    // e = Employee Object
    Employee retrieveEmployeeDetail();

    @Query("SELECT e.salary FROM Employee e WHERE e.email='bmanueau0@dion.ne.jp'")
    Employee retrieveEmployeeSalary();

}
