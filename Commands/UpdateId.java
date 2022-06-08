package Commands;

import Classes.Organizations;
import Programm.Controller;
import Programm.Inperson;

import java.util.HashMap;
import java.util.Scanner;

/**command changing element with given id*/
public class UpdateId extends Command {


    public UpdateId(Controller controller) {
        this.controller = controller;
        setDescription(" id {Element} обновить значение элемента коллекции, id которого равен заданному");
        name = "update";
    }

    @Override
    public void execute(String argument, Scanner scanner) {

    }

    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Inperson inperson, String... args) {
        controller.update(organizations, args);
    }
}