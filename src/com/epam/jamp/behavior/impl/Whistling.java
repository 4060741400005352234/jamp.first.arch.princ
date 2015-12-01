package com.epam.jamp.behavior.impl;

import com.epam.jamp.behavior.QuackBehavior;
import org.apache.log4j.Logger;

public class Whistling implements QuackBehavior {

    private static Logger log = Logger.getLogger(Whistling.class);

    @Override
    public void quack() {
        //System.out.println("Duck is whistling 5 times.");
        log.info(" Duck is whistling 5 times.");
    }
}
