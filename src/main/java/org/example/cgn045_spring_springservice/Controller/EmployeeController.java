package org.example.cgn045_spring_springservice.Controller;

import lombok.RequiredArgsConstructor;
import org.example.cgn045_spring_springservice.Repository.EmployeeRepository;
import org.example.cgn045_spring_springservice.dto.EmployeeWOEmployeeNum;
import org.example.cgn045_spring_springservice.dto.EmployeeWOSocialSecNum;
import org.example.cgn045_spring_springservice.model.Employee;
import org.example.cgn045_spring_springservice.service.EmployeeService;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping
    public List <EmployeeWOSocialSecNum> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/id")
    public EmployeeWOSocialSecNum getEmployeeById(@PathVariable String id) {
        return service.getEmployeeById(id);
    }

    @PostMapping
    public void createNewEmployee(@RequestBody EmployeeWOEmployeeNum newEmployee) {
        service.createNewEmployee(newEmployee);
    }
}
