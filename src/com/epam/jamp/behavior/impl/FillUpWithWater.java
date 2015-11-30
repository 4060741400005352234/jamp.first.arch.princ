package com.epam.jamp.behavior.impl;

import com.epam.jamp.behavior.FillUpEnergyBehavior;
import org.apache.log4j.Logger;

public class FillUpWithWater implements FillUpEnergyBehavior {

    private static Logger log = Logger.getLogger(FillUpWithWater.class);

    @Override
    public void fillUp() {
        //System.out.println("Duck has drunk.");
        log.info("Duck has drunk.");
    }
}
