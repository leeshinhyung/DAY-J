package com.capstone.projectname.plan;

import com.capstone.projectname.appUser.AppUser;
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
    
    public Plan createPlan(Plan plan) {
        plan.setId(++planCount);
        plans.add(plan);
        return plan;
    }
    
    public List<Plan> readAllPlan() {
        return plans;
    }
    
    public Plan readPlanById(int id) {
        Predicate<? super Plan> predicate = plan -> plan.getId() == id;
        return plans.stream().filter(predicate).findFirst().orElse(null);
    }

    public void updatePlan(Plan plan) {
        Predicate<? super Plan> predicate = user -> user.getId() == plan.getId();
        Plan prevPlan = plans.stream().filter(predicate).findFirst().orElse(null);
        plans.remove(prevPlan);
        plans.add(plan);
    }
    
    public void deletePlanById(int id) {
        Predicate<? super Plan> predicate = plan -> plan.getId() == id;
        plans.removeIf(predicate);
    }
}