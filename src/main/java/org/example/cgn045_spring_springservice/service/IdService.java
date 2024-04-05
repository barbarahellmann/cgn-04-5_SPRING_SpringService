package org.example.cgn045_spring_springservice.service;

import java.util.UUID;

public class IdService {

    public String generateId(){
        return UUID.randomUUID().toString();
    }
}