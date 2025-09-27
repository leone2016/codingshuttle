package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.controllers;


import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @GetMapping(path = "/getSecret")
    public String getMySupperSecretMessage(){
        return "Hello World!: asdasd12214434";
    }

    @GetMapping(path="/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable("employeeId") Long id){
        EmployeeDTO employeeDTO = new EmployeeDTO(id, "Leonardo",
                "leoz.31@hotmail.com", 34,
                LocalDate.of(1991, 11, 10), true );
        return employeeDTO;
    }

    @GetMapping()
    public String getAllEmployees(@RequestParam Integer age, @RequestParam String sortBy){

        return "Hi age"+ age + " sortBy: "+sortBy;
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO){
        employeeDTO.setId(1991L);
        return employeeDTO;
    }

    @PutMapping
    public String updateEmployeeId(){
        return "Hello World!: PUT EMPLOYEE";
    }
}
