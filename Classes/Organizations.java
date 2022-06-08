package Classes;

import Programm.Factory;
import Programm.Log;
import com.sun.istack.internal.NotNull;

import java.io.*;
import java.util.*;


public class Organizations extends PriorityQueue<Organization>{
    Factory factory = new Factory();

    public Organizations() {
    }

    public void getInfo(){
        Log.info("Тип коллекции: ArrayDeque");
        Log.info("Количество элементов в коллекции: "+ this.size());
        String Date = "07.06.2022";
        Log.info("Дата инициализации: "+Date);

    }

    public void showIt(){
        for (Organization o: this){
            Log.info(o.toString());
        }
    }

    public void removeById(int args) {
        int id = Integer.parseInt(String.valueOf(args));
        boolean found = false;
        for (Organization org : this){
            if (org.getId() == id){
                this.remove(org);
                found = true;
                break;
            }
        }
        if (!found) {Log.error("Не найдено элемента с таким id");}
    }

    @NotNull
    public void parseToCSV(File f) throws IOException {
        File file = f;
        if (file.canRead()&file.canWrite()&file.exists()&file.isFile()){
            FileWriter eraser = new FileWriter(file, false);
            eraser.write("");
            for (Organization o: this) {
                try(FileWriter writer = new FileWriter(file, true))
                {
                    writer.write(o.parse()+",\n");
                    writer.flush();
                }
                catch(IOException ex){
                    Log.error(ex.getMessage());
                }
                Log.info("Cохранено в файл "+f.getName());

            }}
        else {
            if ((file.canWrite() == false) | (file.canRead() == false)) {
                Log.error("Проблема с правами доступа к файлу");
            }else {
                if (file.exists() == false) {
                    Log.error("Файл не существует");
                } else {
                    if (file.isFile()) {
                        Log.error("Вероятно, Ваш файл - директория");
                    }
                }
            }
        }

    }

    public void remove_head() {
        Log.info(this.peek());
        if (super.size() != 0) this.remove(this.peek());
        else Log.error("Коллекция пуста");
    }

    public void countlessthanlocation() {
        try {
            Log.info("Введите координату локации:");
            Scanner in = new Scanner(System.in);
            int printed = 0;
            int loc = Integer.parseInt(in.nextLine());
            for (Organization org : this) {
                if (loc > org.getlocal()) {
                    printed += 1;
                    Log.info(org);
                } else {
                }
            }
            if (printed == 0) {
                Log.error("Массив на содержит значений меньше заданного.");
            }
        }catch (NumberFormatException e){
            Log.error("Вы не ввели число. Выберите команду еще раз.");
        }
    }

    public void remove_first() {
        if (super.size() != 0) this.remove(this.peek());
        else Log.error("Коллекция пуста");
    }

    public void printOfNationality() {
        int count = 0;
        ArrayList list = new ArrayList();
        for (Organization org : this) {
            if (count <= super.size()) {
                    list.add(org.getCountry());
                    count +=1;
                }
            }
        Collections.sort(list);
        Log.info(list);

        }

    public void printuniqueeyecolor() {
        int count = 0;
        ArrayList list1 = new ArrayList();
        for (Organization org : this) {
            if (count <= super.size()) {
                list1.add(org.getEyecolor());
                count +=1;
            }
        }
        Collections.sort(list1);
        Log.info(list1);
    }
}
