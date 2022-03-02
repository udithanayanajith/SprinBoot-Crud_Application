package net.javaguide.springbootcrud.controller;

import net.javaguide.springbootcrud.model.Employee;
import net.javaguide.springbootcrud.repository.EmployeeRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepositary employeeRepositary;
    //Get employee list methode
    public List<Employee> getAllEmployyes(){
        return employeeRepositary.findAll();
    }

}
