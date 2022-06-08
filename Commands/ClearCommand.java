package Commands;
import Classes.Organizations;
import Programm.Controller;
import Programm.Inperson;

import java.util.HashMap;
import java.util.Scanner;

/**command clearing the collection*/
public class ClearCommand extends Command {


    public ClearCommand(Controller controller) {
        this.controller = controller;
        setDescription("очистить коллекцию");
        name = "clear";
    }

    @Override
    public void execute(String argument, Scanner scanner) {

    }

    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Inperson inperson, String... args) {
        controller.clear(organizations);
    }

}
