package lesson23;

import java.sql.SQLException;

public class ConnectionWithTable {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Methods.addStudent(new Student(4, "Alina Gagarina"));
        Methods.showStudents().forEach(student -> System.out.println(student));
        System.out.println(Methods.getById(1));
        System.out.println(Methods.getByName("Tanya Serbinenko"));


    }


}
