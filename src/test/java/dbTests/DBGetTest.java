package dbTests;

import db.DBHelper;
import org.testng.annotations.Test;

public class DBGetTest {
    DBHelper dB = new DBHelper();

    @Test
    public void startTest(){
        String sql = "SELECT * FROM REGISTRATION";

        String addValue = "INSERT INTO REGISTRATION (id, last, first, age) \n" +
                           " VALUES (99999, 'Brrrbrrrr', 'brrrbr', '789');";

        //String sql = "SELECT * FROM REGISTRATION WHERE last='Brrrbrrrr' AND age=777;";
        // Время позднее, так будет быстрее) Всего лишь замена значений переменных sql и через боль и мучения он выведет эту строчкуХД

        dB.UpdateDB(addValue);

        DBHelper.getSqlResult(sql).forEach(s-> System.out.println(s));
        System.out.println(DBHelper.getValueFirstRow(sql,"first"));
    }
}
