package com.wsiiz.repairshop.enterprise.application;

import com.wsiiz.repairshop.enterprise.domain.branch.BranchRepository;
import com.wsiiz.repairshop.enterprise.domain.branch.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class BranchController {

        @Autowired
        BranchRepository branchRepository;

        @GetMapping("/branches")
        public ResponseEntity<List<Branch>> getMany() {
            return ResponseEntity.ok(branchRepository.findAll());
        }

        @GetMapping("/branches/{id}")
        public ResponseEntity<Branch> getOne(@PathVariable("id") Long id) {

            Optional<Branch> branch = branchRepository.findById(id);

            if (branch.isPresent()) {
                return ResponseEntity.ok(branch.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @PostMapping("/branches")
        public ResponseEntity<Branch> addNew(@RequestBody Branch branch) {
            branch.getEmployees().forEach(r -> r.setBranch(branch));
            return ResponseEntity.created(null).body(branchRepository.save(branch));
        }

        @DeleteMapping("/branches/{id}")
        public ResponseEntity<Branch> remove(@PathVariable("id") Long id) {

            Optional<Branch> branch = branchRepository.findById(id);

            if (branch.isPresent()) {
                branchRepository.deleteById(id);
                return ResponseEntity.ok(branch.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }

    }


