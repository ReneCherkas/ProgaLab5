package Commands;

import Classes.Organizations;
import Programm.Controller;
import Programm.Inperson;

import java.util.HashMap;
import java.util.Scanner;

public class RemoveFirstCommand extends  Command{

    public RemoveFirstCommand (Controller controller) {
        this.controller = controller;
        setDescription(" {element} удалить из коллекции первый элемент");
        name = "remove_first";
    }

    @Override
    public void execute(String argument, Scanner scanner) {

    }

    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Inperson inperson, String... args) {
        controller.remove_first(organizations, args);
    }

}
