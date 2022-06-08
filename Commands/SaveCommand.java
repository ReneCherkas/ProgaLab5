package Commands;
import Classes.Organizations;
import Programm.Controller;
import Programm.Inperson;

import java.util.HashMap;
import java.util.Scanner;

/**command saving changed collection to the file*/
public class SaveCommand extends Command{


    public SaveCommand(Controller controller){
        this.controller = controller;
        setDescription("сохранить коллекцию в файл");
        name = "save";
    }

    @Override
    public void execute(String argument, Scanner scanner) {

    }

    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Inperson inperson, String... args) {
        controller.save(organizations);
    }

}