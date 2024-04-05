package org.example.cgn045_spring_springservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Employees")
public record Employee (
            @Id String employeeNumber,
            String name,
            int age,
            String department,
            String socialSecNum) {
}
