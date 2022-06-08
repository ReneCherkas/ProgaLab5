package Commands;

import Classes.Organizations;
import Programm.Controller;
import Programm.Inperson;

import java.util.HashMap;
import java.util.Scanner;

/**exit command*/
public class ExitCommand extends Command {


    public ExitCommand(Controller controller) {
        this.controller = controller;
        setDescription("завершить программу (без сохранения в файл)");
        name = "exit";
    }

    @Override
    public void execute(String argument, Scanner scanner) {

    }

    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Inperson inperson, String... args) {
        controller.exit();
    }

}
