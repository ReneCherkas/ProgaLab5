package Commands;

import Classes.*;
import Programm.*;

import java.util.HashMap;
import java.util.Scanner;

public class AddCommand extends Command {

    public AddCommand(Controller controller){
        this.controller = controller;
        setDescription("добавить новый элемент в коллекцию");
        name = "add";
    }

    @Override
    public void execute(String argument, Scanner scanner) {

    }

    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Inperson inperson, String... args) {
        controller.add(organizations);
    }

}
