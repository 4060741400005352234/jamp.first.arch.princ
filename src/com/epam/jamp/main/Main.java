package com.epam.jamp.main;

import com.epam.jamp.duck.factrory.MovableDuckFactory;
import com.epam.jamp.labyrinth.LabyrinthReader;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {

//        String[][] labyrinth = LabyrinthReader.readFromFile("lab.txt");
//        System.out.println(Arrays.deepToString(labyrinth));

        DuckController duckController = new DuckController(new MovableDuckFactory());
        duckController.performControl();

    }
}
