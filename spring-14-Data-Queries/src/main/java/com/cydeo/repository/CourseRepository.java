package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course, Long> {

// Find all courses by category (SELECT * FROM courses WHERE category = ...)
    List<Course> findAllByCategory(String category);

// Find all courses by category and order by name
    List<Course> findAllByCategoryOrderByName(String category);

// Return true if a course with name "" exists
    boolean existsByName(String name);

// Returns count of courses for the given category
    int countAllByCategory(String category);

// Find all courses that start with given course name String
    List<Course> findAllByNameStartsWith(String name);

// Find all courses by category and return a stream
    Stream<Course> streamAllByCategory(String category);

// Named Param
    @Query("SELECT c FROM Course c WHERE c.category = :category " +
            "AND c.rating > :rating")
    List<Course> retrieveAllByCategoryAndRatingGreaterThan(
            @Param("category") String category, @Param("rating") int rating);

}
