package com.epam.jamp.labyrinth;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LabyrinthReader {

    public static String[][] readFromFile(String fileName) {
        List<String[]> list = new ArrayList<String[]>();
        String[][] labyrinth;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while ((s = bufferedReader.readLine()) != null) {
                    String[] row = s.split(" ");
                    list.add(row);
                }
                labyrinth = new String[list.size()][];
                for (int i = 0; i < list.size(); ++i) {
                    labyrinth[i] = list.get(i);
                }
            } finally {
                bufferedReader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return labyrinth;
    }
}
