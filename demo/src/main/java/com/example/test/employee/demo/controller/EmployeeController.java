package com.example.test.employee.demo.controller;

import com.example.test.employee.demo.dto.EmployeeDto;
import com.example.test.employee.demo.model.Employee;
import com.example.test.employee.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    public EmployeeDto getEmployee(@PathVariable Long id)
    {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/employees")
    public List<EmployeeDto> getEmployees(@RequestParam String filter,@RequestParam String filterValue, @RequestParam String sort)
    {
        return employeeService.getEmployees(filter,filterValue,sort);
    }

    @PostMapping("/employee")
    public void getEmployee(@RequestBody EmployeeDto employeeDto)
    {
        employeeService.createEmployee(employeeDto);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Long> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto)
    {
        if(employeeService.updateEmployee(id,employeeDto)==0)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(id,HttpStatus.OK);
    }

    @DeleteMapping("/employee{id}")
    public ResponseEntity<Long> deleteEmployee(@PathVariable Long id)
    {
        boolean isDeleted = employeeService.deleteEmployee(id);

        if(!isDeleted)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<>(id,HttpStatus.OK);
        }
    }


}
