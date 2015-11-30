package com.epam.jamp.behavior.impl;

import com.epam.jamp.behavior.WalkBehavior;

public class Walking implements WalkBehavior {

    @Override
    public void walk() {
        System.out.println("Duck is walking.");
    }
}
