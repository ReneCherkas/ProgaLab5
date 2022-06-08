package Commands;
import Classes.Organizations;
import Programm.Controller;
import Programm.Inperson;

import java.util.HashMap;
import java.util.Scanner;

/**command executing script of commands*/
public class ExecuteScriptCommand extends Command {

    public ExecuteScriptCommand(Controller controller) {
        this.controller = controller;
        setDescription("считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.") ;
        name = "execute_script";}

    @Override
    public void execute(String argument, Scanner scanner) {

    }

    @Override
    public void execute(HashMap<String, Command> commands, Organizations organizations, Inperson inperson, String... args) {
        controller.execute_script(inperson, organizations, args);
    }

}
