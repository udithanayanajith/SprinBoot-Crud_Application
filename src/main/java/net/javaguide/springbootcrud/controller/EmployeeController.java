package net.javaguide.springbootcrud.controller;

import net.javaguide.springbootcrud.exception.ResourseNotFoundException;
import net.javaguide.springbootcrud.model.Employee;
import net.javaguide.springbootcrud.repository.EmployeeRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    // Get data/ filter data by Id
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById( @PathVariable Integer id){
       Employee employee = employeeRepositary.findById(id)
               .orElseThrow(()->new ResourseNotFoundException("There is not such data with id "+id));
        return ResponseEntity.ok(employee);
    }


    // Update employee API
    @PutMapping("{id}")
    public  ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employeeDetails){
        Employee updateEmployee= employeeRepositary.findById(id)
                .orElseThrow(()->new ResourseNotFoundException("Employee not exists with id "+ id));

        updateEmployee.setName(employeeDetails.getName());
        updateEmployee.setContact(employeeDetails.getContact());
        updateEmployee.setAddress(employeeDetails.getAddress());

        employeeRepositary.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }


 }
