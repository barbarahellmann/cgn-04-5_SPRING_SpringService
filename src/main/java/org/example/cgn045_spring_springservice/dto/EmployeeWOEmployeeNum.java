package org.example.cgn045_spring_springservice.dto;

import org.springframework.data.annotation.Id;

public record EmployeeWOEmployeeNum(
            String name,
            int age,
            String department,
            String socialSecNum) {
}
