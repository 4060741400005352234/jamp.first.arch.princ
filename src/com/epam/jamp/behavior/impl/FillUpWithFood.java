package com.epam.jamp.behavior.impl;

import com.epam.jamp.behavior.FillUpEnergyBehavior;
import org.apache.log4j.Logger;

public class FillUpWithFood implements FillUpEnergyBehavior {

    private static Logger log = Logger.getLogger(FillUpWithFood.class);

    @Override
    public void fillUp() {
        //System.out.println("Duck has eaten.");
        log.info("Duck has eaten.");
    }
}
