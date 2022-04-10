package com.example.test.employee.demo.repositary;

import com.example.test.employee.demo.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>, JpaSpecificationExecutor<Employee> {

    @Query(value = "Select * from employee e where e.id=:id",nativeQuery = true)
    Employee findByEmployeeId(@Param("id") Long id);

    List<Employee> findAll(Specification<Employee> spec,Sort sort);

    @Query(value = "Select * from employee e WHERE e.office_id=:officeId",nativeQuery = true)
    List<Employee> findEmployeesByOfficeId(@Param("officeId") Long officeId);

    @Query(value = "Select * from employee e left join role r on e.role_id=r.id WHERE r.type=:type",nativeQuery = true)
    List<Employee> findEmployeesByRoleType(@Param("type") String type);

    @Modifying
    @Transactional
    @Query(value = "UPDATE employee e set e.first_name=:firstName, e.last_name=:lastName, e.birthday=:birthday, e.hiring_date=:hiringDate," +
            "e.contract_expiration_date=:contractExpirationDate, e.phone_number=:phoneNumber, e.email=:email,e.role_id=:roleId,e.office_id=:officeId WHERE e.id=:id"
            ,nativeQuery = true)
    int updateById(@Param("id") Long Id, @Param("firstName") String firstName, @Param("lastName") String lastName,
                       @Param("birthday") Date birthday, @Param("hiringDate") Date hiringDate,
                       @Param("contractExpirationDate") Date contractExpirationDate, @Param("phoneNumber") String phoneNumber,
                       @Param("email") String email, @Param("roleId") Long roleId, @Param("officeId") Long officeId);

    @Modifying
    @Transactional
    @Query(value = "Delete from employee e where e.id=:id",nativeQuery = true)
    int deleteByEmployeeId(@Param("id") Long id);


}
