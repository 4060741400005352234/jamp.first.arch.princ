package com.epam.jamp.duck.model;

import org.apache.log4j.Logger;

public class RubberDuck extends MovableDuck {

    private static Logger log = Logger.getLogger(RubberDuck.class);

    private static final int STEP_COUNT_TO_HUNGRY = 4;
    private int stepCount;
    private boolean poweredOff;

    public RubberDuck(String name) {
        super(name);
    }

    @Override
    public void performEat() {
        if (eatBehavior != null) {
            eatBehavior.fillUp();
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
        ++stepCount;
    }

    @Override
    protected boolean nextStepAvailable() {
        return stepCount <= STEP_COUNT_TO_HUNGRY;
    }

    @Override
    protected void sayHungry() {
        if (!poweredOff) {
            for (int i = 0; i < 5; ++i) {
                performQuack();
            }
            poweredOff = true;
        } else {
            //System.out.println("Duck is powered off. Feed her.");
            log.info("Duck " + getName() + " is powered off. Feed her.");
        }
    }

    @Override
    public void allowNextMovements() {
        stepCount = 0;
        poweredOff = true;
        log.info("Duck " + getName() + " can make next step.");
    }
}
