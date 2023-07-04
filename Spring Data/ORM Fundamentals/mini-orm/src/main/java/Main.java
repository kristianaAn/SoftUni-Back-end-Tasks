import entities.User;
import orm.EntityManager;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import static orm.MyConnector.createConnection;
import static orm.MyConnector.getConnection;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        createConnection("USERNAME", "PASSWORD", "custom-orm");
        Connection connection = getConnection();

        EntityManager<User> userEntityManager = new EntityManager<>(connection);
        boolean persistUser = userEntityManager.persist(new User("Ivan", 22, LocalDate.now()));
        User firstFound = userEntityManager.findFirst(User.class);

        System.out.println(firstFound);
        System.out.println(persistUser);
    }
}
