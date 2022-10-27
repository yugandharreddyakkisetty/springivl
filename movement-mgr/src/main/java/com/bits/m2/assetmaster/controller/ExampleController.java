package com.bits.m2.assetmaster.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @GetMapping("/first")
    public String foo() {
        return "Hello World";
    }
}
