import java.util.ArrayList;

public class Field {
    private final static int FIELD_SIZE = 10;
    private ArrayList<ArrayList<Cell>> field;

    private final static String[] LETTERS = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

    Field() {
        this.field = createField();
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

    public void printField() {
        System.out.println("Game field");
        for(int i=0; i<FIELD_SIZE; i++) {
            for(int j=0; j<FIELD_SIZE; j++) {
                System.out.print(field.get(i).get(j).getType() + " ");
            }
            System.out.print(LETTERS[i]);
            System.out.println();
        }

        for(int i=0;i<FIELD_SIZE;i++)
            System.out.print(i + " ");
        System.out.println();
    }
}
