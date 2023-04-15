package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

// Not equal
    @Query("SELECT e FROM Employee e WHERE e.salary <> ?1")
    // NOT Equal in SQL: <>
    List<Employee> retrieveEmployeeSalaryNotEqual(int salary);

// Like / Contains / StartsWith / EndsWith:
    // Like
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE ?1")
    List<Employee> retrieveEmployeeFirstNameLike(String pattern);

    //Less Than
    @Query("SELECT e FROM Employee e WHERE e.salary < ?1")
    List<Employee> retrieveEmployeeSalaryLessThan(int salary);
    //Greater Than (only show First names
    @Query("SELECT e.firstName FROM Employee e WHERE e.salary > ?1")
    List<String> retrieveEmployeeSalaryGreaterThan(int salary);
    // ^^ String b/c you're only getting First names (not Employee objects)

    // Between
    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
    List<Employee> retrieveEmployeeSalaryBetween(int salary1, int salary2);

    // Before
    @Query("SELECT e FROM Employee e WHERE e.hireDate > ?1")
    List<Employee> retrieveEmployeeHireDateBefore(LocalDate date);

    // Null
    @Query("SELECT e FROM Employee e WHERE e.email IS NULL")
    List<Employee> retrieveEmployeeEmailIsNull();
    // NOT Null
    @Query("SELECT e FROM Employee e WHERE e.email IS NOT NULL")
    List<Employee> retrieveEmployeeEmailIsNotNull();

    // Sorting in Asc order (ASC default)
    @Query("SELECT e FROM Employee e ORDER BY e.salary")
    List<Employee> retrieveEmployeeOrderSalaryAsc();
    // Sorting in Asc order
    @Query("SELECT e FROM Employee e ORDER BY e.salary DESC")
    List<Employee> retrieveEmployeeOrderSalaryDesc();

// Native Query (Pure SQL - table and column names must match with Table)
    @Query(value = "SELECT * FROM employees WHERE salary = ?1",
            nativeQuery = true) // << MUST add for Native Queries
    List<Employee> retrieveEmployeeDetailBySalary(int salary);

// Named Parameter
    @Query("SELECT e FROM Employee e WHERE e.salary = :salary")
    List<Employee> retrieveEmployeeSalary(@Param("salary") int salary);

}
