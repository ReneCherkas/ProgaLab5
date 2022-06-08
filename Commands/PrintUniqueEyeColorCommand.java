package Commands;

import Classes.Organizations;
import Programm.Controller;
import Programm.Inperson;

import java.util.HashMap;
import java.util.Scanner;

public class PrintUniqueEyeColorCommand extends Command {
    public PrintUniqueEyeColorCommand(Controller controller) {
        this.controller = controller;
        setDescription("вывести уникальные значения поля eyeColor всех элементов в коллекции");
        name = "print_unique_eye_color";
    }

    @Override
    public void execute(String argument, Scanner scanner) {

    }

    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Inperson inperson, String... args) {
        controller.print_unique_eye_color(organizations, args);
    }

}
