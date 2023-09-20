import java.util.HashMap;
import java.util.Scanner;

public class Player {
    private final static int COUNT_SHIPS = 10;
    private String name;

    private HashMap<Integer,Ship> ships = new HashMap<>() {{
        put(1, new Ship(4, 1));
        put(2, new Ship(3, 2));
        put(3, new Ship(3, 3));
        put(4, new Ship(2, 4));
        put(5, new Ship(2, 5));
        put(6, new Ship(2, 6));
        put(7, new Ship(1, 7));
        put(8, new Ship(1, 8));
        put(9, new Ship(1, 9));
        put(10, new Ship(1, 10));
    }};

    public Field field;

    Player(String name) {
        this.name = name;
        this.field = new Field();
    }

    public boolean isHit(String coordinates){
        int cellType = field.insertHit(coordinates);
        if (cellType <= 0)
            return false;

        if (ships.get(cellType).updateSize()){
            ships.remove(cellType);
            System.out.println("The ship is destroyed!");
            System.out.println("The are " + ships.size() + " ships left");
        }
        else
            System.out.println("You are hit the ship!");
        return true;
    }

    public String makeShot(Scanner scanner) {
        System.out.println("Enter coordinates to shot field");
        return scanner.nextLine();
    }

    public void showShotField(){
        field.printField(true);
    }

    public String getName(){
        return name;
    }

    public void fillShips(Scanner scanner){
        printName();
        System.out.print("place your ships");
        System.out.println();
        for(int i=1; i<= COUNT_SHIPS; i++) {
            field.printField(false);
            System.out.println("Place ship with size " + ships.get(i).getSize());
            placementShip(scanner, ships.get(i));
        }
        System.out.println("Your placement of the ships!");
        field.printField(false);
        System.out.println();
    }

    private void placementShip(Scanner scanner, Ship ship) {
        System.out.println("Enter coordinates. Write two coordinates with whitespace (ex. E1 E4)");
        ship.setCoordinates(scanner.nextLine());
        field.placeShip(ship);
    }

    public void fillTestShips(String[] shipsCoordinates) {
        System.out.println("Test placing of ships of player " + name);
        for(int i=1;i<=COUNT_SHIPS;i++)
            placementTestShip(ships.get(i), shipsCoordinates[i-1]);
    }

    private void placementTestShip(Ship ship, String coordinates){
        ship.setCoordinates(coordinates);
        field.placeShip(ship);
    }

    public void printName() {
        System.out.print(name + ", ");
    }

    public boolean isAlive() {
        return !ships.isEmpty();
    }
}
