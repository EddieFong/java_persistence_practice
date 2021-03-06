package com.tw.apistackbase.api;

import com.tw.apistackbase.core.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {
    private final Logger log = Logger.getLogger(this.getClass().getName());

//    @Autowired
//    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping(produces = {"application/json"})
    public Iterable<Employee> list() {
        return employeeRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = {"application/json"})
    public Optional<Employee> list(@PathVariable Long id) {
        return employeeRepository.findById(id);
    }

    @PostMapping(produces = {"application/json"})
    public Long add(@RequestBody Employee employee) {
        employee = employeeRepository.save(employee);
        return employee.getId();
    }

//    @PostMapping(produces = {"application/json"})
//    public void add(@RequestBody Employee employee) {
//        employeeRepository.save(employee);
//    }
}
