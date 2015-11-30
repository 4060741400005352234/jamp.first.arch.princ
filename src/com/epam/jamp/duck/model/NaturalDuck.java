package com.epam.jamp.duck.model;

import org.apache.log4j.Logger;

public class NaturalDuck extends MovableDuck {

    private static Logger log = Logger.getLogger(RubberDuck.class);

    private static final int STEP_COUNT_TO_HUNGRY = 4;
    private int stepCount;

    public NaturalDuck(String name) {
        super(name);
    }

    @Override
    protected void nextStep() {
        ++stepCount;
    }

    @Override
    protected boolean nextStepAvailable() {
        return stepCount <= STEP_COUNT_TO_HUNGRY;
    }

    @Override
    protected void sayHungry() {
        //System.out.println("I can't move. I'm hungry.");
        log.info("Duck " + getName() + " can't move. It's hungry.");
    }

    @Override
    public void performSwim() {
        setSwimmingNow(true);
        //System.out.println("Duck is on water.");
        log.info("Duck " + getName() + " is swimming.");
    }

    @Override
    public void performWalk() {
        setSwimmingNow(false);
        //System.out.println("Duck is on a ground.");
        log.info("Duck " + getName() + " is walking.");
    }

    @Override
    public void performFly() {
        setSwimmingNow(false);
        //System.out.println("Duck is in the sky.");
        log.info("Duck " + getName() + " is flying.");
    }

    @Override
    public void display() {
        System.out.println("I'm natural duck " + getName());
    }

    @Override
    public void allowNextMovements() {
        stepCount = 0;
    }
}
