package Programm;

import Classes.*;
import Commands.Command;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Controller {
    Factory factory = new Factory();
    private String arg;
    private ArrayList<String> scripts = new ArrayList<>();


    public void info(Organizations orgs) {
        orgs.getInfo();
    }


    public void show(Organizations orgs) {
        if (orgs.size() > 0) {
            orgs.showIt();
        } else {
            System.out.println("Коллекция пуста");
        }
    }

    public void add(Organizations orgs) {
        orgs.add(factory.create());
        System.out.println("Вы создали новый элемент в коллекцию");
    }

    public void exit() {
        System.out.println("Программа завершена");
        System.exit(0);
    }

    public void head(Organizations orgs) {
        if (orgs.peek() == null) {
            System.out.println("Коллекция пуста");
        } else {
            System.out.println("Верхний элемент коллекции " + orgs.peek());
        }
    }

    public void clear(Organizations organizations) {
        organizations.clear();
        System.out.println("Коллекция очищена");
    }

    public void save(Organizations orgs) {
        String script = "INPUT_PATH";
        String filePath = System.getenv(script);
        if (filePath == null) filePath = "src\\Programm\\data.csv";
        File f = null;
        try {
            f = new File(filePath);
        } catch (NullPointerException e) {
            System.out.println("Файл не найден");
        }
        if (f != null) try {
            orgs.parseToCSV(f);
        } catch (IOException e) {
            System.out.println("Файл недоступен");
        }
    }

    public void execute_script(Inperson inv, Organizations orgs, String... args) throws IllegalStateException, NullPointerException {
        String filePath = "src\\" + args[0];
        System.out.println(filePath);
        if (scripts.contains(filePath)) {
            System.out.println("Произошла рекурсия.");
            return;
        }
        scripts.add(filePath);
        try {
            File f = new File(filePath);
            Scanner scanner = new Scanner(f);
            String line = "";
            while (!line.equals("exit") && scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] lines = line.split("\\s+");
                try {
                    String command = lines[0];
                    if (lines.length > 1) {
                        String arg = lines[1];
                        try {
                            inv.execute(command, orgs, arg);
                        } catch (IllegalStateException e) {
                            Log.error("Вы ввели неправильную команду, попробуйте снова!");
                        }
                    } else {
                        try {
                            inv.execute(command, orgs, arg);
                        } catch (IllegalStateException e) {
                            Log.error("Вы ввели неправильную команду, попробуйте снова!");
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    Log.error("Вы ввели неправильную команду, попробуйте снова");
                }
            }
        } catch (NullPointerException e) {
            Log.error("Скрипт пустой");
        } catch (FileNotFoundException e) {
            Log.error("Файл не найден");
        }
        scripts.remove(filePath);
    }


    public void remove_by_id(Organizations orgs, String... args) {
        if (orgs.size() != 0) {
            try {
                try {
                    int id = Integer.parseInt(args[0]);
                    orgs.removeById(id);
                } catch (NumberFormatException e) {
                    Log.error("неверный формат аргументов ");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                Log.error("Необходим аргумент");
            }
        } else {
            Log.error("Коллекция пуста");
        }

    }

    public void update(Organizations orgs, String... args) throws NumberFormatException {
        try {
            if (args.length > 2) {
                Log.error("Аргумент команды должен быть только один");
            } else {
                if (orgs.size() != 0) {
                    int size = orgs.size();
                    remove_by_id(orgs, args);
                    if (orgs.size() < size) {
                        orgs.add(factory.create(args[0]));
                        Log.info("Изменен элемент с id " + args[0]);
                    }
                } else Log.error("Коллекция пустая");

            }
        } catch (NumberFormatException e) {
            Log.error("Неверный формат аргументов");
        }

    }

    public void remove_head(Organizations orgs, String... args) {
        if (orgs.size() != 0) orgs.remove_head();
        else Log.error("Коллекция пуста");
    }


    public void remove_first(Organizations orgs, String... args) {
        if (orgs != null) orgs.remove_first();
        else Log.error("Коллекция пуста");
    }

    public void help(HashMap<String, Command> commands) {
        for (Map.Entry<String, Command> entry : commands.entrySet()) {
            String key = entry.getKey();
            Command value = entry.getValue();
            Log.info(String.format("%-20s", key) + " " + value.getDescription());
        }
    }

    public void print_of_nationality(Organizations orgs, String[] args) {
        if (orgs.size() != 0) orgs.printOfNationality();
        else Log.error("Коллекция пуста");
    }

    public void count_less_than_location(Organizations orgs, String[] args) {
        if (orgs.size() != 0) orgs.countlessthanlocation();
        else Log.error("Коллекция пуста");
    }


    public void print_unique_eye_color(Organizations orgs, String[] args) {
        if (orgs.size() != 0) orgs.printuniqueeyecolor();
        else Log.error("Коллекция пуста");
    }
}