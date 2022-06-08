package Commands;

import Classes.Organizations;
import Programm.Controller;
import Programm.Inperson;

import java.util.HashMap;
import java.util.Scanner;

/**elements deleting element with the given id*/
public class RemoveByIdCommand extends Command {


    public RemoveByIdCommand (Controller controller){
        setDescription("удалить элемент с id равным заданному");
        this.controller=controller;
        name = "remove_by_id";
    }


    @Override
    public void execute(String argument, Scanner scanner) {

    }

    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Inperson inperson, String... args) {
        controller.remove_by_id(organizations, args);
    }

}
