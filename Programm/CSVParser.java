package Programm;

import Classes.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class CSVParser {
    private String ipath;

    public CSVParser(String path) {
        ipath = path;
    }

    /**
     * Method parsing file from CSV
     *
     * @param orgs Collection of elements
     * @throws IOException
     */

    public void parse(Organizations orgs) throws IOException {
        try {
            Scanner scanner = new Scanner(Paths.get(ipath));
            while (scanner.hasNext()) {
                //парсим строку в объект Organization
                Organization org;
                org = parseCSVLine(scanner.nextLine());
                try {
                    orgs.add(org);
                } catch (NullPointerException e) {
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Не найден файл для загрузки в коллекцию");
        }
    }

    /**
     * method parsing a line in CSV to executable format
     *
     * @param line the line we need to parse
     * @return
     * @throws NumberFormatException
     */

    private static Organization parseCSVLine(String line) throws NumberFormatException {
        try {

            String[] args = line.split("\\s*[,\"]+\\s*");
            //String[] args = Arrays.stream(line.split("[,\"]+"));
                    //.map(String::trim)
                    //.toArray(String[]::new);


            //String[] args = line.split("(?!\"),(?!\")");

            /*
            String[] args = line.split(",");
            for (int i = 0; i < args.length; ++i) {
                if (args[i].startsWith("\"")) { // collect from the start of the cell;
                    String s = args[i].substring(1);
                    while (i < args.length - 1) {
                        s += "," + args[++i].substring(0, args[i].length() - 1);
                        if (args[i++].endsWith("\"")) break; // jump out of the cell after the closing double quotes;
                    }}}*/



            /*
            line = line.replaceAll(", ", "#%&");
            String[] args = line.split(",(?!\")");
            for (int i = 0; i<args.length; i++){
                args[i] = args[i].replaceAll("#%&", ", ");
            }*/
            //Log.info(Arrays.toString(args));
            /*for (String fileLine : args){
                String[] splitText = fileLine.split(",");
                ArrayList<String> columnList = new ArrayList<>();
                for (int i=0; i<line.length(); i++){
                    if(IsColumnPart(splitText[i])){
                        String lastText = columnList.get(columnList.size()-1);
                        columnList.set(columnList.size()-1, lastText + "," + splitText[i]);
                    }else {
                        columnList.add(splitText[i]);
                    }
                }
            }
            Log.error(line.length());*/
            EyeColor eyecolor = null;
            int id = Integer.parseInt(args[0].trim());
            String name = args[1].trim();
            long x = Long.parseLong(args[2].trim());
            float y = Float.parseFloat(args[3].trim());
            Coordinates coordinates = new Coordinates(x, y);
            ZonedDateTime time = ZonedDateTime.parse(args[4].trim());
            long height = Long.parseLong(args[5].trim());
            String eyecolor1 = args[6].trim();
            if (eyecolor1.equals("GREEN")) {
                eyecolor =EyeColor.GREEN;
            } else {
                if (eyecolor1.equals("BLACK")) {
                    eyecolor =EyeColor.BLACK;
                } else {
                    if (eyecolor1.equals("ORANGE")) {
                        eyecolor = EyeColor.ORANGE;
                    }
                }
            }
            if (eyecolor1 == null) throw new NumberFormatException();
            String haircolor1 = args[7].trim();
            HairColor hairColor = null;
            if (haircolor1.equals("RED")) {
                hairColor = HairColor.RED;
            } else {
                if (haircolor1.equals("BLACK")) {
                    hairColor = HairColor.BLACK;
                } else {
                    if (haircolor1.equals("YELLOW")) {
                        hairColor = HairColor.YELLOW;
                    } else {
                        if (haircolor1.equals("BROWN")) {
                            hairColor = HairColor.BROWN;
                        }
                    }
                }
            }
            if (haircolor1 == null) throw new NumberFormatException();
            String nationality1 = args[8].trim();
            Country nationality = null;
            if (nationality1.equals("VATIKAN")) {
                nationality = Country.VATICAN;
            } else {
                if (nationality1.equals("SPAIN")) {
                    nationality = Country.SPAIN;
                } else {
                    if (nationality1.equals("SOUTH_KOREA")) {
                        nationality = Country.SOUTH_KOREA;
                    } else {
                        if (nationality1.equals("RUSSIA")) {
                            nationality = Country.RUSSIA;
                        }else{
                            if (nationality1.equals("INDIA")){
                                nationality = Country.INDIA;
                            }
                        }
                    }
                }
            }
            if (nationality1 == null) throw new NumberFormatException();
            String town = args[9].trim();
            int local = Integer.parseInt(args[10].trim());
            Organization organization = new Organization(id, name, coordinates, time, height, eyecolor, hairColor,  nationality, town, local);
            return organization;
        } catch (NumberFormatException n){
            System.out.println("Неверный формат введенных данных. Проверьте файл");
            return null;
        }

    }private static boolean IsColumnPart(String text) {
        String trimText = text.trim();
        //Если в тексте одна ковычка и текст на нее заканчиваеться значит это часть предыдущей колонки
        return trimText.indexOf("\"") == trimText.lastIndexOf("\"") && trimText.endsWith("\"");
    }
}

