package com.wsiiz.repairshop.enterprise.domain.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wsiiz.repairshop.enterprise.domain.branch.Branch;
import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class EmployeeSkills extends BaseEntity {
    String skill;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    Employee employee;
}
