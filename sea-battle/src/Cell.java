public class Cell {
   // type > 0 (*) - ship
   // type = 0 (-) - empty cell
   // type = -1 (+) - shot cell

    private int type;
    private final static String shot = "+";
    private final static String empty = "-";
    private final static String ship = "*";


    Cell() {
        this.type = 0;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType(){
        return type;
    }

    public String getType(boolean hideShip){
        if (!hideShip)
            return getStringType();

        if (isShotShip())
            return ship;

        return isShip() ? empty : getStringType();
    }

    private String getStringType() {
        if (isShot())
            return shot;
        return (isShip()) ? ship : empty;
    }

    private boolean isShot(){
        return type == -1;
    }

    private boolean isShotShip(){
        return type == -2;
    }

    private boolean isShip() {
        return type > 0;
    }
}
