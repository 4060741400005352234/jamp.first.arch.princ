package com.epam.jamp.behavior.impl;

import com.epam.jamp.behavior.QuackBehavior;
import org.apache.log4j.Logger;

public class Quack implements QuackBehavior {

    private static Logger log = Logger.getLogger(Quack.class);

    @Override
    public void quack() {
        //System.out.println("I'm quacking.");
        log.info(" Duck is quacking.");
    }
}
