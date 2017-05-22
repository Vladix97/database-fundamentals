package app;

import app.entities.User;
import app.orm.EntityManager;
import app.orm.Manager;

import java.sql.SQLException;
import java.util.Date;

/**
 * Created by vladix on 5/22/17.
 */
public class Main {

    public static void main(String[] args) throws SQLException, IllegalAccessException {
        Manager manager = new EntityManager();

        User user = new User(1, "pesho", "1234", 12, new Date());
        manager.persist("mini_orm", user);


    }
}
