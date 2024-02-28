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
    
    @PostMapping("/plan/create")
    public ResponseEntity<Plan> createPlan(@Valid @RequestBody Plan plan) {
        Plan savedPlan = planService.createPlan(plan);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPlan.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    
    @GetMapping("/plan/read")
    public List<Plan> readAllPlan() {
        return planService.readAllPlan();
    }
    
    @GetMapping("/plan/read/{id}")
    public Plan readPlanById(@PathVariable int id) {
        return planService.readPlanById(id);
    }

    @GetMapping("/plan/update/{id}")
    public Plan updatePlanView(@PathVariable int id) {
        return planService.readPlanById(id);
    }

    @PatchMapping("/plan/update/{id}")
    public void patchPlan(@Valid @RequestBody Plan plan) {
        planService.updatePlan(plan);
    }

    @DeleteMapping("/plan/delete/{id}")
    public void deletePlanById(@PathVariable int id) {
        planService.deletePlanById(id);
    }
}
