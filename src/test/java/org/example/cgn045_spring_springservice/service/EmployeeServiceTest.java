package org.example.cgn045_spring_springservice.service;

import org.example.cgn045_spring_springservice.Repository.EmployeeRepository;
import org.example.cgn045_spring_springservice.dto.EmployeeWOEmployeeNum;
import org.example.cgn045_spring_springservice.dto.EmployeeWOSocialSecNum;
import org.example.cgn045_spring_springservice.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceTest  {


    private final EmployeeRepository mockRepo = mock(EmployeeRepository.class);
    private final IdService mockIdService = mock(IdService.class);



    @Test
    void getEmployeeById() {
        // GIVEN
        EmployeeService service = new EmployeeService(mockRepo, mockIdService);
        Employee testEmployee = new Employee(
                "1",
                "Test",
                0,
                "Testing",
            "2");

        when(mockRepo.findById("1")).thenReturn(Optional.of(testEmployee));

        EmployeeWOSocialSecNum expected = new EmployeeWOSocialSecNum(
                "1",
                "Test",
                0,
                "Testing");

        // WHEN
        EmployeeWOSocialSecNum actual = service.getEmployeeById("1");

        // THEN
        Assertions.assertEquals(expected, actual);
        verify(mockRepo).findById("1");
    }


    @Test
    void createNewEmployee(){
        //GIVEN
        EmployeeService service = new EmployeeService(mockRepo, mockIdService);
        when(mockIdService.generateId()).thenReturn("1");
        EmployeeWOEmployeeNum testEmployee = new EmployeeWOEmployeeNum(
                "Test",
                0,
                "Testing",
                "2"
        );

        Employee expected = new Employee(
                "1",
                "Test",
                0,
                "Testing",
                "2"
        );
        //WHEN
        EmployeeWOSocialSecNum actual = service.createNewEmployee(testEmployee);
        //THEN
        Assertions.assertEquals(expected, actual);
        verify(mockRepo).save(new Employee(
                "1",
                "Test",
                0,
                "Testing",
                "2"
        ));
    }
}