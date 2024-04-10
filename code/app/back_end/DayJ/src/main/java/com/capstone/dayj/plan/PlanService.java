package com.capstone.dayj.plan;

import com.capstone.dayj.exception.CustomException;
import com.capstone.dayj.exception.ErrorCode;
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
        List<Plan> plans = planRepository.findAll();
        
        if (plans.isEmpty())
            throw new CustomException(ErrorCode.PLAN_NOT_FOUND);
        
        return plans;
    }
    
    public Plan readPlanById(int id) {
        return planRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.PLAN_NOT_FOUND));
    }
    
    public Plan readPlanByPlanTag(String planTag) {
        return planRepository.findByPlanTag(planTag)
                .orElseThrow(() -> new CustomException(ErrorCode.PLAN_NOT_FOUND));
    }
    
    public void updatePlan(int id, Plan plan) {
        Plan existingPlan = planRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.PLAN_NOT_FOUND));
        
        existingPlan.setId(plan.getId());
        planRepository.save(existingPlan);
    }
    
    public void deletePlanById(int id) {
        planRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.PLAN_NOT_FOUND));
        
        planRepository.deleteById(id);
    }
}