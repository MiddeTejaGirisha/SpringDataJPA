package com.example.DTOClassBasedProjections;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
   @Query("SELECT new com.example.DTOClassBasedProjections.EmployeeDTO(e.firstName, e.lastName) FROM Employee e")
    List<EmployeeDTO> findAllEmployeeDTOs();

    //@Cacheable(cacheNames = "employees")
    //List<Employee> findByLastName(String lastName);

    @Cacheable(cacheNames = "employees")
    List<Employee> findByLastName(String lastName);

    @CachePut(cacheNames = "employees")
    Employee save(Employee employee);

    @CacheEvict(cacheNames = "employees", key = "#id")
    void deleteById(Long id);


}
