package Programm;

import Classes.*;
import java.time.ZonedDateTime;
import java.util.*;

public class Factory {
    private Integer id;
    private String name;
    private Coordinates coordinates;
    private java.time.ZonedDateTime creationDate;
    private Long height;
    private EyeColor eyecolor;
    private HairColor haircolor;
    private Country nationality;
    private float local;
    private Float locY;
    private long coordX;
    private float coordY;
    private float locZ;
    private String town;
    Scanner scanner = new Scanner(System.in);
    private EyeColor type;
    private HairColor type1;
    private Country type2;

    /**
     * Creating an element of the collection
     * @param idarg given id
     * @return
     */
    public Organization create(String idarg) throws InputMismatchException{
        try{id = Integer.parseInt(idarg);
            creationDate = ZonedDateTime.now();
            Log.info("введите имя: ");
            setName();
            Log.info("введите координаты: ");
            setCoordinates();
            Log.info("введите рост: ");
            setHeight();
            Log.info("введите цвет глаз: ");
            setEyeColor();
            Log.info("введите цвет волос: ");
            setHairColor();
            Log.info("введите национальность: ");
            setNationality();
            Log.info("введите город в котором находитесь: ");
            setTown();
            Log.info("введите город в котором находитесь: ");
            setLocal();
            Organization org = new Organization(id, name, coordinates, creationDate, height, eyecolor, haircolor, nationality, town, (int) local);

            return org;
        }
        catch (InputMismatchException e){Log.error("Вы ввели данные в неверном формате. Попробуйте заново");
            create(idarg);
            return null;}

    }
    public Organization create() throws InputMismatchException{
         Organization org = null;
        try{ id = UUID.randomUUID().toString().hashCode();
            while (id<0) {id = UUID.randomUUID().toString().hashCode();}
            creationDate = ZonedDateTime.now();
            Log.info("введите имя: ");
            setName();
            Log.info("введите координаты: ");
            setCoordinates();
            Log.info("введите рост: ");
            setHeight();
            Log.info("введите цвет глаз: ");
            setEyeColor();
            Log.info("введите цвет волос: ");
            setHairColor();
            Log.info("введите национальность: ");
            setNationality();
            Log.info("введите город в котором находитесь: ");
            setTown();
            Log.info("введите координату города в котором находитесь: ");
            setLocal();
            org = new Organization(id, name, coordinates, creationDate, height, eyecolor, haircolor, nationality, town, (int) local);
            return org;}
        catch (InputMismatchException e){
            Log.error("Вы ввели данные в неверном формате");
            create();
            return org;
        }
    }

    private void setHeight() {
        if (scanner.hasNextLine())
        {String line = scanner.nextLine();
            try {
                height = Long.parseLong(line);
                if (height<1){ Log.error("Рост не может быть меньше 0");
                    setHeight();}
            } catch (NumberFormatException e) {
                Log.error("Вы ввели не корректное число, попробуйте снова!");
                setHeight();
            }
        }else{
            Log.info("Программа завершена");
            System.exit(0);}
    }

    private void setEyeColor() {
        Log.info("Введите один из возможных типов:");
        Log.info("GREEN");
        Log.info("BLACK");
        Log.info("ORANGE");
        if (scanner.hasNextLine()){
        String line = scanner.nextLine().toLowerCase();
        switch (line) {
            case ("green"):
                eyecolor = EyeColor.GREEN;
                break;
            case ("black"):
                eyecolor = EyeColor.BLACK;
                break;
            case ("orange"):
                eyecolor = EyeColor.ORANGE;
                break;
            default:
                Log.error("Вы ввели не корректный тип! Попробуйте снова!");
                setEyeColor();
                break;
        }}
        else{
            Log.info("Программа завершена");
        System.exit(0);}
    }


