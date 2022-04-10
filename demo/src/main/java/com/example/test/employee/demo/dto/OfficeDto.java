package com.example.test.employee.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class OfficeDto {
    private int id;
    @NotNull
    private String street;
    @NotNull
    private String cap;

}
