package com.example.test.employee.demo.service;

import com.example.test.employee.demo.dto.OfficeDto;
import com.example.test.employee.demo.model.Office;

import java.util.List;

public interface OfficeService {

    OfficeDto getOffice(Long id);
    List<OfficeDto> getOffices();
    void createOffice(OfficeDto officeDto);
    int updateOffice(Long id, OfficeDto officeDto);
    boolean deleteOffice(Long id);
    List<Object> numberEmployees();
}
