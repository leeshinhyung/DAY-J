package com.capstone.dayj.plan;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
    public void createPlan(@Valid @RequestBody PlanDto.Request dto) {
        planService.createPlan(dto);
    }
    
    @GetMapping
    public List<Plan> readAllPlan() {
        return planService.readAllPlan();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity readPlanById(@PathVariable int id) {
        return ResponseEntity.ok(planService.readPlanById(id));
    }
    
    @GetMapping("tag/{planTag}")
    public ResponseEntity readByPlanTag(@PathVariable String planTag) {
        return ResponseEntity.ok(planService.readPlanByPlanTag(planTag));
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity patchPlan(@PathVariable int id, @Valid @RequestBody PlanDto.Request dto) {
        planService.updatePlan(id, dto);
        return ResponseEntity.ok(id);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deletePlanById(@PathVariable int id) {
        planService.deletePlanById(id);
        return ResponseEntity.ok(id);
    }
}
