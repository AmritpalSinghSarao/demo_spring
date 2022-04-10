package com.example.test.employee.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Entity
@Table(
        name="office",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"street", "cap"})
)
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "office_sequence")
    @Column(unique = true)
    private Long id;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String cap;

    @OneToMany(mappedBy = "office")
    private List<Employee> employee;
}
