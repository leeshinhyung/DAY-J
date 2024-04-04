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
        return planRepository.findAll();
    }

    public Plan readPlanById(int id) {
        Optional<Plan> plan = planRepository.findById(id);

        if (plan.isEmpty())
            throw new PlanNotFoundException("해당 id를 가진 계획이 없습니다.");

        return plan.get();
    }

    public void updatePlan(Plan plan) {
        planRepository.save(plan);
    }

    public void deletePlanById(int id) {
        planRepository.deleteById(id);
    }
}