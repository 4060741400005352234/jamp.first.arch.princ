package com.epam.jamp.duck.model;

import org.apache.log4j.Logger;

public class RubberDuck extends MovableDuck {

    private static final int STEP_COUNT_TO_HUNGRY = 10;

    private static Logger log = Logger.getLogger(RubberDuck.class);

    private double stepCount;
    private boolean poweredOff;

    public RubberDuck(String name) {
        super(name);
    }

    @Override
    public void performEat() {
        if (getEatBehavior() != null) {
            getEatBehavior().fillUp();
            allowNextMovements();
            log.info("Duck " + getName() + " is not hungry.");
        }
    }

    @Override
    public void display() {
        System.out.println("I'm rubber duck " + getName());
    }


    @Override
    protected void nextStep() {
        stepCount += getStepLength();
    }

    @Override
    protected boolean nextStepAvailable() {
        return stepCount < STEP_COUNT_TO_HUNGRY;
    }

    @Override
    protected void sayHungry() {
        if (!poweredOff) {
            performQuack();
            poweredOff = true;
        } else {
            //System.out.println("Duck is powered off. Feed her.");
            log.info("Duck " + getName() + " is powered off. Feed her.");
        }
    }

    @Override
    protected double getStepLength() {
        return 0.5;
    }

    @Override
    public void allowNextMovements() {
        stepCount = 0;
        poweredOff = false;
        log.info("Duck " + getName() + " can make next step.");
    }
}
