package com.example.test.employee.demo.service.imp;

import com.example.test.employee.demo.dto.OfficeDto;
import com.example.test.employee.demo.mapper.OfficeMapper;
import com.example.test.employee.demo.model.Office;
import com.example.test.employee.demo.repositary.EmployeeRepository;
import com.example.test.employee.demo.repositary.OfficeRepository;
import com.example.test.employee.demo.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeServiceImp implements OfficeService {

    @Autowired
    OfficeRepository officeRepository;

    @Override
    public OfficeDto getOffice(Long id) {

        OfficeDto officeDto = OfficeMapper.INSTANCE.officeToDto(officeRepository.getById(id));
        return officeDto;
    }

    @Override
    public List<OfficeDto> getOffices() {
        List<OfficeDto> officeDtoList=OfficeMapper.INSTANCE.officeToDtoList(officeRepository.findAll());
        return officeDtoList;
    }

    @Override
    public void createOffice(OfficeDto officeDto)
    {
        Office office = OfficeMapper.INSTANCE.dtoToOffice(officeDto);
        officeRepository.save(office);
    }

    @Override
    public int updateOffice(Long id, OfficeDto officeDto) {
        Office office = OfficeMapper.INSTANCE.dtoToOffice(officeDto);
        return officeRepository.updateOffice(id,office.getStreet(),office.getCap());
    }

    @Override
    public boolean deleteOffice(Long id)
    {
        if(officeRepository.deleteByOfficeId(id)!=0)
            return true;
        else return false;
    }

    @Override
    public List<Object> numberEmployees() {
        return officeRepository.getNumberOfEmployees();
    }
}
