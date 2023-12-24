package com.luv2code.springcoredemo.common;

import com.luv2code.springcoredemo.Coach;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Batting for 30 minutes! what a game!";
    }
}
