package com.epam.jamp.maze;

import com.epam.jamp.duck.model.MovableDuck;
import com.epam.jamp.main.Constant;
import org.apache.log4j.Logger;

public class MazeSolver {

    private static Logger log = Logger.getLogger(MazeSolver.class);

    public static final String EXIT_POINT = "X";
    public static final String FREE_WAY_SIGN = "0";
    public static final String INCORRECT_WAY_SIGN = "x";

    private MovableDuck duck;
    private String[][] grid;
    private MazeReader mazeReader;
    private boolean mazeSolved;

    private int stepCount = 0;
    private int iterations = 0;

    public MazeSolver(MovableDuck duck, MazeReader mazeReader) {
        this.duck = duck;
        this.mazeReader = mazeReader;
    }

    public void solveMaze() {
        log.info("Duck " + duck.getName() + " starts solving of maze.");
        grid = mazeReader.read();
        printMaze();
        long start = System.currentTimeMillis();
        if (solve(0, 0, Direction.DOWN)) {
            System.out.println("Maze solved!");
        } else {
            System.out.println("No solution.");
        }
        long end = System.currentTimeMillis() - start;
        printMaze();
        log.info("Finish solving of maze.");
        log.info(duck.getName() + " duck" + " results:");
        log.info("Iterations count = " + iterations);
        log.info("Steps count      = " + stepCount);
        log.info("Total time       = " + end + " ms.");
    }

    private boolean solve(int row, int column, Direction dir) {
        ++iterations;
        if (valid(row, column)) {
            double step = makeStep(dir);
            if (step == 0) {
                fillUpDuck();
            }
            if (EXIT_POINT.equals(grid[row][column]))
                mazeSolved = true;
            else {
                grid[row][column] = INCORRECT_WAY_SIGN;
                mazeSolved = solve(row + 1, column, Direction.DOWN);  // down
                if (!mazeSolved)
                    mazeSolved = solve(row, column + 1, Direction.RIGHT);  // right
                if (!mazeSolved)
                    mazeSolved = solve(row - 1, column, Direction.UP);  // up
                if (!mazeSolved)
                    mazeSolved = solve(row, column - 1, Direction.LEFT);  // left
            }
            if (mazeSolved)
                grid[row][column] = dir.getDirectionSign();
        }
        return mazeSolved;
    }

    private double makeStep(Direction direction) {
        double stepLength = performStep(direction);
        if (stepLength > 0 && stepLength % 1 != 0) {
            performStep(direction);
            stepCount += 2;
        } else if (stepLength != 0) {
            stepCount += 1;
        }
        return stepLength;
    }

    private double performStep(Direction direction) {
        double stepLength = 0;
        switch (direction) {
            case UP:
                stepLength = duck.stepBack();
                break;
            case DOWN:
                stepLength = duck.stepForward();
                break;
            case LEFT:
                stepLength = duck.stepLeft();
                break;
            case RIGHT:
                stepLength = duck.stepRight();
                break;
        }
        return stepLength;
    }

    private void fillUpDuck() {
        duck.performEat();
    }

    private boolean valid(int row, int column) {
        boolean result = false;
        if (row >= 0 && row < grid.length &&  column >= 0 && column < grid[0].length)
            if (FREE_WAY_SIGN.equals(grid[row][column]) || EXIT_POINT.equals(grid[row][column]))
                result = true;
        return result;
    }

    public void printMaze() {
        System.out.println();
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++)
                System.out.print(Constant.SPACE + grid[row][column] + Constant.SPACE);
            System.out.println();
        }
        System.out.println();
    }

    private enum Direction {
        UP("^"),
        DOWN("v"),
        RIGHT(">"),
        LEFT("<");

        private String directionSign;

        private Direction(String directionSign) {
            this.directionSign = directionSign;
        }

        public String getDirectionSign() {
            return directionSign;
        }
    }
}
