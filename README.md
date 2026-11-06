# DAA Projects

This repository contains Design and Analysis of Algorithms (DAA) projects.

## Projects

* DAA Macro Project - Project 135t7
* Unit 1 Sorting
* DAA Macro Project - N Queens
* DAA Macro Project - Project 9
* Strassen Matrix Multiplication

Each project is organized in its own folder.
package com.example.demo;

public class Registration {

    private int id;
    private String name;
    private String email;
    private String eventName;

    public Registration() {
    }

    public Registration(int id, String name, String email, String eventName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.eventName = eventName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public List<Registration> getAllRegistrations() {
        return registrationService.getAllRegistrations();
    }

    @PostMapping
    public Registration addRegistration(@RequestBody Registration registration) {
        return registrationService.addRegistration(registration);
    }
}
package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationService {

    private final List<Registration> registrations = new ArrayList<>();

    public List<Registration> getAllRegistrations() {
        return registrations;
    }

    public Registration addRegistration(Registration registration) {
        registrations.add(registration);
        return registration;
    }
}
