package com.epam.jamp.duck.factrory;

import com.epam.jamp.duck.model.Duck;

public interface DuckFactory {

    public Duck createDuck(String name, String type);
}
