import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO {
    private final static String tableName = "staff";
    private final static String firstName = "first_name";
    private final static String secondName = "second_name";
    private final static String lastName = "last_name";
    private final static String position = "position";
    private final static String salary = "salary";
    private DbConnection connection;

    public StaffDAO(DbConnection dbConnection) {
        this.connection = dbConnection;
    }

    public void insert(Staff staff) throws SQLException {
        String sql = "INSERT INTO " + tableName + " " + formString(getAllColumns()) + " VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement = this.connection.getPreparedStatement(sql);
        preparedStatement.setString(1, staff.firstName);
        preparedStatement.setString(2, staff.secondName);
        preparedStatement.setString(3, staff.lastName);
        preparedStatement.setString(4, staff.position);
        preparedStatement.setInt(5, staff.salary);
        preparedStatement.executeUpdate();
        System.out.println("Staff is inserted");
    }

    public ArrayList<Staff> selectAll() throws SQLException {
        ArrayList<Staff> staffs = new ArrayList<>();
        String sql = "SELECT * FROM " + tableName;
        ResultSet rs = this.connection.getStatement().executeQuery(sql);
        while (rs.next()) {
            staffs.add(createStaff(rs));
        }
        System.out.println("Select all staffs");
        return staffs;
    }

    public Staff selectById(int id) throws SQLException {
        String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
        PreparedStatement preparedStatement = this.connection.getPreparedStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        Staff staff = null;
        while(rs.next()){
             staff = createStaff(rs);
        }
        return staff;
    }

    public ArrayList<Staff> selectByColumn(String column, Object value) throws SQLException {
        String  sql = "SELECT * FROM " + tableName + " WHERE " + column + " = ?";
        PreparedStatement preparedStatement = this.connection.getPreparedStatement(sql);
        preparedStatement.setObject(1, value);
        ResultSet rs = preparedStatement.executeQuery();
        ArrayList<Staff> staffs = new ArrayList<>();
        while (rs.next()) {
            staffs.add(createStaff(rs));
        }
        System.out.println("Select staffs by condition");
        return staffs;
    }

    public Staff createStaff(ResultSet rs) throws SQLException {
        return new Staff(rs.getString(firstName),
                         rs.getString(secondName),
                         rs.getString(lastName),
                         rs.getString(position),
                         rs.getInt(salary));
    }

    public void update(Staff staff, String column, Object value) throws SQLException {
        int id = getStaffId(staff);
        if (id == 0) {
            System.out.println("Staff isn't exists");
        }
        else {
            String sql = "UPDATE " + tableName + " SET " + column + " = ?" + " WHERE id = ?";
            PreparedStatement preparedStatement = connection.getPreparedStatement(sql);
            preparedStatement.setObject(1, value);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            System.out.println("Updated staff with id " + id);
        }
    }

    public void delete(Staff staff) throws SQLException {
        int id = getStaffId(staff);
        if (id == 0) {
            System.out.println("Staff isn't exists");
        }
        else {
            String sql = "DELETE FROM " + tableName + " WHERE id = ?";
            PreparedStatement preparedStatement = connection.getPreparedStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Delete staff with id " + id);
        }
    }

    public int getStaffId(Staff staff) throws SQLException {
        String sql = "SELECT id FROM " + tableName + " WHERE " + firstName + " = ?" +
                " AND " + secondName + " = ?" + " AND " + lastName + " = ?";
        PreparedStatement preparedStatement = connection.getPreparedStatement(sql);
        preparedStatement.setString(1, staff.firstName);
        preparedStatement.setString(2, staff.secondName);
        preparedStatement.setString(3, staff.lastName);
        ResultSet resultSet = preparedStatement.executeQuery();
        int id = 0;
        while(resultSet.next())
            id = resultSet.getInt("id");
        return id;
    }

    private String formString(String[] args){
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for(int i=0;i<args.length; i++) {
            sb.append(args[i]);
            if (i < args.length - 1)
                sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }

    private String[] getAllColumns(){
        return new String[]{firstName, secondName, lastName, position, salary};
    }
}
