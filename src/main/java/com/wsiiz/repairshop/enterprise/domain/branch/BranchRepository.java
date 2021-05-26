package com.wsiiz.repairshop.enterprise.domain.branch;


import com.wsiiz.repairshop.servicing.domain.servicerequest.RequestType;
import com.wsiiz.repairshop.servicing.domain.servicerequest.ServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch, Long> {
    List<Branch> findByMasterBranchId(Long masterBranchId);

    @Query(value = "select sr from Branch sr where (:masterBranchId = null or sr.masterBranchId = :masterBranchId) "
           )
    List<Branch> findBySelectionCriteria(@Param("masterBranchId") Long masterBranchId);
}
