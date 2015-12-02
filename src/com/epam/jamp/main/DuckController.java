package com.epam.jamp.main;

import com.epam.jamp.duck.model.MovableDuck;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DuckController {

    private static Logger log = Logger.getLogger(DuckController.class);

    private MovableDuck duck;
    private BufferedReader bufferedReader;

    public DuckController(MovableDuck duck, BufferedReader bufferedReader) {
        this.duck = duck;
        this.bufferedReader = bufferedReader;
    }

    public void performControl() {
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            controlDuck();
            System.out.println(bufferedReader.ready());
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

    public void controlDuck() throws IOException {
        showCommandMenu();
        String command;
        while ((command = bufferedReader.readLine()) != null && command.length() != 0) {
            if (Constant.EXIT_COMMAND.equalsIgnoreCase(command.trim())) {
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
            case EXIT:
                System.exit(1);
                break;
        }
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
        FLAP_WITH_WINGS("10", "Flap with wings"),
        EXIT("11", "Exit");

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