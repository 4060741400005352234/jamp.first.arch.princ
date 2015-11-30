package com.epam.jamp.duck.model;

import com.epam.jamp.behavior.*;

public abstract class Duck {

    private String name;
    private boolean swimmingNow;
    protected QuackBehavior quackBehavior;
    protected FlapBehavior flapBehavior;
    protected FillUpEnergyBehavior eatBehavior;
    protected FillUpEnergyBehavior drinkBehavior;

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

    public abstract void display();
    public abstract void performSwim();
    public abstract void performWalk();
    public abstract void performFly();
}
