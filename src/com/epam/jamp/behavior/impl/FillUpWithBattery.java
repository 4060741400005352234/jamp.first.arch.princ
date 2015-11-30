package com.epam.jamp.behavior.impl;

import com.epam.jamp.behavior.FillUpEnergyBehavior;
import org.apache.log4j.Logger;

public class FillUpWithBattery implements FillUpEnergyBehavior {

    private static Logger log = Logger.getLogger(FillUpWithBattery.class);

    @Override
    public void fillUp() {
        //System.out.println("Batteries are changed.");
        log.info("Duck's batteries are changed.");
    }
}
