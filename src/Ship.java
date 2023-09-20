public class Ship {
    private int size;
    private String coordinates;
    Ship(int size) {
        this.size = size;
    }

    public int getSize(){
        return size;
    }

    public void setCoordinates(String coordinates){
        this.coordinates = coordinates;
    }

    public String getCoordinates() {
        return coordinates;
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

//    public boolean linePlacing(){
//        return coordinates[0] == coordinates[1];
//    }
}
