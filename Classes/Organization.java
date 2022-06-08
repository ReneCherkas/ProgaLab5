package Classes;

import com.sun.istack.internal.NotNull;

import java.time.ZonedDateTime;

public class Organization implements Comparable<Organization> {
    private int id;
    private String name;
    private Coordinates coordinates;
    private ZonedDateTime creationDate;
    private EyeColor eyecolor;
    private HairColor haircolor;
    private Long Height;
    private int local;
    private Country nationality;
    private String town;


    public Organization(Integer id, String name, Coordinates coordinates, ZonedDateTime creationDate, Long height, EyeColor eyecolor, HairColor haircolor, Country nationality, String town, Integer local) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.eyecolor= eyecolor;
        this.haircolor = haircolor;
        this.Height = height;
        this.nationality = nationality;
        this.town = town;
        this.local = local;
    }

    /**
     * toString according to CSV coding
     */

    @Override
    @NotNull
    public String toString() {
        return "id: " + id +
                " , имя: " + name +
                " , координаты: " + coordinates.toString() +
                ", дата создания: " + creationDate +
                ", рост: " + Height +
                ", цвет глаз: " + eyecolor +
                ", цвет волос: " + haircolor +
                ", национальность: " + nationality +
                ", город в котором находится: " + town+
                ", Координата города: " + local;
    }


    //getters

    public int getId() {
        return this.id;
    }

    public String parse() {
        return id + "," + name +
                "," + coordinates.parsetoString() +
                "," + creationDate +
                "," + Height +
                "," + eyecolor +
                "," + haircolor +
                "," + nationality +
                "," + town +
                "," + local;
    }

    public Country getCountry(){return nationality;}
    
    public int getlocal(){return Integer.parseInt(String.valueOf(local));}

    @Override
    public int compareTo(Organization o) {
        return 0;
    }

    public int getEyecolor() {
        return 0;
    }

}
