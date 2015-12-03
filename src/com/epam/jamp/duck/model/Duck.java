package com.epam.jamp.duck.model;

import com.epam.jamp.behavior.*;
import org.apache.log4j.Logger;

public abstract class Duck {

    private static Logger log = Logger.getLogger(Duck.class);

    private String name;
    private DuckPosition position;
    private QuackBehavior quackBehavior;
    private FlapBehavior flapBehavior;
    private SwimBehavior swimBehavior;
    private FlyBehavior flyBehavior;
    private WalkBehavior walkBehavior;
    private FillUpEnergyBehavior eatBehavior;
    private FillUpEnergyBehavior drinkBehavior;

    public Duck(String name) {
        this.name = name;
        position = DuckPosition.WALKING;
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

    public void performSwim() {
        if (swimBehavior != null) {
            swimBehavior.swim();
            position = DuckPosition.SWIMMING;
        } else {
            //System.out.println("Duck can't swim.");
            log.info("Duck can't swim.");
        }
    }

    public void performWalk() {
        if (walkBehavior != null) {
            walkBehavior.walk();
            position = DuckPosition.WALKING;
        } else {
            //System.out.println("Duck can't walk.");
            log.info("Duck can't walk.");
        }
    }

    public void performFly() {
        if (flyBehavior != null) {
            flyBehavior.fly();
            position = DuckPosition.FLYING;
        } else {
            //System.out.println("Duck can't fly.");
            log.info("Duck can't fly.");
        }
    }

    public String getName() {
        return name;
    }

    protected DuckPosition getPosition() {
        return position;
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

    public FillUpEnergyBehavior getEatBehavior() {
        return eatBehavior;
    }

    public FillUpEnergyBehavior getDrinkBehavior() {
        return drinkBehavior;
    }

    public abstract void display();
}
