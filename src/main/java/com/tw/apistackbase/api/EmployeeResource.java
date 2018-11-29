package com.tw.apistackbase.api;

import com.tw.apistackbase.core.Employee;
import com.tw.apistackbase.application.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {
    private final Logger log = Logger.getLogger(this.getClass().getName());

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping(produces = {"application/json"})
    public Iterable<Employee> list() {
        return employeeRepository.findAll();
//        return employeeService.list();
    }

    @PostMapping(produces = {"application/json"})
    public void add(@RequestBody Employee employee) {
        employeeRepository.save(employee);
//        employeeService.add(employee);
    }
}
