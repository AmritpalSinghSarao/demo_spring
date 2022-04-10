package com.example.test.employee.demo.controller;

import com.example.test.employee.demo.dto.OfficeDto;
import com.example.test.employee.demo.dto.RoleDto;
import com.example.test.employee.demo.model.Office;
import com.example.test.employee.demo.model.Role;
import com.example.test.employee.demo.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OfficeController {
    @Autowired
    OfficeService officeService;

    @GetMapping("/office/{id}")
    public OfficeDto getOffice(@PathVariable Long id)
    {
        return officeService.getOffice(id);
    }

    @GetMapping("/offices")
    public List<OfficeDto> getOffice()
    {
        return officeService.getOffices();
    }

    @PostMapping("/office")
    public void createOffice(@RequestBody OfficeDto officeDto)
    {
        officeService.createOffice(officeDto);
    }

    @PutMapping("/office/{id}")
    public ResponseEntity<Long> updateOffice(@PathVariable Long id, @RequestBody OfficeDto officeDto)
    {
        if(officeService.updateOffice(id,officeDto)==0)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<>(id,HttpStatus.OK);
        }
    }

    @GetMapping("/office/employees")
    public List<Object> getNumberOfEmployees()
    {
        return officeService.numberEmployees();
    }

    @DeleteMapping("/office{id}")
    public ResponseEntity<Long> deleteOffice(@PathVariable Long id)
    {
        boolean isDeleted = officeService.deleteOffice(id);

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
