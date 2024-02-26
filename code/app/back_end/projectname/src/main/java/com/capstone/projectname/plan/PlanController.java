package com.capstone.projectname.plan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlanController {
    PlanRepository planRepository;
    
    
    public PlanController(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }
    
    @GetMapping("/find-plan")
    public List<Plan> findAll() {
        return planRepository.findAll();
    }

    @GetMapping("/find-plan-id")
    public Plan findById() {
        return planRepository.findById(1).get();
    }

    @GetMapping("/delete-plan-id")
    public void deleteById() {
        planRepository.deleteById(1);
    }
}
