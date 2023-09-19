public class Cell {
    // type = { - (without ship), * (ship), + (shooted) }
    private String type;

    Cell() {
        this.type = "-";
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public boolean isShooted(){
        return type.equals("+");
    }

    public boolean isEmpty() {
        return type.equals("*");
    }
}
