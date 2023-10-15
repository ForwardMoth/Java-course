import java.security.Permission;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
