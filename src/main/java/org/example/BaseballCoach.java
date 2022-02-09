package org.example;

public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice back volley today";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
