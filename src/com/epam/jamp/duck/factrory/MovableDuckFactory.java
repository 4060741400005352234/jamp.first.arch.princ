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
        return duckType != null ? duckType.getDuckCreator().createDuck(name) : null;
    }

    private enum DuckType {
        RUBBER_DUCK("1", new RubberDuckCreator()),
        NATURAL_DUCK("2", new NaturalDuckCreator());

        private String duckType;
        private DuckCreator duckCreator;

        private DuckType(String duckType, DuckCreator duckCreator) {
            this.duckType = duckType;
            this.duckCreator = duckCreator;
        }

        public DuckCreator getDuckCreator() {
            return duckCreator;
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
