package com.example.test.employee.demo.mapper;

import com.example.test.employee.demo.dto.EmployeeDto;
import com.example.test.employee.demo.model.Employee;
import com.example.test.employee.demo.model.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class EmployeeMapper {

    public static final EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mappings(
            {
                    @Mapping(target = "fullName", source = ".",qualifiedByName = "fullNameByFirstAndLastName"),
                    @Mapping(target = "roleCode",source = "role.id"),
                    @Mapping(target = "officeCode",source = "office.id"),
                    @Mapping(source = "birthday", target = "birthday",dateFormat = "dd.MM.yyyy"),
                    @Mapping(source = "hiringDate", target = "hiringDate",dateFormat = "dd.MM.yyyy"),
                    @Mapping(source = "contractExpirationDate", target = "contractExpirationDate",dateFormat = "dd.MM.yyyy"),

            }
    )
    public abstract EmployeeDto employeeToDto(Employee employee);

    @Mappings(
            {
                    @Mapping(target = "fullName", source = ".",qualifiedByName = "fullNameByFirstAndLastName"),
                    @Mapping(target = "roleCode",source = "role.id"),
                    @Mapping(target = "officeCode",source = "office.id"),
                    @Mapping(source = "birthday", target = "birthday",dateFormat = "dd.MM.yyyy"),
                    @Mapping(source = "hiringDate", target = "hiringDate",dateFormat = "dd.MM.yyyy"),
                    @Mapping(source = "contractExpirationDate", target = "contractExpirationDate",dateFormat = "dd.MM.yyyy"),

            }
    )
    public abstract List<EmployeeDto> employeeToDtoList(List<Employee> employees);

    @InheritInverseConfiguration(name="employeeToDto")
    @Mappings(
            {
                    @Mapping(target = "firstName",source = ".",qualifiedByName = "getFirstNameFromFullName"),
                    @Mapping(target = "lastName",source = ".", qualifiedByName = "getFirstNameFromFullName")
            }
    )
    public abstract Employee dtoToEmployee(EmployeeDto employee);

    @Named("getFirstNameFromFullName")
    String getFirstNameFromFullName(EmployeeDto emp)
    {
        String fullName = emp.getFullName();
        String arr[] = fullName.split(" ", 2);
        return arr[0];
    }

    @Named("getLastNameFromFullName")
    String getLastNameFromFullName(EmployeeDto emp)
    {

        String fullName = emp.getFullName();
        String arr[] = fullName.split(" ", 2);
        return arr[1];
    }

    @Named("fullNameByFirstAndLastName")
    String fullNameByFirstAndLastName(Employee emp)
    {
        return emp.getFirstName()+" "+emp.getLastName();
    }
}
