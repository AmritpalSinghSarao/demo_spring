package com.example.test.employee.demo.repositary;

import com.example.test.employee.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role,Long> {

        @Override
        List<Role> findAll();

        @Override
        Role getById(Long id);

        @Modifying
        @Transactional
        @Query(value = "UPDATE role r set r.type=:type, r.description=:description WHERE r.id=:id",nativeQuery = true)
        int updateRole(@Param("id") Long roleId, @Param("type") String type, @Param("description") String description);

        @Modifying
        @Transactional
        @Query(value = "Delete from role where role.id=:id",nativeQuery = true)
        int deleteByRoleId(Long id);

}
