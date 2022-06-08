package Commands;
import Classes.Organizations;
import Programm.Controller;
import Programm.Inperson;

import java.util.HashMap;
import java.util.Scanner;

/**command printing the collection*/
public class ShowCommand extends Command {


    public ShowCommand(Controller controller) {
        this.controller = controller;
        setDescription("вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        name = "show";
    }

    @Override
    public void execute(String argument, Scanner scanner) {

    }

    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Inperson inperson, String... args) {
        controller.show(organizations);
    }

}
