package com.capstone.dayj.plan;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
            throw new PlanNotFoundException("현재 계획 데이터가 존재하지 않습니다.");
        
        return plans;
    }
    
    public Optional<Plan> readPlanById(int id) {
        return Optional.ofNullable(planRepository.findById(id)
                .orElseThrow(() -> new PlanNotFoundException("해당 id를 가진 계획이 없습니다.")));
    }
    
    public Optional<Plan> readPlanByPlanTag(String planTag) {
        return Optional.ofNullable(planRepository.findByPlanTag(planTag)
                .orElseThrow(() -> new PlanNotFoundException("해당 태그를 가진 계획이 없습니다.")));
    }
    
    public void updatePlan(int id, Plan plan) {
        Plan existingPlan = planRepository.findById(id)
                .orElseThrow(() -> new PlanNotFoundException("해당 id를 가진 계획이 없습니다."));
        
        existingPlan.setId(plan.getId());
        planRepository.save(existingPlan);
    }
    
    public void deletePlanById(int id) {
        planRepository.findById(id)
                .orElseThrow(() -> new PlanNotFoundException("해당 id를 가진 계획이 없습니다."));
        
        planRepository.deleteById(id);
    }
}