    private void setHairColor() {
        Log.info("Введите один из возможных типов:");
        Log.info("RED");
        Log.info("BLACK");
        Log.info("YELLOW");
        Log.info("BROWN");
        if (scanner.hasNextLine()){
        String line = scanner.nextLine().toLowerCase();
        switch (line) {
            case ("red"):
                haircolor = HairColor.RED;
                break;
            case ("black"):
                haircolor = HairColor.BLACK;
                break;
            case ("yellow"):
                haircolor = HairColor.YELLOW;
                break;
            case ("brown"):
                haircolor = HairColor.BROWN;
                break;
            default:
                Log.error("Вы ввели неккоректный тип! Попробуйте снова!");
                setNationality();
                break;
        }}
        else{
            Log.error("Программа завершена");
            System.exit(0);}
        }

    private void setNationality() {
        Log.info("Введите один из возможных типов:");
        Log.info("INDIA");
        Log.info("RUSSIA");
        Log.info("SOUTH KOREA");
        Log.info("SPAIN");
        Log.info("VATICAN");
        if (scanner.hasNextLine()){
        String line = scanner.nextLine().toLowerCase();
        switch (line) {
            case ("india"):
                nationality = Country.INDIA;
                break;
            case ("russia"):
                nationality= Country.RUSSIA ;
                break;
            case ("south korea"):
                nationality = Country.SOUTH_KOREA ;
                break;
            case ("spain"):
                nationality = Country.SPAIN ;
                break;
            case ("vatican"):
                nationality = Country.VATICAN;
                break;
            default:
                Log.error("Вы ввели неккоректный тип! Попробуйте снова!");
                setNationality();
                break;
        }}
        else{
            Log.error("Программа завершена");
            System.exit(0);}
    }

    private void setTown() {
        if (scanner.hasNextLine()){
            town = scanner.nextLine();
            if (town==null||town.equals("")){
                Log.error("Название города не может быть пустым");
                setTown();
            }
        }else {
            Log.error("Программа завершена");
            System.exit(0);
        }
    }

    public void setLocal() {
        if (scanner.hasNextLine()){
            String line = scanner.nextLine();
            try {
                if (Float.parseFloat(line)>-698f){
                    local = Float.parseFloat(line);}
                else
                {Log.error("Число не может быть меньше -698. Попробуйте снова");
                    setLocal();}
            } catch (NumberFormatException e) {
                Log.error("Вы ввели некорректное число, попробуйте снова!");
                setLocal();
            }
        } else{
            Log.error("Программа завершена");
            System.exit(0);}
    }


    private void setCoordinates() {
        Log.info("Введите координату Х");
        setX1();
        Log.info("Введите координату У");
        setY1();
        coordinates = new Coordinates(coordX, coordY);
    }

    public void setY1() {
        if (scanner.hasNextLine()){
            String line = scanner.nextLine();
            try {
                    if (Float.parseFloat(line)>-698f){
                    coordY = Float.parseFloat(line);}
                else
                {Log.info("Число не может быть меньше -698. Попробуйте снова");
                    setY1();}
            } catch (NumberFormatException e) {
                Log.info("Вы ввели некорректное число, попробуйте снова!");
                setY1();
            }
        }else{
            Log.error("Программа завершена");
            System.exit(0);}
    }

    public void setX1() throws NumberFormatException {
        if (scanner.hasNextLine()){
            String line = scanner.nextLine();
            try {
                coordX = Long.parseLong(line);
            } catch (NumberFormatException e) {
                Log.error("Вы ввели некорректное число, попробуйте снова!");
                setX1();
            }
        } else{
            Log.error("Программа завершена");
            System.exit(0);}
    }



    public void setName(){
        if (scanner.hasNextLine()){
            name = scanner.nextLine();
            if (name==null||name.equals("")){
                Log.error("Имя персонажа не может быть пустым");
                setName();
            }
        }
        else if(scanner.hasNextLine()){
                Log.error("Имя персонажа не может быть пустым! Попробуйте еще раз");
            setName();
        }
        else{
            Log.error("Программа завершена");
            System.exit(0);}
    }
}

