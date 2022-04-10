package com.example.test.employee.demo.service;

import com.example.test.employee.demo.dto.EmployeeDto;
import com.example.test.employee.demo.model.Employee;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface EmployeeService {

    EmployeeDto getEmployee(Long id);
    List<EmployeeDto> getEmployees(String filter,String value, String sort);
    void createEmployee(EmployeeDto employeeDto);
    int updateEmployee(Long id,EmployeeDto employeeDto);
    boolean deleteEmployee(Long id);
}
