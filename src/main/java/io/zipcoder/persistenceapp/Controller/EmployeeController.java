package io.zipcoder.persistenceapp.Controller;



import io.zipcoder.persistenceapp.Entities.Employee;
import io.zipcoder.persistenceapp.Services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeServices employeeServices;

    public EmployeeController(EmployeeServices employeeServices){
        this.employeeServices = employeeServices;
    }

    @GetMapping("/API/employee/{id}")
    public Employee getEmployee(@PathVariable Integer id){
        return employeeServices.getEmployee(id);
    }

    @PostMapping("/API/employee")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeServices.createEmployee(employee);
    }

    @PutMapping("/API/employee/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Integer id){
        return employeeServices.updateEmployee(employee, id);
    }

    @GetMapping("/API/employee/{manager}")
    public List<Employee> findEmployeesByManager(@PathVariable String manager){
        return employeeServices.findEmployeesByManager(manager);
    }





}
