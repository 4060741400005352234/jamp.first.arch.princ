package com.epam.jamp.duck.model;

import com.epam.jamp.behavior.*;
import org.apache.log4j.Logger;

public abstract class Duck {

    private static Logger log = Logger.getLogger(Duck.class);

    private String name;
    private boolean swimmingNow;
    protected QuackBehavior quackBehavior;
    protected FlapBehavior flapBehavior;
    protected FillUpEnergyBehavior eatBehavior;
    protected FillUpEnergyBehavior drinkBehavior;
    protected SwimBehavior swimBehavior;
    protected FlyBehavior flyBehavior;
    protected WalkBehavior walkBehavior;

    public Duck(String name) {
        this.name = name;
}

    public void performQuack() {
        if (quackBehavior != null) {
            quackBehavior.quack();
        }
    }

    public void performFlap() {
        if (flapBehavior != null) {
            flapBehavior.flap();
        }
    }

    public void performEat() {
        if (eatBehavior != null) {
            eatBehavior.fillUp();
        }
    }

    public void performDrink() {
        if (drinkBehavior != null) {
            drinkBehavior.fillUp();
        }
    }

    public String getName() {
        return name;
    }

    protected void setSwimmingNow(boolean swimmingNow) {
        this.swimmingNow = swimmingNow;
    }

    protected boolean isSwimmingNow() {
        return swimmingNow;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void setFlapBehavior(FlapBehavior flapBehavior) {
        this.flapBehavior = flapBehavior;
    }

    public void setEatBehavior(FillUpEnergyBehavior eatBehavior) {
        this.eatBehavior = eatBehavior;
    }

    public void setDrinkBehavior(FillUpEnergyBehavior drinkBehavior) {
        this.drinkBehavior = drinkBehavior;
    }

    public void setSwimBehavior(SwimBehavior swimBehavior) {
        this.swimBehavior = swimBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setWalkBehavior(WalkBehavior walkBehavior) {
        this.walkBehavior = walkBehavior;
    }

    public void performSwim() {
        if (swimBehavior != null) {
            swimBehavior.swim();
            swimmingNow = true;
        } else {
            //System.out.println("Duck can't swim.");
            log.info("Duck can't swim.");
        }
    }

    public void performWalk() {
        if (walkBehavior != null) {
            walkBehavior.walk();
            swimmingNow = false;
        } else {
            //System.out.println("Duck can't walk.");
            log.info("Duck can't walk.");
        }
    }

    public void performFly() {
        if (flyBehavior != null) {
            flyBehavior.fly();
            swimmingNow = false;
        } else {
            //System.out.println("Duck can't fly.");
            log.info("Duck can't fly.");
        }
    }

    public abstract void display();
}
