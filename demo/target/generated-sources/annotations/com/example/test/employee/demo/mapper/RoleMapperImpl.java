package com.example.test.employee.demo.mapper;

import com.example.test.employee.demo.dto.RoleDto;
import com.example.test.employee.demo.dto.RoleDto.RoleDtoBuilder;
import com.example.test.employee.demo.model.Role;
import com.example.test.employee.demo.model.Role.RoleBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-04T01:15:54-0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleDto roleToDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDtoBuilder roleDto = RoleDto.builder();

        if ( role.getId() != null ) {
            roleDto.id( role.getId().intValue() );
        }
        roleDto.type( role.getType() );
        roleDto.description( role.getDescription() );

        return roleDto.build();
    }

    @Override
    public Role DtoToRole(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        RoleBuilder role = Role.builder();

        role.id( (long) roleDto.getId() );
        role.type( roleDto.getType() );
        role.description( roleDto.getDescription() );

        return role.build();
    }

    @Override
    public List<RoleDto> roleToDtoList(List<Role> role) {
        if ( role == null ) {
            return null;
        }

        List<RoleDto> list = new ArrayList<RoleDto>( role.size() );
        for ( Role role1 : role ) {
            list.add( roleToDto( role1 ) );
        }

        return list;
    }
}
