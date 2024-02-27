package com.capstone.projectname.plan;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PlanController {
    PlanService planService;
    
    public PlanController(PlanService planService) {
        this.planService = planService;
    }
    
    @PostMapping("/create-plan")
    public ResponseEntity<Plan> create(@Valid @RequestBody Plan plan) {
        Plan savedPlan = planService.save(plan);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPlan.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    
    @GetMapping("/find-plan")
    public List<Plan> findAll() {
        return planService.findAll();
    }
    
    @GetMapping("/find-plan/{id}")
    public Plan findById(@PathVariable int id) {
        Plan plan = planService.findOne(id);
        return plan;
    }
    
    
    @DeleteMapping("/delete-plan/{id}")
    public void deleteById(@PathVariable int id) {
        planService.deleteById(id);
    }
}
