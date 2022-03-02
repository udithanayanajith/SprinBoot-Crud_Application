package net.javaguide.springbootcrud.controller;

import net.javaguide.springbootcrud.model.Employee;
import net.javaguide.springbootcrud.repository.EmployeeRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepositary employeeRepositary;


    //Get employee list methode
    @GetMapping
    public List<Employee> getAllEmployyes(){

        return employeeRepositary.findAll();
    }

    //Create a new employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepositary.save(employee);
    }

}
