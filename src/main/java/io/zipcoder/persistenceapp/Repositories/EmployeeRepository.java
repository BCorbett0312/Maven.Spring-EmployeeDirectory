package io.zipcoder.persistenceapp.Repositories;

import io.zipcoder.persistenceapp.Entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    List<Employee> findEmployeesByManager(Employee manager);
    Employee findByEmployeeNumber(Integer employeeNumber);
    List<Employee> findEmployeesByManagerIsNull();



}
