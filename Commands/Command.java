package Commands;

import Classes.*;
import Programm.*;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Command {
    public String name;
    public String args;
    public String description;
    public Controller controller = new Controller();

    /**
     * executing command
     * @param commands collection of possible commands
     * @param organizations collection of elements
     * @param inperson inperson
     * @param args arguments
     */

    public void execute(ArrayDeque<String> commands, Organizations organizations, Inperson inperson, String args){
        execute(commands, organizations, inperson, args);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

    public abstract void execute(String argument, Scanner scanner);

    public abstract void execute(HashMap<String, Command> commands, Organizations organizations, Inperson inperson, String... args);
}
