package com.capstone.dayj.plan;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlanController {
    private PlanService planService;
    
    public PlanController(PlanService planService) {
        this.planService = planService;
    }
    
    @PostMapping("/plan")
    public void createPlan(@Valid @RequestBody Plan plan) {
        planService.createPlan(plan);
    }
    
    @GetMapping("/plan")
    public List<Plan> readAllPlan() {
        return planService.readAllPlan();
    }
    
    @GetMapping("/plan/{id}")
    public Plan readPlanById(@PathVariable int id) {
        return planService.readPlanById(id);
    }

    @PatchMapping("/plan/{id}")
    public void patchPlan(@Valid @RequestBody Plan plan) {
        planService.updatePlan(plan);
    }
    
    @DeleteMapping("/plan/{id}")
    public void deletePlanById(@PathVariable int id) {
        planService.deletePlanById(id);
    }
}
