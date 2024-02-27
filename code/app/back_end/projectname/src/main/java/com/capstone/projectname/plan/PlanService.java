package com.capstone.projectname.plan;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class PlanService {
    private static List<Plan> plan = new ArrayList<>();
    private static int planCount = 0;

    static{
        plan.add(new Plan(++planCount, false, LocalDate.now(), LocalDate.now(), "diet", "60kg", "photo", LocalDate.now(), LocalDate.now()));
        plan.add(new Plan(++planCount, true, LocalDate.now(), LocalDate.now(), "study", "score100", "photo", LocalDate.now(), LocalDate.now()));
        plan.add(new Plan(++planCount, false, LocalDate.now(), LocalDate.now(), "trip", "jeju", "photo", LocalDate.now(), LocalDate.now()));
    }

    public List<Plan> findAll(){
        return plan;
    }

    public Plan save(Plan plans) {
        plans.setPlanId(++planCount);
        plan.add(plans);
        return plans;
    }

    public Plan findOne(int id){
        Predicate<? super Plan> predicate = plan -> plan.getPlanId() == id;
        return plan.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteById(int id){
        Predicate<? super Plan> predicate = plan -> plan.getPlanId() == id;
        plan.removeIf(predicate);
    }
}