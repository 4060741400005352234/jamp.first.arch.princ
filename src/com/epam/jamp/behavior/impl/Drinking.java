package com.epam.jamp.behavior.impl;

import com.epam.jamp.behavior.DrinkBehavior;
import org.apache.log4j.Logger;

public class Drinking implements DrinkBehavior {

    private static Logger log = Logger.getLogger(Drinking.class);

    @Override
    public void drink() {
        //System.out.println("Duck's drinking now.");
        log.info("Duck's drinking now.");
    }
}
