import java.util.ArrayList;

public class Ship {
    private int size;
    private int id;
    private String coordinates;

    Ship(int size, int id) {
        this.size = size;
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public int getSize(){
        return size;
    }

    public boolean updateSize() {
        return --size == 0;
    }

    public void setCoordinates(String coordinates){
        this.coordinates = coordinates;
    }

    public boolean isLine(){
        return coordinates.charAt(0) == coordinates.charAt(coordinates.length() - 2);
    }

    public int getColumnIndex() {
        String[] firstPart = coordinates.split(" ");
        return (firstPart[0].length() == 3) ? 10 : Character.getNumericValue(firstPart[0].charAt(1));
    }

    public Character getLineIndex() {
        return coordinates.charAt(0);
    }

    public boolean isGoodCoordinates(){
        if (size > 1)
            return !((coordinates.length() == 5) | (coordinates.length() == 7));
        else
            return !((coordinates.length() == 2) | (coordinates.length() == 3));
    }
}
