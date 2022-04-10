package com.example.test.employee.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "employee_sequence")
    @Column(unique = true)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Date birthday;

    @Column(nullable = false)
    private Date hiringDate;

    @Column(nullable = false)
    private Date contractExpirationDate;

    @Column(nullable = false,unique = true)
    private String phoneNumber;

    @Email
    @Column(nullable = false,unique = true)
    private String email;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false)
    @JoinColumn(
            name = "role_id",
            referencedColumnName = "id"
    )
    private Role role;


    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false)
    @JoinColumn(
            name = "office_id",
            referencedColumnName = "id"
    )
    private Office office;
}
