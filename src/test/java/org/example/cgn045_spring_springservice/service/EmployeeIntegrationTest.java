package org.example.cgn045_spring_springservice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class EmployeeIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void getAllEmployees_ShouldReturnEmptyList_WhenCalledInitially() throws Exception {
        //GIVEN
        //WHEN & THEN
        mvc.perform(MockMvcRequestBuilders.get("/api/employee"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }
}
