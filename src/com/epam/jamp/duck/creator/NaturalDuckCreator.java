package com.epam.jamp.duck.creator;

import com.epam.jamp.behavior.impl.*;
import com.epam.jamp.duck.model.MovableDuck;
import com.epam.jamp.duck.model.NaturalDuck;

public class NaturalDuckCreator extends DuckCreator {

    @Override
    protected MovableDuck create(String name) {
        return new NaturalDuck(name);
    }

    @Override
    protected void provideDuckWithBehavior(MovableDuck duck) {
        duck.setEatBehavior(new FillUpWithFood());
        duck.setDrinkBehavior(new FillUpWithWater());
        duck.setFlapBehavior(new Flapping());
        duck.setQuackBehavior(new Quack());
        duck.setSwimBehavior(new Swimming());
        duck.setWalkBehavior(new Walking());
        duck.setFlyBehavior(new Flying());
    }
}
