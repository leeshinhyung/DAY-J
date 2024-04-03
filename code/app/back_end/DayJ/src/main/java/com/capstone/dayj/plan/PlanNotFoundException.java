package com.capstone.dayj.plan;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PlanNotFoundException extends RuntimeException {
    final String message;
}