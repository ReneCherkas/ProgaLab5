package Programm;

import Classes.Organizations;
import Commands.*;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CommandRegister {
    Inperson inperson;
    Controller controller1 = new Controller();

    public CommandRegister() {
        Command help = new HelpCommand(controller1);
        Command info = new InfoCommand(controller1);
        Command show = new ShowCommand(controller1);
        Command add = new AddCommand(controller1);
        Command update_id = new UpdateId(controller1);
        Command remove_by_id = new RemoveByIdCommand(controller1);
        Command clear = new ClearCommand(controller1);
        Command save = new SaveCommand(controller1);
        Command execute = new ExecuteScriptCommand(controller1);
        Command exit = new ExitCommand(controller1);
        Command remove_first = new RemoveFirstCommand(controller1);
        Command head = new HeadCommand(controller1);
        Command remove_head = new RemoveHeadCommand(controller1);
        Command count_less_than_location = new CountLessThanLocationCommand(controller1);
        Command print_unique_eye_color = new PrintUniqueEyeColorCommand(controller1);
        Command print_field_ascending_nationality = new PrintFiledAscendingNationalityCommand(controller1);

        this.inperson = new Inperson(help, info, show, add, update_id, remove_first, remove_by_id, remove_head, clear, save, execute, exit, head, count_less_than_location, print_field_ascending_nationality, print_unique_eye_color);
    }

    Scanner sc = new Scanner(System.in);

    /**
     * method dividing string into parts of executable command
     *
     * @param org  Collection of elements
     * @param file
     */

    public void execute(Organizations org, File file) {
        String line = null;
        try {
            line = sc.nextLine().toLowerCase().trim();
        } catch (NoSuchElementException ex) {
            Log.error("Завершение программы");
            System.exit(0);
        }
        if (!line.equals("")) {
            String[] lines = line.split("\\s+");
            if (lines.length > 1) {
                try {
                    String command = lines[0];
                    String arg = lines[1];
                    inperson.execute(command, org, arg);
                } catch (IllegalStateException e) {
                    Log.error(e.getMessage());
                }
            } else if (lines.length == 1) {
                try {
                    String command = lines[0];
                    inperson.execute(command, org);
                } catch (IllegalStateException e) {
                    Log.error(e.getMessage());
                }
            } else {
                Log.error("Введены неправильные аргументы!");
            }
        }
    }


}
