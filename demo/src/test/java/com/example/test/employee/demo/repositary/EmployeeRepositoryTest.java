package com.example.test.employee.demo.repositary;

import com.example.test.employee.demo.dto.EmployeeDto;
import com.example.test.employee.demo.dto.OfficeDto;
import com.example.test.employee.demo.dto.RoleDto;
import com.example.test.employee.demo.mapper.EmployeeMapper;
import com.example.test.employee.demo.mapper.OfficeMapper;
import com.example.test.employee.demo.mapper.RoleMapper;
import com.example.test.employee.demo.model.Employee;
import com.example.test.employee.demo.model.Office;
import com.example.test.employee.demo.model.Role;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    OfficeRepository officeRepository;


    @Test
    void saveEmployee() {
        RoleDto roleDto = RoleDto.builder().type("Teacher").description("Math").build();
        OfficeDto officeDto = OfficeDto.builder().street("Via soliera").cap("62252").build();

        Office dtoToOffice = OfficeMapper.INSTANCE.dtoToOffice(officeDto);
        Role dtoToRole = RoleMapper.INSTANCE.DtoToRole(roleDto);
        Role role=roleRepository.getById(Long.valueOf(1));
        Office office=officeRepository.getById(Long.valueOf(1));

        EmployeeDto employeeDto = EmployeeDto.builder().fullName("Hype Bolo").birthday("25.09.1996").
                hiringDate("30.02.2022").contractExpirationDate("30.4.2022").email("test@yahoo.it")
                .phoneNumber("5555557").build();

        Employee employee = EmployeeMapper.INSTANCE.dtoToEmployee(employeeDto);
        employee.setRole(role);
        employee.setOffice(office);
        employeeRepository.save(employee);
    }


    @Test
    void findById() {
        Employee employee=employeeRepository.findByEmployeeId(Long.valueOf(3));
    }

    @Test
    void updateById() {
        EmployeeDto employeeDto = EmployeeDto.builder().fullName("Amrit").birthday("25.07.1995").
                hiringDate("30.02.2022").contractExpirationDate("30.4.2022").email("singh@yahoo.it")
                .phoneNumber("123456734").build();

        Employee employee1 = EmployeeMapper.INSTANCE.dtoToEmployee(employeeDto);
        int updateResult=employeeRepository.updateById(Long.valueOf(3),employee1.getFirstName(),employee1.getLastName(),
                employee1.getBirthday(),employee1.getHiringDate(),employee1.getContractExpirationDate(),employee1.getPhoneNumber(),
                employee1.getEmail(),Long.valueOf(3),Long.valueOf(3));
    }

    @Test
    void deleteByEmployeeId() {
        System.out.println(employeeRepository.deleteByEmployeeId(new Long(1)));
    }
}
