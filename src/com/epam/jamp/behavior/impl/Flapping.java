package com.epam.jamp.behavior.impl;

import com.epam.jamp.behavior.FlapBehavior;
import org.apache.log4j.Logger;

public class Flapping implements FlapBehavior {

    private static Logger log = Logger.getLogger(Flapping.class);

    @Override
    public void flap() {
        //System.out.println("I'm flapping.");
        log.info("Duck is flapping.");
    }
}
