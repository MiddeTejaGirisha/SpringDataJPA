package com.example.DTOClassBasedProjections;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;


@Service
@Validated
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDTO> getAllEmployees() {

        return employeeRepository.findAllEmployeeDTOs();
    }
    @CachePut(cacheNames = "employees")

    public Employee saveEmployee(@Valid Employee employee) {

        return employeeRepository.save(employee);
    }

    @Cacheable(cacheNames = "employees")
    public List<Employee> findEmployeesByLastName(String lastName) {
        return employeeRepository.findByLastName(lastName);
    }



    @CacheEvict(cacheNames = "employees", key = "#id")
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

}
