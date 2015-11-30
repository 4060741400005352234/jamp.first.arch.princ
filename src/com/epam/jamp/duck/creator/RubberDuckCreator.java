package com.epam.jamp.duck.creator;

import com.epam.jamp.behavior.impl.FillUpWithBattery;
import com.epam.jamp.behavior.impl.Flapping;
import com.epam.jamp.behavior.impl.Whistling;
import com.epam.jamp.duck.model.MovableDuck;
import com.epam.jamp.duck.model.RubberDuck;

public class RubberDuckCreator extends DuckCreator {

    @Override
    protected MovableDuck create(final String name) {
        return new RubberDuck(name);
    }

    @Override
    protected void provideDuckWithBehavior(final MovableDuck duck) {
        duck.setFlapBehavior(new Flapping());
        duck.setQuackBehavior(new Whistling());
        duck.setEatBehavior(new FillUpWithBattery());
    }
}
