package com.example.test.employee.demo.service.imp;

import com.example.test.employee.demo.dto.RoleDto;
import com.example.test.employee.demo.mapper.RoleMapper;
import com.example.test.employee.demo.model.Role;
import com.example.test.employee.demo.repositary.RoleRepository;
import com.example.test.employee.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public RoleDto getRole(Long id)
    {
        RoleDto roleDto = RoleMapper.INSTANCE.roleToDto(roleRepository.getById(id));
        return roleDto;
    }

    @Override
    public List<RoleDto> getRoles()
    {
        List<RoleDto> roleDtoList = RoleMapper.INSTANCE.roleToDtoList(roleRepository.findAll());
        return roleDtoList;
    }

    @Override
    public void createRole(RoleDto roleDto)
    {
        Role role = RoleMapper.INSTANCE.DtoToRole(roleDto);
        roleRepository.save(role);
    }

    @Override
    public int updateRole(Long id, RoleDto roleDto)
    {
        Role role = RoleMapper.INSTANCE.DtoToRole(roleDto);
        return roleRepository.updateRole(id,role.getType(),role.getDescription());
    }

    @Override
    public int deleteRole(Long id) {
        return roleRepository.deleteByRoleId(id);
    }
}
