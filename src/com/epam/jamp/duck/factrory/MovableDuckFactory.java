package com.epam.jamp.duck.factrory;

import com.epam.jamp.duck.creator.DuckCreator;
import com.epam.jamp.duck.creator.NaturalDuckCreator;
import com.epam.jamp.duck.creator.RubberDuckCreator;
import com.epam.jamp.duck.model.Duck;
import com.epam.jamp.duck.model.MovableDuck;

public class MovableDuckFactory implements DuckFactory {

    private DuckCreator creator;

    @Override
    public MovableDuck createDuck(String name, String type) {
        DuckType duckType = DuckType.resolveType(type);
        switch (duckType) {
            case NATURAL_DUCK:
                creator = new NaturalDuckCreator();
                break;
            case RUBBER_DUCK:
                creator = new RubberDuckCreator();
                break;
        }
        return creator.createDuck(name);
    }

    private enum DuckType {
        RUBBER_DUCK("1"),
        NATURAL_DUCK("2");

        private String duckType;

        private DuckType(String duckType) {
            this.duckType = duckType;
        }

        public static DuckType resolveType(String duckType) {
            for (DuckType type : DuckType.values()) {
                if (type.duckType.equals(duckType.trim())) {
                    return type;
                }
            }
            System.out.println("Can't resolve duck type.");
            throw new IllegalArgumentException("Unknown duck type.");
        }
    }
}
