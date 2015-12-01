package com.epam.jamp.behavior;

public interface MovementBehavior {

    public double stepForward();

    public double stepBack();

    public double stepRight();

    public double stepLeft();

    public void allowNextMovements();
}
