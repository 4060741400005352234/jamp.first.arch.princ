package com.epam.jamp.main;

import com.epam.jamp.duck.factrory.MovableDuckFactory;
import com.epam.jamp.duck.model.MovableDuck;
import com.epam.jamp.maze.FileMazeReader;
import com.epam.jamp.maze.MazeSolver;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static Logger log = Logger.getLogger(Main.class);
    private static BufferedReader bufferedReader;

    public static void main(String[] args) {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            MovableDuck duck = createDuck();

            MazeSolver mazeSolver = new MazeSolver(duck, new FileMazeReader("lab.txt"));
            mazeSolver.solveMaze();

//            DuckController duckController = new DuckController(duck, bufferedReader);
//            duckController.performControl();
        } catch (Exception e) {
            log.error(e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                log.error(e);
            }
        }
    }

    private static MovableDuck createDuck() throws IOException {
        String duckName = getDuckName();
        String duckType = getDucType();
        MovableDuck duck = createDuck(duckName, duckType);
        duck.display();
        return duck;
    }

    public static String getDuckName() throws IOException {
        String name = null;
        while (name == null) {
            System.out.println("Enter duck name:");
            name = readDataFromConsole();
        }
        return name;
    }

    public static String getDucType() throws IOException {
        System.out.println("Choice duck type:");
        System.out.println("1 - Rubber duck");
        System.out.println("2 - Natural duck");
        String duckType = null;
        while (duckType == null) {
            duckType = readDataFromConsole();
        }
        return duckType;
    }

    private static String readDataFromConsole() throws IOException {
        String command;
        do {
            command = bufferedReader.readLine();
        } while (command == null || Constant.EMPTY_STRING.equalsIgnoreCase(command));
        return command;
    }

    private static MovableDuck createDuck(String name, String type) {
        return new MovableDuckFactory().createDuck(name, type);
    }
}
