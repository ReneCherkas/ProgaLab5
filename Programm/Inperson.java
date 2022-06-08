package Programm;

import Classes.Organizations;
import Commands.*;
import com.sun.istack.internal.NotNull;

import java.util.HashMap;

public class Inperson {
    private HashMap<String, Command> commands = new HashMap<>();

    /**
     *  uploading elements into HashMap
     */

    public Inperson(@NotNull Command... com){
        for (Command comm : com){
            register(comm.getName(), comm);
        }
    }

    /**adding command to the list*/
    public void register(String commandName, Command command) {
        commands.put(commandName, command);
    }

    /**
     * Executing invoker
     * @param commandName the name of the command
     * @param orgs collection
     * @param args arguments
     */
    public void execute(String commandName, Organizations orgs, String... args){
        Command command = commands.get(commandName);
        if (command == null) {
            throw new IllegalStateException("Не найдено такой команды " + commandName);
        }
        command.execute(commands, orgs, this, args);
    }


    public HashMap<String, Command> getCommands() {
        return commands;
    }
}