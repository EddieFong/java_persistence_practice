package com.tw.apistackbase.api;
import java.util.List;

import com.tw.apistackbase.core.Employee;
import org.springframework.data.repository.CrudRepository;
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
