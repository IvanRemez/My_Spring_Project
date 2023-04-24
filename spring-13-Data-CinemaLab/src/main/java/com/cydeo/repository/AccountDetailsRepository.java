package com.cydeo.repository;

import com.cydeo.entity.AccountDetails;
import com.cydeo.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
    List<AccountDetails> findAllByCountryOrState(String country, String state);

    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<AccountDetails> findAllByAgeLessThanEqual(int age);

    //Write a derived query to list all accounts with a specific role
    List<AccountDetails> findAllByRole(UserRole role);

    //Write a derived query to list all accounts between a range of ages
    List<AccountDetails> findAllByAgeBetween(int age1, int age2);

    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<AccountDetails> findAllByAddressStartsWith(String pattern);

    //Write a derived query to sort the list of accounts with age
    List<AccountDetails> findAllByOrderByAge();

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("SELECT ad FROM AccountDetails ad")
    List<AccountDetails> retrieveAllAccounts();

    //Write a JPQL query to list all admin accounts
    @Query("SELECT ad FROM AccountDetails ad WHERE ad.role = 'ADMIN'")
    List<AccountDetails> fetchAdminAccounts();

    //Write a JPQL query to sort all accounts with age
    @Query("SELECT ad FROM AccountDetails ad ORDER BY ad.age")
    List<AccountDetails> retrieveAllOrderByAge();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "SELECT * FROM account_details WHERE age < ?1", nativeQuery = true)
    List<AccountDetails> fetchAllAccountsAgeLowerThan(int age);

    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city
    @Query(value = "SELECT * FROM account_details WHERE name ILIKE concat('%',?1,'%')" +
            "OR address ILIKE concat('%',?1,'%')" +
            "OR country ILIKE concat('%',?1,'%')" +
            "OR state ILIKE concat('%',?1,'%')" +
            "OR city ILIKE concat('%',?1,'%')", nativeQuery = true)
    List<AccountDetails> fetchAllAccountsContaining(String pattern);

    //Write a native query to read all accounts with an age higher than a specific value
    @Query(value = "SELECT * FROM account_details WHERE age > ?1", nativeQuery = true)
    List<AccountDetails> fetchAllAccountsAgeHigherThan(int age);
// OR
    @Query(value = "SELECT * FROM account_details WHERE age > :age", nativeQuery = true)
    List<AccountDetails> fetchAllAccountsAgeHigherThan2(@Param("age") int age);

}