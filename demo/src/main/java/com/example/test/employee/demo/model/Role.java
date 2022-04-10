package com.example.test.employee.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Entity
@Table(
        name="role",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"type", "description"})
)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "role_sequence")
    @Column(unique = true)
    private Long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "role")
    private List<Employee> employee;


}
