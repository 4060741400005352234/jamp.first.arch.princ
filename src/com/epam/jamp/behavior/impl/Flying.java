package com.epam.jamp.behavior.impl;

import com.epam.jamp.behavior.FlyBehavior;

public class Flying implements FlyBehavior {


    @Override
    public void fly() {
        System.out.println("Duck is flying.");
    }
}
