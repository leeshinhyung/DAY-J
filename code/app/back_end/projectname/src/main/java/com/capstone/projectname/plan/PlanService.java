package com.capstone.projectname.plan;

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
        return planRepository.findById(id).get();
    }
    
    public void updatePlan(Plan plan) {
        planRepository.save(plan);
    }
    
    public void deletePlanById(int id) {
        planRepository.deleteById(id);
    }
}