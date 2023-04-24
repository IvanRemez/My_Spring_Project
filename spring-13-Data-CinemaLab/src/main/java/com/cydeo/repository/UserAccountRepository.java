package com.cydeo.repository;

import com.cydeo.entity.AccountDetails;
import com.cydeo.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?
    Optional<UserAccount> findByEmail(String email);

    //Write a derived query to read a user with a username?
    Optional<UserAccount> findByUsername(String username);

    //Write a derived query to list all users that contain a specific name?
    List<UserAccount> findAllByAccountDetailsNameContaining(String name);

    //Write a derived query to list all users that contain a specific name in the ignore case mode?
    List<UserAccount> findAllByAccountDetailsNameContainingIgnoreCase(String name);

    //Write a derived query to list all users with an age greater than a specified age?
    List<UserAccount> findAllByAccountDetailsAgeGreaterThan(Integer age);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?
    @Query("SELECT ua FROM UserAccount ua WHERE ua.email = ?1")
    Optional<UserAccount> getUserAccountByEmail(String email);

    //Write a JPQL query that returns a user read by username?
    @Query("SELECT ua FROM UserAccount ua WHERE ua.username = ?1")
    Optional<UserAccount> getUserAccountByUsername(String username);

    //Write a JPQL query that returns all users?
    @Query("SELECT ua FROM UserAccount ua")
    List<UserAccount> getAllUsers();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?
    @Query(value = "SELECT * FROM user_account ua JOIN account_details ad " +
            "ON ua.account_details_id = ad.id WHERE ad.name ILIKE concat('%', ?1, '%')", nativeQuery = true)
    List<UserAccount> fetchAllUsersByName(String name);

    //Write a native query that returns all users?
    @Query(value = "SELECT * FROM user_account", nativeQuery = true)
    List<UserAccount> fetchAllUsers();

    //Write a native query that returns all users in the range of ages?
    @Query(value = "SELECT * FROM user_account ua JOIN account_details ad " +
            "ON ua.account_details_id = ad.id WHERE ad.age BETWEEN ?1 AND ?2", nativeQuery = true)
    List<UserAccount> fetchAllUsersBetweenAgeRange(Integer age1, Integer age2);

    //Write a native query to read a user by email?
    @Query(value = "SELECT * FROM user_account ua WHERE ua.email = ?1", nativeQuery = true)
    UserAccount fetchUserByEmail(String email);

}