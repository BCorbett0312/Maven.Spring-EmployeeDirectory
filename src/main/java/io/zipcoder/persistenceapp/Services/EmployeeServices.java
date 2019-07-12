package io.zipcoder.persistenceapp.Services;

import io.zipcoder.persistenceapp.Entities.Employee;
import io.zipcoder.persistenceapp.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServices {

    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeServices(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }


    public Employee getEmployee(Integer id){
        return employeeRepository.findByEmployeeNumber(id);
    }


    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }


    public Employee updateEmployee(Employee employee, Integer id){
        Employee old = getEmployee(id);
        old.setFirstName(employee.getFirstName());
        old.setLastName(employee.getLastName());
        old.setTitle(employee.getTitle());
        old.setEmail(employee.getEmail());
        old.setPhoneNumber(employee.getPhoneNumber());
        old.setDeptNumber(employee.getDeptNumber());
        old.setManager(employee.getManager());

        return employeeRepository.save(old);
    }

    public List<Employee> findEmployeesByManager(Employee manager) {
        return employeeRepository.findEmployeesByManager(manager);

    }

    public List<Employee> findEmployeesWithoutManager(){
        return employeeRepository.findEmployeesByManagerIsNull();
    }
}
