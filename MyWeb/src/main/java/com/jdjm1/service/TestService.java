package com.jdjm1.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String test() {

        System.err.println("Hello，Java Body ~");
        return "Hello，Java Body ~";
    }
}

