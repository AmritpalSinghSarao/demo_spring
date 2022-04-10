package com.example.test.employee.demo.mapper;

import com.example.test.employee.demo.dto.EmployeeDto;
import com.example.test.employee.demo.dto.EmployeeDto.EmployeeDtoBuilder;
import com.example.test.employee.demo.model.Employee;
import com.example.test.employee.demo.model.Employee.EmployeeBuilder;
import com.example.test.employee.demo.model.Office;
import com.example.test.employee.demo.model.Office.OfficeBuilder;
import com.example.test.employee.demo.model.Role;
import com.example.test.employee.demo.model.Role.RoleBuilder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class EmployeeMapperImpl extends EmployeeMapper {

    @Override
    public EmployeeDto employeeToDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDtoBuilder employeeDto = EmployeeDto.builder();

        employeeDto.fullName( fullNameByFirstAndLastName( employee ) );
        Long id = employeeRoleId( employee );
        if ( id != null ) {
            employeeDto.roleCode( String.valueOf( id ) );
        }
        Long id1 = employeeOfficeId( employee );
        if ( id1 != null ) {
            employeeDto.officeCode( String.valueOf( id1 ) );
        }
        if ( employee.getBirthday() != null ) {
            employeeDto.birthday( new SimpleDateFormat( "dd.MM.yyyy" ).format( employee.getBirthday() ) );
        }
        if ( employee.getHiringDate() != null ) {
            employeeDto.hiringDate( new SimpleDateFormat( "dd.MM.yyyy" ).format( employee.getHiringDate() ) );
        }
        if ( employee.getContractExpirationDate() != null ) {
            employeeDto.contractExpirationDate( new SimpleDateFormat( "dd.MM.yyyy" ).format( employee.getContractExpirationDate() ) );
        }
        if ( employee.getId() != null ) {
            employeeDto.id( employee.getId().intValue() );
        }
        employeeDto.phoneNumber( employee.getPhoneNumber() );
        employeeDto.email( employee.getEmail() );

        return employeeDto.build();
    }

    @Override
    public List<EmployeeDto> employeeToDtoList(List<Employee> employees) {
        if ( employees == null ) {
            return null;
        }

        List<EmployeeDto> list = new ArrayList<EmployeeDto>( employees.size() );
        for ( Employee employee : employees ) {
            list.add( employeeToDto( employee ) );
        }

        return list;
    }

    @Override
    public Employee dtoToEmployee(EmployeeDto employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeBuilder employee1 = Employee.builder();

        employee1.role( employeeDtoToRole( employee ) );
        employee1.office( employeeDtoToOffice( employee ) );
        employee1.firstName( getFirstNameFromFullName( employee ) );
        employee1.lastName( getFirstNameFromFullName( employee ) );
        try {
            if ( employee.getBirthday() != null ) {
                employee1.birthday( new SimpleDateFormat( "dd.MM.yyyy" ).parse( employee.getBirthday() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        try {
            if ( employee.getHiringDate() != null ) {
                employee1.hiringDate( new SimpleDateFormat( "dd.MM.yyyy" ).parse( employee.getHiringDate() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        try {
            if ( employee.getContractExpirationDate() != null ) {
                employee1.contractExpirationDate( new SimpleDateFormat( "dd.MM.yyyy" ).parse( employee.getContractExpirationDate() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        employee1.id( (long) employee.getId() );
        employee1.phoneNumber( employee.getPhoneNumber() );
        employee1.email( employee.getEmail() );

        return employee1.build();
    }

    private Long employeeRoleId(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        Role role = employee.getRole();
        if ( role == null ) {
            return null;
        }
        Long id = role.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long employeeOfficeId(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        Office office = employee.getOffice();
        if ( office == null ) {
            return null;
        }
        Long id = office.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Role employeeDtoToRole(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        RoleBuilder role = Role.builder();

        if ( employeeDto.getRoleCode() != null ) {
            role.id( Long.parseLong( employeeDto.getRoleCode() ) );
        }

        return role.build();
    }

    protected Office employeeDtoToOffice(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        OfficeBuilder office = Office.builder();

        if ( employeeDto.getOfficeCode() != null ) {
            office.id( Long.parseLong( employeeDto.getOfficeCode() ) );
        }

        return office.build();
    }
}
