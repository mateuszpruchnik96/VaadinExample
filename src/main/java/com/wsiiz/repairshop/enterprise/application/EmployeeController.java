package com.wsiiz.repairshop.enterprise.application;

import com.wsiiz.repairshop.enterprise.domain.branch.BranchRepository;
import com.wsiiz.repairshop.enterprise.domain.employee.Employee;
import com.wsiiz.repairshop.enterprise.domain.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

  @Autowired
  EmployeeRepository employeeRepository ;

  @Autowired
  BranchRepository branchRepository;

  @GetMapping("/employees")
  public ResponseEntity<List<Employee>> getMany() {
    return ResponseEntity.ok(employeeRepository.findAll());
  }

  @GetMapping("/employees/{id}")
  public ResponseEntity<Employee> getOne(@PathVariable("id") Long id) {

    Optional<Employee> employee = employeeRepository.findById(id);

    if (employee.isPresent()) {
      return ResponseEntity.ok(employee.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/employees")
  public ResponseEntity<Employee> addNew(@RequestBody Employee employee) {
    if (employee.getBranchId() != null) {
      employee.setBranch(branchRepository.getOne(employee.getBranchId()));
    }
    return ResponseEntity.created(null).body(employeeRepository.save(employee));
  }

  @DeleteMapping("/employees/{id}")
  public ResponseEntity<Employee> remove(@PathVariable("id") Long id) {

    Optional<Employee> employee = employeeRepository.findById(id);

    if (employee.isPresent()) {
      employeeRepository.deleteById(id);
      return ResponseEntity.ok(employee.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

}
