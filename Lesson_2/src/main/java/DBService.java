import java.sql.*;

public class DBService {

    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement prstmt;
    private static ResultSet rs;
    private static String sql;

    private DBService(){ }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:Lesson_2.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() throws SQLException {
        connection.close();
    }

    public static void createTable() throws SQLException {
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS products (\n" +
                "    id        INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    prodid  INTEGER UNIQUE,\n" +
                "    title   TEXT,\n" +
                "    cost    INTEGER\n" +
                ");");
        cleanTable();
        fillTable();
    }

    private static void cleanTable() throws SQLException {
        stmt.executeUpdate("DELETE FROM products;" +
                "update sqlite_sequence set\n" +
                "seq=0\n" +
                "WHERE Name='products'");
    }

    private static void fillTable() throws SQLException {
        connection.setAutoCommit(false);
        for(int i = 1; i <= 10000; i++){
            sql = String.format("insert into products (prodid, title, cost)\n" +
                    "Values (%s, '%s', %s)", i, "товар" + i, i * 10);
            stmt.executeUpdate(sql);
        }
        connection.setAutoCommit(true);
    }

    public static String getCost(String name) throws SQLException {
        sql = String.format("SELECT cost FROM products\n" +
                "WHERE title = '%s'", name);

        rs = stmt.executeQuery(sql);

        if(rs.next()){
            return rs.getString(1);
        }
        else{
            return "Такого товара нет";
        }
    }

    public static void setCost(String name, int newCost) throws SQLException {
        sql = String.format("UPDATE products SET cost = %s \n" +
                "WHERE title = '%s'", newCost, name);

        int flag = stmt.executeUpdate(sql);

        if (flag > 0) {
            System.out.println("Цена товара изменена");
        }
        else {
            System.out.println("Такого товара нет");
        }
    }

    public static StringBuilder productsInBetween(int first, int second) throws SQLException {
        StringBuilder products = new StringBuilder();

        sql = String.format("SELECT title FROM products\n" +
                "WHERE cost BETWEEN %s AND %s ", first, second);

        rs = stmt.executeQuery(sql);

        while (rs.next()){
            products.append(rs.getString(1) + "\n");
        }


        return products.length() == 0 ? products.append("Подходящих товаров нет") : products;
    }
}
