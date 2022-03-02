package net.javaguide.springbootcrud.repository;

import net.javaguide.springbootcrud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepositary extends JpaRepository<Employee, Integer> {
// All db methodes
}
