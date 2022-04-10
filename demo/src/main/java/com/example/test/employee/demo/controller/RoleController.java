package com.example.test.employee.demo.controller;

import com.example.test.employee.demo.dto.EmployeeDto;
import com.example.test.employee.demo.dto.RoleDto;
import com.example.test.employee.demo.model.Employee;
import com.example.test.employee.demo.model.Role;
import com.example.test.employee.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.util.EnumUtils;

import java.util.List;

@RestController
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/role/{id}")
    public RoleDto getRole(@PathVariable Long id)
    {
        return roleService.getRole(id);
    }

    @GetMapping("/roles")
    public List<RoleDto> getRoles()
    {
        return roleService.getRoles();
    }

    @PostMapping("/role")
    public void createRole(@RequestBody RoleDto roleDto)
    {
        roleService.createRole(roleDto);
    }

    @PutMapping("/role/{id}")
    public ResponseEntity<Long> updateRole(@PathVariable Long id, @RequestBody RoleDto roleDto)
    {
        if(roleService.updateRole(id,roleDto)==0)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(id,HttpStatus.OK);
    }

    @DeleteMapping("/role{id}")
    public ResponseEntity<Long> deleteRole(@PathVariable Long id)
    {
        int isDeleted = roleService.deleteRole(id);

        if(isDeleted==0)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<>(id,HttpStatus.OK);
        }
    }
}
