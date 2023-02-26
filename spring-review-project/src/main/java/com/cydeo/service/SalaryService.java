package com.cydeo.service;

import com.cydeo.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import com.cydeo.repository.HoursRepository;

@AllArgsConstructor
@Component
public class SalaryService {

    private final HoursRepository hoursRepository;
    private final EmployeeRepository employeeRepository;

    public void calculateRegularSalary() {
        System.out.println(employeeRepository.getHourlyRate() * hoursRepository.getHours());
    }

}
