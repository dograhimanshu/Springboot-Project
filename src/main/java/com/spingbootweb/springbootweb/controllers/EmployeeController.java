package com.spingbootweb.springbootweb.controllers;

import com.spingbootweb.springbootweb.dto.EmployeeDTO;
import com.spingbootweb.springbootweb.entities.EmployeeEntity;
import com.spingbootweb.springbootweb.repositories.EmployeeRepository;
import com.spingbootweb.springbootweb.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController//Rest in nature
@RequestMapping(path="/employees")
public class EmployeeController {


    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

     @GetMapping(path="/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId){
       //  return new EmployeeDTO(employeeId,"Himanshu","himanshudogra22@gmail.com",27, LocalDate.of(2024,2,26),true);
         return employeeService.getEmployeeById(employeeId);

    }
     @GetMapping
         public List<EmployeeDTO> getAllEmployees(@RequestParam(required=false,name="inputAge") Integer age, @RequestParam(required =false) String sortBy){
         return  employeeService.getAllEmployees();

         }
    @PostMapping
    public EmployeeDTO createNewEmployees(@RequestBody EmployeeDTO inputEmployee) {
       return employeeService.createNewEmployee(inputEmployee);
    }
    @PutMapping String updateEmployeeById(){
         return "hello from put";
    }

}
