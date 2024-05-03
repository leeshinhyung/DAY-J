package com.capstone.dayj.plan;

import com.capstone.dayj.exception.CustomException;
import com.capstone.dayj.exception.ErrorCode;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanService {
    private PlanRepository planRepository;
    
    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }
    
    @Transactional
    public void createPlan(PlanDto.Request dto) {
        Plan plan = dto.toEntity();
        planRepository.save(plan);
    }
    
    @Transactional
    public List<PlanDto.Response> readAllPlan() {
        List<Plan> plans = planRepository.findAll();
        
        if (plans.isEmpty())
            throw new CustomException(ErrorCode.PLAN_NOT_FOUND);
        
        return plans.stream().map(PlanDto.Response::new).collect(Collectors.toList());
    }
    
    @Transactional
    public PlanDto.Response readPlanById(int id) {
        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.PLAN_NOT_FOUND));
        
        return new PlanDto.Response(plan);
    }
    
    @Transactional
    public PlanDto.Response readPlanByPlanTag(String planTag) {
        Plan plan = planRepository.findByPlanTag(planTag)
                .orElseThrow(() -> new CustomException(ErrorCode.PLAN_NOT_FOUND));
        
        return new PlanDto.Response(plan);
    }
    
    @Transactional
    public void updatePlan(int id, PlanDto.Request dto) {
        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.PLAN_NOT_FOUND));
        
        plan.update(dto.getPlanAlarmDate(), dto.getPlanTag(),
                dto.getGoal(), dto.getPlanPhoto(), dto.getPlanTime(), dto.getPlanDay());
    }
    
    @Transactional
    public void deletePlanById(int id) {
        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.PLAN_NOT_FOUND));
        PlanDto.Response planDto = new PlanDto.Response(plan);
        
        planRepository.deleteById(planDto.getId());
    }
}