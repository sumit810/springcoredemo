package com.luv2code.springcoredemo.common;

import com.luv2code.springcoredemo.Coach;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Have a hard fast 10k";
    }
}
