import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private Connection connection;
    public DbConnection(){
        setConnection();
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
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
