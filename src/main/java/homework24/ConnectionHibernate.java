package homework24;

import homework24.entity.Students;
import org.hibernate.Session;


public class ConnectionHibernate {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        MethodsHibernate.addStudent(session, new Students(1, "Alina Sushenko"));
        MethodsHibernate.addStudent(session, new Students(2, "Tanya Serbinenko"));
        MethodsHibernate.addStudent(session, new Students(3, "Roma Sidorenko"));
        System.out.println(MethodsHibernate.getByName(session, "Alina Sushenko"));
        System.out.println(MethodsHibernate.getById(session, 1));
        MethodsHibernate.showAll(session);
        session.close();
        HibernateUtil.shutdown();
    }
}
