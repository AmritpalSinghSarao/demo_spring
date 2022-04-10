package com.example.test.employee.demo.service;

import com.example.test.employee.demo.dto.RoleDto;
import com.example.test.employee.demo.model.Role;

import java.util.List;

public interface RoleService {

    RoleDto getRole(Long id);
    List<RoleDto> getRoles();
    void createRole(RoleDto roleDto);
    int updateRole(Long id,RoleDto roleDto);
    int deleteRole(Long id);
}
