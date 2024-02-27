package com.capstone.projectname.plan;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class PlanService {
    private static List<Plan> plans = new ArrayList<>();
    private static int planCount = 0;
    
    static {
        plans.add(new Plan(++planCount, false, LocalDate.now(), LocalDate.now(), "diet", "60kg", "photo", LocalDate.now(), LocalDate.now()));
        plans.add(new Plan(++planCount, true, LocalDate.now(), LocalDate.now(), "study", "score100", "photo", LocalDate.now(), LocalDate.now()));
        plans.add(new Plan(++planCount, false, LocalDate.now(), LocalDate.now(), "trip", "jeju", "photo", LocalDate.now(), LocalDate.now()));
    }
    
    public Plan save(Plan plan) {
        plan.setId(++planCount);
        plans.add(plan);
        return plan;
    }
    
    public List<Plan> findAll() {
        return plans;
    }
    
    public Plan findOne(int id) {
        Predicate<? super Plan> predicate = plan -> plan.getId() == id;
        return plans.stream().filter(predicate).findFirst().orElse(null);
    }
    
    public void deleteById(int id) {
        Predicate<? super Plan> predicate = plan -> plan.getId() == id;
        plans.removeIf(predicate);
    }
}