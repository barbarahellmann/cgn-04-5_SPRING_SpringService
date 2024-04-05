package org.example.cgn045_spring_springservice.service;


import lombok.RequiredArgsConstructor;
import org.example.cgn045_spring_springservice.Repository.EmployeeRepository;
import org.example.cgn045_spring_springservice.dto.EmployeeWOEmployeeNum;
import org.example.cgn045_spring_springservice.dto.EmployeeWOSocialSecNum;
import org.example.cgn045_spring_springservice.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repo;

    public List<EmployeeWOSocialSecNum> getAllEmployees() {
        return repo.findAll().stream()
                .map(employee -> new EmployeeWOSocialSecNum(
                        employee.employeeNumber(),
                        employee.name(),
                        employee.age(),
                        employee.department()))
                .toList();
    }

    public EmployeeWOSocialSecNum getEmployeeById(String id) {
        Employee temp = repo.findById(id).orElseThrow();
        return new EmployeeWOSocialSecNum(
                temp.employeeNumber(),
                temp.name(),
                temp.age(),
                temp.department());
    }

    public void createNewEmployee(EmployeeWOEmployeeNum newEmployee) {
        Employee employee = new Employee(
                UUID.randomUUID().toString(),
                newEmployee.name(),
                newEmployee.age(),
                newEmployee.department(),
                newEmployee.socialSecNum()
        );
        repo.save(employee);
    }
}
