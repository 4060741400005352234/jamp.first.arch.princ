package com.epam.jamp.behavior.impl;

import com.epam.jamp.behavior.SwimBehavior;

public class Swimming implements SwimBehavior {


    @Override
    public void swim() {
        System.out.println("Duck is swimming;");
    }
}
