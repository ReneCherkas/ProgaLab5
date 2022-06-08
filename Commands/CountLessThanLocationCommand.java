package Commands;

import Classes.Organizations;
import Programm.Controller;
import Programm.Inperson;

import java.util.HashMap;
import java.util.Scanner;

public class CountLessThanLocationCommand extends  Command{

    public CountLessThanLocationCommand(Controller controller) {
        this.controller = controller;
        setDescription("вывести количество элементов, значение поля location которых меньше заданного");
        name = "count_less_than_location";
    }

    @Override
    public void execute(String argument, Scanner scanner) {

    }

    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Inperson inperson, String... args) {
        controller.count_less_than_location(organizations, args);
    }

}



