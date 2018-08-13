import java.sql.SQLException;


public class Main {

    public static void main(String[] args) {
        try {
            DBService.connect();
            DBService.createTable();
            new ManagementDB();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DBService.disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
