package com.example.test.employee.demo.mapper;

import com.example.test.employee.demo.dto.OfficeDto;
import com.example.test.employee.demo.dto.RoleDto;
import com.example.test.employee.demo.model.Office;
import com.example.test.employee.demo.model.Role;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import javax.validation.constraints.NotNull;
import java.util.List;

@Mapper(componentModel = "spring")
public interface OfficeMapper {

    OfficeMapper INSTANCE = Mappers.getMapper(OfficeMapper.class);
    OfficeDto officeToDto(Office office);
    Office dtoToOffice(OfficeDto officeDto);
    List<OfficeDto> officeToDtoList(List<Office> offices);
}
