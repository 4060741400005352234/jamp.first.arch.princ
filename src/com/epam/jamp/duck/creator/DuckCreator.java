package com.epam.jamp.duck.creator;

import com.epam.jamp.duck.model.MovableDuck;

public abstract class DuckCreator {

    public MovableDuck createDuck(final String name) {
        MovableDuck duck = create(name);
        provideDuckWithBehavior(duck);
        return duck;
    }

    protected abstract MovableDuck create(final String name);

    protected abstract void provideDuckWithBehavior(final MovableDuck duck);
}
