package io.zipcoder.persistenceapp.Services;

import io.zipcoder.persistenceapp.Entities.Employee;
import io.zipcoder.persistenceapp.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Service
public class EmployeeServices {

    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeServices(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/API/{id}")
    public Employee getEmployee(@PathVariable Integer id){
        return employeeRepository.findOne(id);
    }

    @PostMapping("/API/{employee}")
    public Employee createEmployee(@PathVariable Employee employee){
        return employeeRepository.save(employee);
    }

    @PutMapping("/API/{id}")
    public Employee updateManager(Employee employee, String manager, @PathVariable Integer id){
        employee.setManager(manager);
        return employeeRepository.save(employee);
    }


    @PutMapping("/API/{id}")
    public Employee updateFirstName(Employee employee, String firstName, @PathVariable Integer id){
        employee.setFirstName(firstName);
        return employeeRepository.save(employee);
    }

    @PutMapping("/API/{id}")
    public Employee updateLastName(Employee employee, String lastName, @PathVariable Integer id){
        employee.setLastName(lastName);
        return employeeRepository.save(employee);
    }

    @PutMapping("/API/{id}")
    public Employee updateDepartmentNumber(Employee employee, Integer deptNumber, @PathVariable Integer id){
        employee.setDeptNumber(deptNumber);
        return employeeRepository.save(employee);
    }

    @PutMapping("/API/{id}")
    public Employee updatePhoneNumber(Employee employee, String phoneNumber, @PathVariable Integer id){
        employee.setPhoneNumber(phoneNumber);
        return employeeRepository.save(employee);
    }

    @PutMapping("/API/{id}")
    public Employee updateTitle(Employee employee, String title, @PathVariable Integer id){
        employee.setTitle(title);
        return employeeRepository.save(employee);
    }


}
