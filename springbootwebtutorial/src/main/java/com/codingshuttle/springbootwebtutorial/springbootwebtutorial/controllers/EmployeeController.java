package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.controllers;


import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

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
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("employeeId") Long id){
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(id);
        return employeeDTO
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping()
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO createdEmployee = employeeService.createNewEmployee(employeeDTO);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED) ;
    }

    @PutMapping("/{employeeId}")
   public ResponseEntity<EmployeeDTO> updateEmployeeId(@RequestBody EmployeeDTO employeeDTO, @PathVariable("employeeId") Long id){
        EmployeeDTO updatedEmployee = employeeService.updateEmployeeById(employeeDTO, id);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable("employeeId") Long id){
        return ResponseEntity.ok(employeeService.deleteEmployeeById(id));
    }



 }
