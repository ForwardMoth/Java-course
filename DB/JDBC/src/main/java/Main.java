import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DbConnection dbConnection = new DbConnection();
        dbConnection.createTable();
        StaffDAO staffDAO = new StaffDAO(dbConnection);
        staffDAO.insert(new Staff("Ivanov", "Ivan", "Ivanovich", "CEO", 300000));
        dbConnection.close();
    }
}
