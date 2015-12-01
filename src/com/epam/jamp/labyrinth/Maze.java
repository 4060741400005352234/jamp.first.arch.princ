package com.epam.jamp.labyrinth;

import com.epam.jamp.duck.model.MovableDuck;

public class Maze {

    private int[][] grid = {
            {1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0},
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
            {1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 0, 5, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    private MovableDuck duck;
    private boolean mazeSolved;

    private int stepCount = 0;
    private int iterations = 0;

    public Maze(MovableDuck duck) {
        this.duck = duck;
    }

    public void solveMaze() {
        printMaze();

        if (solve(0, 0))
            System.out.println ("Maze solved!");
        else
            System.out.println ("No solution.");

        printMaze();
        System.out.println("Iterations count = " + iterations);
        System.out.println("Steps count      = " + stepCount);
    }

    private boolean solve(int row, int column) {
        ++iterations;
        if (valid(row, column)) {
            double step = makeStep();
            if (step == 0) {
                fillUpDuck();
            }
            if (grid[row][column] == 5)
                mazeSolved = true;
            else {
                grid[row][column] = 3;
                mazeSolved = solve(row + 1, column);  // down
                if (!mazeSolved)
                    mazeSolved = solve(row, column + 1);  // right
                if (!mazeSolved)
                    mazeSolved = solve(row - 1, column);  // up
                if (!mazeSolved)
                    mazeSolved = solve(row, column - 1);  // left
            }
            if (mazeSolved)
                grid[row][column] = 7;        }
        return mazeSolved;
    }

    private double makeStep() {
        double stepLength = duck.stepForward();
        if (stepLength > 0 && stepLength % 1 != 0) {
            duck.stepForward();
            stepCount += 2;
        } else if (stepLength != 0) {
            stepCount += 1;
        }
        return stepLength;
    }

    private void fillUpDuck() {
        duck.performEat();
    }

    private boolean valid(int row, int column) {
        boolean result = false;
        // check if cell is in the bounds of the matrix
        if (row >= 0 && row < grid.length &&
                column >= 0 && column < grid[0].length)

            //  check if cell is not blocked and not previously tried
            if (grid[row][column] == 1 || grid[row][column] == 5)
                result = true;
        return result;
    }

    public void printMaze() {
        System.out.println();
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++)
                System.out.print(grid[row][column]);
            System.out.println();
        }
        System.out.println();
    }
}
