package com.example.test.employee.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class EmployeeDto {

    private int id;

    @NotNull
    private String fullName;

    @NotNull
    private String birthday;

    @NotNull
    private String hiringDate;

    @Column(nullable = false)
    private String contractExpirationDate;

    @NotNull
    private String phoneNumber;

    @NotNull
    @Email
    private String email;

    @NotNull
    @JsonProperty("roleCode")
    private String roleCode;

    @NotNull
    @JsonProperty("officeCode")
    private String officeCode;





}
