package com.cydeo.controller;

import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.AddressService;
import com.cydeo.service.ParentService;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

    public final TeacherService teacherService;
    public final StudentService studentService;
    public final ParentService parentService;
    public final AddressService addressService;

    public SchoolController(TeacherService teacherService, StudentService studentService, ParentService parentService, AddressService addressService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.parentService = parentService;
        this.addressService = addressService;
    }

    @GetMapping("/teachers")
    public List<TeacherDTO> showAllTeachers() {

        return teacherService.findAll();
    }

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> showAllStudents() {

        return ResponseEntity
                .ok(new ResponseWrapper("Students are successfully retrieved",
                        studentService.findAll()));
    }

    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> showAllParents() {

        ResponseWrapper responseWrapper = new ResponseWrapper(true,
                "Parents are successfully retrieved",
                HttpStatus.ACCEPTED.value(), parentService.findAll());

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Parent", "Returned")
                .body(responseWrapper);
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<ResponseWrapper> getAddressById(
            @PathVariable("id") Long id) throws Exception {

        return ResponseEntity
                .ok(new ResponseWrapper("Address " + id
                        + " is successfully retrieved",
                        addressService.findById(id)));
    }

    @PutMapping("/address/{id}")
    public AddressDTO updateAddressById(
            @PathVariable("id") Long id, @RequestBody AddressDTO address) throws Exception {

        address.setId(id);
        return addressService.update(address);
    }
}
