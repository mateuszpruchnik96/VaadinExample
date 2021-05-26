package com.wsiiz.repairshop.enterprise.domain.employee;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

   List<Employee> findByBranch_Id(Long branchId);
    //@Query(value = "select sr from Employee sr where (:branchId = null or sr.branchId = :branchId) ")
   // List<Employee> findByBranchId(@Param("branchId") Long branchId);
}
