package Commands;

import Classes.*;
import Programm.Controller;
import Programm.Inperson;

import java.util.HashMap;
import java.util.Scanner;

public class PrintFiledAscendingNationalityCommand extends Command{

    public PrintFiledAscendingNationalityCommand(Controller controller){
    this.controller = controller;
    name = "print_filed_ascending_nationality";
    setDescription("вывести значения поля nationality всех элементов в порядке возрастания");
}

    @Override
    public void execute(String argument, Scanner scanner) {
    }

    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Inperson inperson, String... args) {
        controller.print_of_nationality(organizations, args);
    }
}