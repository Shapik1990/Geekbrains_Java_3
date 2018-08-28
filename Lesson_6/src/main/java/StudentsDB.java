import java.sql.*;

public class StudentsDB {
    private static StudentsDB instance;
    private Connection connection;
    private Statement stmt;
    private ResultSet rs;
    private String sql;

    private StudentsDB(){
    }

    public static StudentsDB getInstance(){
        if (instance == null){
            instance = new StudentsDB();
        }
        return instance;
    }

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:students.db");
        stmt = connection.createStatement();
    }

    public void disconnect() throws SQLException {
        connection.close();
    }

    public boolean addInTable(String surname, int score) throws SQLException {
        sql = String.format("insert into students (surname, score)\n" +
                "Values ('%s', %s)", surname, score);
        return stmt.executeUpdate(sql) > 0;

    }

    public Connection getConnection() {
        return connection;
    }

    public boolean updateTable (String surname, int score) throws SQLException {
        sql = String.format("UPDATE students SET score = %s \n" +
                "WHERE surname = '%s'", score, surname);

        return stmt.executeUpdate(sql) > 0;
    }


    public boolean select (String surname, int score) throws SQLException {
        sql = String.format("SELECT surname FROM students\n" +
                "WHERE score = %s AND surname = '%s'", score, surname);

        rs = stmt.executeQuery(sql);
        return rs.next();
    }

}
