package com.wsiiz.repairshop.enterprise.domain.employee;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wsiiz.repairshop.enterprise.domain.branch.Branch;
import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
public class Employee extends BaseEntity {
    String name;
    String surname;
    @Enumerated(EnumType.STRING)
    Position position;
    LocalDate hireDate;

    @Transient
    Long branchId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "branch_id")
    @JsonIgnore
    Branch branch;

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<EmployeeSkills> employeeSkills;

    public Employee() {
        this.employeeSkills = new ArrayList<>();
    }

}
