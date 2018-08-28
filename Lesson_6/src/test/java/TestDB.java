import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestDB {

    private StudentsDB studentsDB;
    private String surname;
    private int score;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {"Иванов", 5},
                {"Сидоров", 5},
                {"Петров", 2},
                {"Шапошников", 1},
        });
    }

    public TestDB(String surname, int score){
        this.surname = surname;
        this.score = score;
    }

    @Before
    public void connect() throws SQLException, ClassNotFoundException {
        studentsDB = StudentsDB.getInstance();
        studentsDB.connect();
        studentsDB.getConnection().setAutoCommit(false);
    }

    @Test
    public void add() throws SQLException {
        Assert.assertTrue(studentsDB.addInTable(surname,score));

    }

    @Test
    public void update() throws SQLException {
        Assert.assertTrue(studentsDB.updateTable(surname,score));
    }

    @Test
    public void select() throws SQLException {
        Assert.assertTrue(studentsDB.select(surname,score));
    }

    @After
    public void disconnect() throws SQLException {
        studentsDB.disconnect();
    }
}