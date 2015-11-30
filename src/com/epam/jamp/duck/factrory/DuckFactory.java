package com.epam.jamp.duck.factrory;

import com.epam.jamp.duck.model.MovableDuck;

public interface DuckFactory {

    public MovableDuck createDuck(String name, String type);
}
