package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.controllers;


import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "/getSecret")
    public String getMySupperSecretMessage(){
        return "Hello World!: asdasd12214434";
    }

    @GetMapping(path="/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable("employeeId") Long id){
        ModelMapper mapper = new ModelMapper();
        return employeeService.getEmployeeById(id);
    }

    @GetMapping()
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO){

        return employeeService.createNewEmployee(employeeDTO);
    }

    @PutMapping
    public String updateEmployeeId(){
        return "Hello World!: PUT EMPLOYEE";
    }
}
