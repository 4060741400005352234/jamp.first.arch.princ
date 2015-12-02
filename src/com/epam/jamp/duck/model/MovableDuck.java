package com.epam.jamp.duck.model;

import com.epam.jamp.behavior.MovementBehavior;
import org.apache.log4j.Logger;

public abstract class MovableDuck extends Duck implements MovementBehavior {

    private static Logger log = Logger.getLogger(MovableDuck.class);

    public MovableDuck(String name) {
        super(name);
    }

    @Override
    public double stepForward() {
        if (nextStepAvailable()) {
            //System.out.println("Step forward.");
            log.info("Duck " + getName() + " stepped forward.");
            nextStep();
            return getStepLength();
        } else {
            sayHungry();
        }
        return 0;
    }

    @Override
    public double stepBack() {
        if (nextStepAvailable()) {
            //System.out.println("Step back.");
            log.info("Duck " + getName() + " stepped back.");
            nextStep();
            return getStepLength();
        } else {
            sayHungry();
        }
        return 0;
    }

    @Override
    public double stepRight() {
        if (nextStepAvailable()) {
            //System.out.println("Step to right.");
            log.info("Duck " + getName() + " stepped right.");
            nextStep();
            return getStepLength();
        } else {
            sayHungry();
        }
        return 0;
    }

    @Override
    public double stepLeft() {
        if (nextStepAvailable()) {
            //System.out.println("Step to left.");
            log.info("Duck " + getName() + " stepped left.");
            nextStep();
            return getStepLength();
        } else {
            sayHungry();
        }
        return 0;
    }

    @Override
    public void performEat() {
        if (getEatBehavior() != null && !isSwimmingNow()) {
            getEatBehavior().fillUp();
            allowNextMovements();
        } else {
            System.out.println("I can't fill up while I swimming.");
        }
    }

    @Override
    public void performDrink() {
        if (getDrinkBehavior() != null) {
            if (isSwimmingNow()) {
                getDrinkBehavior().fillUp();
                allowNextMovements();
            } else {
                System.out.println("I can't drink now. I can drink only on water.");
            }
        } else {
            System.out.println("I can't drink.");
        }
    }
    protected double getStepLength() {
        return 1;
    }

    protected abstract void nextStep();
    protected abstract boolean nextStepAvailable();
    protected abstract void sayHungry();
}
