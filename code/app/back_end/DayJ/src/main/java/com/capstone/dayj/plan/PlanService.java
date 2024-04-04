package com.capstone.dayj.plan;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {
    private PlanRepository planRepository;
    
    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }
    
    public void createPlan(Plan plan) {
        planRepository.save(plan);
    }
    
    public List<Plan> readAllPlan() {
        return planRepository.findAll();
    }
    
    public Plan readPlanById(int id) {
        return planRepository.findById(id)
                .orElseThrow(() -> new PlanNotFoundException("해당 id를 가진 계획이 없습니다."));
    }
    
    public void updatePlan(int id, Plan plan) {
        Plan existingPlan = planRepository.findById(id)
                .orElseThrow(() -> new PlanNotFoundException("해당 id를 가진 계획이 없습니다."));
        
        existingPlan.setId(plan.getId());
        planRepository.save(existingPlan);
    }
    
    public void deletePlanById(int id) {
        planRepository.deleteById(id);
    }
}