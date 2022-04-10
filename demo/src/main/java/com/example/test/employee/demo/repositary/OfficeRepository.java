package com.example.test.employee.demo.repositary;

import com.example.test.employee.demo.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public interface OfficeRepository extends JpaRepository<Office,Long> {

    @Override
    Office getById(Long id);

    @Override
    List<Office> findAll();

    @Modifying
    @Transactional
    @Query(value = "UPDATE office o set o.street=:street, o.cap=:cap WHERE o.id=:id",nativeQuery = true)
    int updateOffice(@Param("id") Long id, @Param("street") String street, @Param("cap") String cap);

    @Query(value = "select o.id , o.street, o.cap, count(o.id) From office o left join employee e on o.id=e.office_id group by o.id;;",nativeQuery = true)
    List<Object> getNumberOfEmployees();

    @Modifying
    @Transactional
    @Query(value = "Delete from office where office.id==:id",nativeQuery = true)
    int deleteByOfficeId(Long id);
}
