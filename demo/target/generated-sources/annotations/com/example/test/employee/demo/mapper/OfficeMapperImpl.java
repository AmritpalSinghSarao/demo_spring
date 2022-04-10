package com.example.test.employee.demo.mapper;

import com.example.test.employee.demo.dto.OfficeDto;
import com.example.test.employee.demo.dto.OfficeDto.OfficeDtoBuilder;
import com.example.test.employee.demo.model.Office;
import com.example.test.employee.demo.model.Office.OfficeBuilder;
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
public class OfficeMapperImpl implements OfficeMapper {

    @Override
    public OfficeDto officeToDto(Office office) {
        if ( office == null ) {
            return null;
        }

        OfficeDtoBuilder officeDto = OfficeDto.builder();

        if ( office.getId() != null ) {
            officeDto.id( office.getId().intValue() );
        }
        officeDto.street( office.getStreet() );
        officeDto.cap( office.getCap() );

        return officeDto.build();
    }

    @Override
    public Office dtoToOffice(OfficeDto officeDto) {
        if ( officeDto == null ) {
            return null;
        }

        OfficeBuilder office = Office.builder();

        office.id( (long) officeDto.getId() );
        office.street( officeDto.getStreet() );
        office.cap( officeDto.getCap() );

        return office.build();
    }

    @Override
    public List<OfficeDto> officeToDtoList(List<Office> offices) {
        if ( offices == null ) {
            return null;
        }

        List<OfficeDto> list = new ArrayList<OfficeDto>( offices.size() );
        for ( Office office : offices ) {
            list.add( officeToDto( office ) );
        }

        return list;
    }
}
