package com.wsiiz.repairshop.enterprise.domain.branch;

import com.wsiiz.repairshop.enterprise.domain.employee.Employee;
import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import com.wsiiz.repairshop.shared.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AllArgsConstructor
public class Branch extends BaseEntity {
    String name; //Nazwa
    Address address; //Adres
    @Enumerated(EnumType.STRING)
    BranchActivityType branchActivityType;  //Typ działalności

    @OneToMany(mappedBy = "branch", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Employee> employees;


    Long MasterBranchId;

    public Branch() {
        this.employees = new ArrayList<>();
    }
}

