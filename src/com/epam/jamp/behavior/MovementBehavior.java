package com.epam.jamp.behavior;

public interface MovementBehavior {

    public void stepForward();

    public void stepBack();

    public void stepRight();

    public void stepLeft();

    public void allowNextMovements();
}
