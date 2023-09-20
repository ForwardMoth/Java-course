import java.util.ArrayList;

public class Field {
    private final static int FIELD_SIZE = 10;
    private ArrayList<ArrayList<Cell>> field;

    private final static String LETTERS = "ABCDEFGHIJ";

    Field() {
        this.field = createField();
    }

    public boolean placeShip(Ship ship) {
        if (ship.isGoodCoordinates())
            return true;

        int columnIndex = ship.getColumnIndex() - 1;
        int lineIndex = getIntegerIndex(ship.getLineIndex());

        if (isLineInsert(ship))
            for(int i=columnIndex; i<columnIndex+ship.getSize();i++)
                field.get(lineIndex).get(i).setType("*");
        else
            for(int i=lineIndex; i < lineIndex+ship.getSize();i++)
                field.get(i).get(columnIndex).setType("*");
        return false;
    }

    private int getIntegerIndex(char letter) {
        return LETTERS.indexOf(letter);
    }

    private boolean isLineInsert(Ship ship){
        String coordinates = ship.getCoordinates();
        return coordinates.charAt(0) == coordinates.charAt(coordinates.length() - 2);
    }

    public void printField() {
        System.out.println("Game field");
        for(int i=0; i<FIELD_SIZE; i++) {
            for(int j=0; j<FIELD_SIZE; j++) {
                System.out.print(field.get(i).get(j).getType() + " ");
            }
            System.out.print(LETTERS.charAt(i));
            System.out.println();
        }

        for(int i=0;i<FIELD_SIZE;i++)
            System.out.print(i+1 + " ");
        System.out.println();
    }

    private ArrayList<ArrayList<Cell>> createField() {
        ArrayList<ArrayList<Cell>> newField = new ArrayList<>();
        for(int i=0; i<FIELD_SIZE; i++) {
            ArrayList<Cell> row = new ArrayList<>();
            for(int j=0; j<FIELD_SIZE; j++) {
                row.add(new Cell());
            }
            newField.add(row);
        }
        return newField;
    }
}
