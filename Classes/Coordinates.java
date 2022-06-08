package Classes;


public class Coordinates {
    private long x;
    private float y;

    public Coordinates(long x,float y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public String parsetoString() {
        return x+","+y;
    }
}
