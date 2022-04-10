package com.example.test.employee.demo.mapper;

import com.example.test.employee.demo.dto.RoleDto;
import com.example.test.employee.demo.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
    RoleDto roleToDto(Role role);
    Role DtoToRole(RoleDto roleDto);
    List<RoleDto> roleToDtoList(List<Role> role);
}
