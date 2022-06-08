package Commands;
import Classes.Organizations;
import Programm.Controller;
import Programm.Inperson;


import java.util.HashMap;
import java.util.Scanner;

/**command printing all of the commands with those descriptions*/
public class HelpCommand extends Command {

    public HelpCommand (Controller controller){
        setDescription("вывести справку по доступным командам");
        this.controller=controller;
        name = "help";
    }


    @Override
    public void execute(String argument, Scanner scanner) {
    }

    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Inperson inperson, String... args) {
        controller.help(commands);
    }
}
