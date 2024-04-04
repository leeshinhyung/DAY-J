package com.capstone.dayj.plan;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plan")
public class PlanController {
    private PlanService planService;
    
    public PlanController(PlanService planService) {
        this.planService = planService;
    }
    
    @PostMapping
    public void createPlan(@Valid @RequestBody Plan plan) {
        planService.createPlan(plan);
    }
    
    @GetMapping
    public List<Plan> readAllPlan() {
        return planService.readAllPlan();
    }
    
    @GetMapping("/{id}")
    public Plan readPlanById(@PathVariable int id) {
        return planService.readPlanById(id);
    }
    
    @PatchMapping("/{id}")
    public void patchPlan(@PathVariable int id, @Valid @RequestBody Plan plan) {
        planService.updatePlan(id, plan);
    }
    
    @DeleteMapping("/{id}")
    public void deletePlanById(@PathVariable int id) {
        planService.deletePlanById(id);
    }
}
