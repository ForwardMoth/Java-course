import java.util.ArrayList;

public class Field {
    private final static int FIELD_SIZE = 10;
    private ArrayList<ArrayList<Cell>> field;

    private final static String LETTERS = "ABCDEFGHIJ";

    private final static Ship tecniqueShip = new Ship(1, -1);

    Field() {
        this.field = createField();
    }

    public int insertHit(String coordinates) {
        tecniqueShip.setCoordinates(coordinates);
        int columnIndex = tecniqueShip.getColumnIndex() - 1;
        int lineIndex = getIntegerIndex(tecniqueShip.getLineIndex());

        Cell currentCell = field.get(lineIndex).get(columnIndex);
        int cellType = currentCell.getType();
        if (cellType <= 0)
            currentCell.setType(-1);
        else
            currentCell.setType(-2);
        return cellType;
    }

    public boolean placeShip(Ship ship) {
        if (ship.isGoodCoordinates())
            return true;

        int columnIndex = ship.getColumnIndex() - 1;
        int lineIndex = getIntegerIndex(ship.getLineIndex());

        if (ship.isLine())
            for(int i=columnIndex; i<columnIndex+ship.getSize();i++)
                field.get(lineIndex).get(i).setType(ship.getId());
        else
            for(int i=lineIndex; i < lineIndex+ship.getSize();i++)
                field.get(i).get(columnIndex).setType(ship.getId());
        return false;
    }

    private int getIntegerIndex(char letter) {
        return LETTERS.indexOf(letter);
    }

    public void printField(boolean hideShips) {
        System.out.println("Game field");
        for(int i=0; i<FIELD_SIZE; i++) {
            for(int j=0; j<FIELD_SIZE; j++) {
                System.out.print(field.get(i).get(j).getType(hideShips) + " ");
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
