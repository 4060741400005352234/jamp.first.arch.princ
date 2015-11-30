package com.epam.jamp.main;

import com.epam.jamp.duck.factrory.DuckFactory;
import com.epam.jamp.duck.model.MovableDuck;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;

// TODO devide this calss and rename
public class DuckController {

    public static final String EXIT_COMMAND = "EXIT";
    public static final String EMPTY_STRING = "";

    private static Logger log = Logger.getLogger(DuckController.class);

    private DuckFactory duckFactory;
    private MovableDuck duck;
    private BufferedReader bufferedReader;

    public DuckController(BufferedReader bufferedReader, DuckFactory duckFactory) {
        this.bufferedReader = bufferedReader;
        this.duckFactory = duckFactory;
    }

    public void performControl() {
        try {
            String duckName = getDuckName();
            String duckType = getDucType();
            duck = createDuck(duckName, duckType);
            duck.display();

            controlDuck();

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

    private String getDuckName() throws IOException {
        String name = null;
        while (name == null) {
            System.out.println("Enter duck name:");
            name = readDataFromConsole();
        }
        return name;
    }

    private String getDucType() throws IOException {
        System.out.println("Choice duck type:");
        System.out.println("1 - Rubber duck");
        System.out.println("2 - Natural duck");
        String duckType = null;
        while (duckType == null) {
            duckType = readDataFromConsole();
        }
        return duckType;
    }

    private MovableDuck createDuck(String name, String type) {
        return duckFactory.createDuck(name, type);
    }

    public void controlDuck() throws IOException {
        showCommandMenu();
        String command;
        while ((command = bufferedReader.readLine()) != null && command.length() != 0) {
            if (EXIT_COMMAND.equalsIgnoreCase(command.trim())) {
                System.exit(1);
            }
            performCommand(command);
        }
    }

    private void performCommand(String command) {
        DuckCommand duckCommand = DuckCommand.resolveCommand(command);
        if (duckCommand == null) {
            return;
        }
        switch (duckCommand) {
            case GO_FORWARD:
                duck.stepForward();
                break;
            case GO_BACK:
                duck.stepBack();
                break;
            case GO_LEFT:
                duck.stepLeft();
                break;
            case GOR_RIGHT:
                duck.stepRight();
                break;
            case DRINK:
                duck.performDrink();
                break;
            case EAT:
                duck.performEat();
                break;
            case FLY:
                duck.performFly();
                break;
            case SWIM:
                duck.performSwim();
                break;
            case WALK:
                duck.performWalk();
                break;
            case FLAP_WITH_WINGS:
                duck.performFlap();
                break;
        }
    }

    private String readDataFromConsole() throws IOException {
        String command;
        do {
            command = bufferedReader.readLine();
        } while (command == null || EMPTY_STRING.equalsIgnoreCase(command));
        return command;
    }

    private void showCommandMenu() {
        System.out.println("Choice command for your duck:");
        for (DuckCommand command : DuckCommand.values()) {
            System.out.println(command.commandNumber + " - " + command.commandDescription);
        }
    }

    private enum DuckCommand {
        GO_FORWARD("1", "Go forward"),
        GO_BACK("2", "Go back"),
        GO_LEFT("3", "Go left"),
        GOR_RIGHT("4", "Go right"),
        FLY("5", "Fly"),
        SWIM("6", "Swim"),
        WALK("7", "Walk"),
        DRINK("8", "Drink"),
        EAT("9", "Eat"),
        FLAP_WITH_WINGS("10", "Flap with wings");

        private String commandNumber;
        private String commandDescription;

        private DuckCommand(String commandNumber, String commandDescription) {
            this.commandNumber = commandNumber;
            this.commandDescription = commandDescription;
        }

        public static DuckCommand resolveCommand(String command) {
            for (DuckCommand type : DuckCommand.values()) {
                if (type.commandNumber.equals(command.trim())) {
                    return type;
                }
            }
            return null;
        }
    }
}