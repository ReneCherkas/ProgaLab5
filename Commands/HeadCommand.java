package Commands;
import Classes.Organizations;
import Programm.Controller;
import Programm.Inperson;

import java.util.HashMap;
import java.util.Scanner;

/**command printing the first one element of the collection*/
public class HeadCommand extends Command {

    public HeadCommand(Controller controller) {
        this.controller = controller;
        setDescription("вывести первый элемент коллекции");
        name = "head";
    }

    @Override
    public void execute(String argument, Scanner scanner) {

    }

    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Inperson inperson, String... args) {
        controller.head(organizations);
    }
}
