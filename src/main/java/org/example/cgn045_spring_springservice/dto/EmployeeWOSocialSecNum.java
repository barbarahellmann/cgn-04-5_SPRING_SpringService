package org.example.cgn045_spring_springservice.dto;

import org.springframework.data.annotation.Id;

public record EmployeeWOSocialSecNum(
        String employeeNumber,
        String name,
        int age,
        String department) {
}
