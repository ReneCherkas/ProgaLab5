package Programm;

import Classes.Organizations;

import java.io.File;
import java.io.IOException;

public class Main {
    static String path;

    public static void main(String[] args) {
        File file = null;
        Log.info("Введите имя файла");
        try {
            String filePath = args[0];
            CommandRegister app = new CommandRegister();
            Organizations orgs = new Organizations();
            Log.info(filePath);
            if (filePath.equals("data.csv")){
                setPath("src\\Programm\\"+filePath);
                Log.info("Начните вводить команды");
            }else{
                setPath(filePath);
            }
            try {
                file = new File(getPath());
                if (!file.canRead()){
                    System.out.println("Недостаточно прав для чтения файла c данными.");
                    System.out.println("Введите exit, чтобы завершить программу, или продолжите с пустой коллекцией.");
                } else {
                    CSVParser c = new CSVParser(getPath());
                    c.parse(orgs);
                }
            }catch (NullPointerException | IOException e){
                System.out.println("Файл не найден. Невозможно запустить программу.");
                app.controller1.exit();}
            while (true){
                app.execute(orgs, file);
            }
        }catch (ArrayIndexOutOfBoundsException e){
            Log.error("Не введен аргумент");
            Log.error("программа завершена");
            System.exit(0);

         }
    }
    public static void setPath(String path) {
        Main.path = path;
    }

    public static String getPath() throws NullPointerException {
        try {
            return
                    path;
        } catch (NullPointerException e) {
            System.out.println("Не удалось распознать путь до файла");
            return null;
        }
    }

}
