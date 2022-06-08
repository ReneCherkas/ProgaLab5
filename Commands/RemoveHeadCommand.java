package Commands;

import Classes.Organizations;
import Programm.Controller;
import Programm.Inperson;

import java.util.HashMap;
import java.util.Scanner;


public class RemoveHeadCommand extends  Command {

    public RemoveHeadCommand(Controller controller) {
        this.controller = controller;
        setDescription(" {element} удалить из коллекции все элементы, превышающие главного");
        name = "remove_head";
    }

    @Override
    public void execute(String argument, Scanner scanner) {

    }

    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Inperson inperson, String... args) {
        controller.remove_head(organizations, args);
    }


}
