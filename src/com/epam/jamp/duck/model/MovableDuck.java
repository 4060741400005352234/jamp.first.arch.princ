package com.epam.jamp.duck.model;

import com.epam.jamp.behavior.MovementBehavior;
import org.apache.log4j.Logger;

public abstract class MovableDuck extends Duck implements MovementBehavior {

    private static Logger log = Logger.getLogger(MovableDuck.class);

    public MovableDuck(String name) {
        super(name);
    }

    @Override
    public void stepForward() {
        if (nextStepAvailable()) {
            //System.out.println("Step forward.");
            log.info("Duck " + getName() + " stepped forward.");
            nextStep();
        } else {
            sayHungry();
        }
    }

    @Override
    public void stepBack() {
        if (nextStepAvailable()) {
            //System.out.println("Step back.");
            log.info("Duck " + getName() + " stepped back.");
            nextStep();
        } else {
            sayHungry();
        }
    }

    @Override
    public void stepRight() {
        if (nextStepAvailable()) {
            //System.out.println("Step to right.");
            log.info("Duck " + getName() + " stepped right.");
            nextStep();
        } else {
            sayHungry();
        }
    }

    @Override
    public void stepLeft() {
        if (nextStepAvailable()) {
            //System.out.println("Step to left.");
            log.info("Duck " + getName() + " stepped left.");
            nextStep();
        } else {
            sayHungry();
        }
    }

    @Override
    public void performEat() {
        if (eatBehavior != null && !isSwimmingNow()) {
            eatBehavior.fillUp();
            allowNextMovements();
        } else {
            System.out.println("I can't fill up while I swimming.");
        }
    }

    @Override
    public void performDrink() {
        if (drinkBehavior != null) {
            if (isSwimmingNow()) {
                drinkBehavior.fillUp();
                allowNextMovements();
            } else {
                System.out.println("I can't drink now. I can drink only on water.");
            }
        } else {
            System.out.println("I can't drink.");
        }
    }

    protected abstract void nextStep();
    protected abstract boolean nextStepAvailable();
    protected abstract void sayHungry();
}
