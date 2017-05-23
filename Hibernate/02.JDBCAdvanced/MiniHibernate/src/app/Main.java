package app;

import app.entities.User;
import app.orm.EntityManager;
import app.orm.Manager;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by vladix on 5/22/17.
 */
public class Main {

    public static void main(String[] args) throws SQLException, IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {

        Manager manager = new EntityManager();

        manager.persist("mini_orm", new User(3, "newName", "1234", 18, null));
        manager.persist("mini_orm", new User(1, "newName1", "1234", null, null));
        manager.persist("mini_orm", new User(123, "newName2", "1234", 18, new Date()));
        manager.persist("mini_orm", new User(321, "newName3", "1234", null, new Date(1234, 05, 1)));
        manager.persist("mini_orm", new User(213, "newName4", "1234", 18, null));


        Iterable<User> entities = manager.find("mini_orm", User.class);
        for (User user : entities) {
            System.out.println(user);
        }

        System.out.println("==================================");
        System.out.println("==================================");
        System.out.println("==================================");

        User mini_orm = manager.findFirst("mini_orm", User.class);
        System.out.println(mini_orm);

    }
}
