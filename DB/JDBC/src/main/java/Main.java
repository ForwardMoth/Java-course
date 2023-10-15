import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void printStaffs(ArrayList<Staff> staffs){
        if (!staffs.isEmpty()) {
            System.out.println("Print info about all staffs");
            for (Staff staff : staffs) {
                staff.getStaff();
            }
        }
    }

    public static void printStaff(Staff staff) {
        if (staff != null)
            staff.getStaff();
    }

    public static void main(String[] args) throws SQLException {
        DbConnection dbConnection = new DbConnection();
        dbConnection.createTable();
        StaffDAO staffDAO = new StaffDAO(dbConnection);
        staffDAO.insert(new Staff("Ivanov", "Ivan", "Ivanovich", "CEO", 300000));
        staffDAO.update(new Staff("Ivanov", "Ivan", "Ivanovich"), "salary", 360000);
        staffDAO.update(new Staff("Ivanov", "Ivan", "Ivanovich"), "position", "General manager");
        Staff staff = staffDAO.selectById(staffDAO.getStaffId(new Staff("Ivanov", "Ivan", "Ivanovich")));
        printStaff(staff);
        staffDAO.delete(new Staff("Ivanov", "Ivan", "Ivanovich"));

        staffDAO.insert(new Staff("Ivanov", "Ivan", "Ivanovich", "CEO", 300000));
        staffDAO.insert(new Staff("Petrov", "Alex", "Petrovich", "junior-backend", 60000));
        ArrayList<Staff> staffs = staffDAO.selectAll();
        printStaffs(staffs);

        ArrayList<Staff> filteredStaffs = staffDAO.selectByColumn("position", "CEO");
        printStaffs(filteredStaffs);
        dbConnection.close();
    }
}
