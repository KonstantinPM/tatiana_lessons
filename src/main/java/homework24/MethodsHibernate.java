package homework24;

import homework24.entity.Students;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class MethodsHibernate {
    public static void addStudent(Session session, Students st1) {
        session.getTransaction().begin();
        session.persist(st1);
        session.getTransaction().commit();
    }


    public static Students getByName(Session session, String name) {
        session.getTransaction().begin();
        Query<Students> query = session.createQuery("from Students where nameSurname = :name", Students.class);
        query.setParameter("name", name);
        Students result = query.getSingleResult();
        session.getTransaction().commit();
        return result;
    }

    public static Students getById(Session session, int id) {
        session.getTransaction().begin();
        Students student = session.createQuery("FROM Students WHERE idStudent = :id", Students.class).setParameter("id", id).getSingleResult();
        session.getTransaction().commit();
        return student;
    }

    public static void showAll(Session session) {
        session.getTransaction().begin();
        session.createQuery("from Students", Students.class).list().forEach(System.out::println);
        session.getTransaction().commit();
    }
}
