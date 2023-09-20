import java.util.Scanner;

public class Player {
    private final static int COUNT_SHIPS = 10;
    private String name;
    private Ship[] ships;
    public Field field;

    Player(String name) {
        this.name = name;
        this.field = new Field();
        this.ships = createShips();
    }

    public String getName(){
        return name;
    }

    public void fillShips(Scanner scanner){
        printName();
        System.out.print("place your ships");
        System.out.println();
        for(int i=0; i< COUNT_SHIPS; i++) {
            field.printField();
            System.out.println("Place ship with size " + ships[i].getSize());
            placementShip(scanner, ships[i]);
        }
        System.out.println("Your placement of the ships!");
        field.printField();
        System.out.println();
    }

    private void placementShip(Scanner scanner, Ship ship) {
        System.out.println("Enter coordinates. Write two coordinates with whitespace (ex. E1 E4)");
        ship.setCoordinates(scanner.nextLine());
        field.placeShip(ship);
    }

    public void fillTestShips(String[] shipsCoordinates) {
        System.out.println("Test placing of ships of player " + name);
        for(int i=0;i<COUNT_SHIPS;i++)
            placementTestShip(ships[i], shipsCoordinates[i]);
    }

    private void placementTestShip(Ship ship, String coordinates){
        ship.setCoordinates(coordinates);
        field.placeShip(ship);
    }

    public void printName() {
        System.out.print(name + ", ");
    }

    public boolean isAlive() {
        return (ships.length > 0) ? true : false;
    }

    private Ship[] createShips(){
        return new Ship[]{new Ship(4),
                          new Ship(3), new Ship(3),
                          new Ship(2), new Ship(2), new Ship(2),
                          new Ship(1), new Ship(1), new Ship(1), new Ship(1)};
    }
}
