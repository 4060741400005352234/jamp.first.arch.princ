package com.epam.jamp.maze;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileMazeReader implements MazeReader {

    private String filePath;

    public FileMazeReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String[][] read() {
        List<String[]> list = new ArrayList<String[]>();
        String[][] maze;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath).getAbsoluteFile()));
            try {
                String s;
                while ((s = bufferedReader.readLine()) != null) {
                    String[] row = s.split(" ");
                    list.add(row);
                }
                maze = new String[list.size()][];
                for (int i = 0; i < list.size(); ++i) {
                    maze[i] = list.get(i);
                }
            } finally {
                bufferedReader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return maze;
    }
}
