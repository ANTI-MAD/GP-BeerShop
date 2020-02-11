package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Customer {
    private Long id;
    private String email;
    private String fio;
    @JsonFormat(pattern="dd.MM.yyyy")
    private LocalDate birthDate;
}