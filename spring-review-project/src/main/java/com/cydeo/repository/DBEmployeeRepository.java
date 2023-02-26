package com.cydeo.repository;

import com.cydeo.model.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class DBEmployeeRepository implements EmployeeRepository{

    // assume we are getting this data from DB
    @Override
    public int getHourlyRate() {

        Employee employee = new Employee("Ivan", "DevTeam", 80);
        return employee.getHourlyRate();
    }
}
