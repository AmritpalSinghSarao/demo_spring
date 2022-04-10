package com.example.test.employee.demo.service.imp;

import com.example.test.employee.demo.dto.EmployeeDto;
import com.example.test.employee.demo.mapper.EmployeeMapper;
import com.example.test.employee.demo.model.Employee;
import com.example.test.employee.demo.repositary.EmployeeRepository;
import com.example.test.employee.demo.repositary.spec.EmployeeSpec;
import com.example.test.employee.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto getEmployee(Long id)
    {
        EmployeeDto employeeDto = EmployeeMapper.INSTANCE.employeeToDto(employeeRepository.findByEmployeeId(id));
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> getEmployees(String filter,String filterValue,String sort)
    {
        List<EmployeeDto> employeeDtoList;

        if (filter.equalsIgnoreCase("office_id")) {
            employeeDtoList = EmployeeMapper.INSTANCE
                    .employeeToDtoList(employeeRepository.findEmployeesByOfficeId(Long.valueOf(filterValue)));
        }
        else if (filter.equalsIgnoreCase("type")) {
            employeeDtoList = EmployeeMapper.INSTANCE
                    .employeeToDtoList(employeeRepository.findEmployeesByRoleType(filterValue));
        }
        else
        {
            employeeDtoList = EmployeeMapper.INSTANCE
                    .employeeToDtoList(employeeRepository.findAll(EmployeeSpec.isEqualTo(filter, filterValue), Sort.by(sort)));
        }
            return employeeDtoList;
    }

    @Override
    public void createEmployee(EmployeeDto employeeDto)
    {
        Employee employee = EmployeeMapper.INSTANCE.dtoToEmployee(employeeDto);
        employeeRepository.save(employee);
    }

    @Override
    public int updateEmployee(Long id, EmployeeDto employeeDto)
    {
        Employee employee = EmployeeMapper.INSTANCE.dtoToEmployee(employeeDto);
        return employeeRepository.updateById(id,employee.getFirstName(),employee.getLastName(),employee.getBirthday(),
        employee.getHiringDate(),employee.getContractExpirationDate(),employee.getPhoneNumber(),employee.getEmail()
        ,employee.getRole().getId(),employee.getOffice().getId());
    }

    @Override
    public boolean deleteEmployee(Long id)
    {
        if(employeeRepository.deleteByEmployeeId(id)!=0)
            return true;
        else return false;
    }
}
