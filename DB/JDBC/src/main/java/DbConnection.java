import java.sql.*;

public class DbConnection {
    private Connection connection;

    private Statement statement;

    private final String sqlQueryCreationStaff = "CREATE TABLE IF NOT EXISTS staff" +
                                          "(id serial PRIMARY KEY," +
                                          "first_name VARCHAR(255)," +
                                          "second_name VARCHAR(255)," +
                                          "last_name VARCHAR(255)," +
                                          "position VARCHAR(255)," +
                                          "salary integer)";

    public DbConnection(){
        setConnection();
    }

    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return this.connection.prepareStatement(sql);
    }

    public Statement getStatement() {
        return statement;
    }

    private void setConnection(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            this.connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/javadb",
                    "java", "1111");
            this.statement = this.connection.createStatement();
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void createTable() throws SQLException {
        this.statement.executeUpdate(sqlQueryCreationStaff);
    }

    protected void close() throws SQLException {
        this.connection.close();
    }
}
