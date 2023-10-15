public class Staff {
    public String firstName;
    public String secondName;
    public String lastName;
    public String position;
    public int salary;

    public Staff(String firstName, String secondName, String lastName, String position, int salary) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.position = position;
        this.salary = salary;
    }

    public Staff(String firstName, String secondName, String lastName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
    }

    public void getStaff(){
        System.out.println("Staff information");
        System.out.println("------------------------");
        System.out.println("firstName: " + this.firstName);
        System.out.println("secondName: " + this.secondName);
        System.out.println("lastName: " + this.lastName);
        System.out.println("position: " + this.position);
        System.out.println("salary: " + this.salary);
        System.out.println("------------------------");
    }
}
