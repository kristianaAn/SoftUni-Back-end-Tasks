import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory sessionFactory =
                cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

//        Student student = new Student("Ivan");
//        Student student2 = new Student("Pesho");
//        Student student3 = new Student("Andrey");
//        session.save(student);
//        session.save(student2);
//        session.save(student3);

//        Student studentToGet = session.get(Student.class, 3L);
//        System.out.println(studentToGet);

        List<Student> allStudents = session.createQuery("FROM Student ", Student.class).list();
        allStudents.forEach(System.out::println);

        session.getTransaction().commit();
        session.close();
    }
}
