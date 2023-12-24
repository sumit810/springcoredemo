package com.luv2code.springcoredemo.common;

import com.luv2code.springcoredemo.Coach;

public class SwimCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "swim 1000 metres today buaah!!";
    }
}
