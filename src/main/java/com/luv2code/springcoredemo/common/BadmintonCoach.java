package com.luv2code.springcoredemo.common;

import com.luv2code.springcoredemo.Coach;
import org.springframework.stereotype.Component;


@Component
public class BadmintonCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "What a match today 18 -20!";
    }
}
