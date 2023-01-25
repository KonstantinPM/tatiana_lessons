package lesson23;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Methods {
    public static final String serverTimeZone = "UTC";
    public static final String serverName = "localhost"; // ip address db
    public static final String databaseName = "newDB"; // bd name
    public static final int portNumber = 3306; // db port
    public static final String user = "root"; // login
    public static final String password = "rootroot"; // password

    public static void addStudent(Student st1) throws SQLException {
        MysqlDataSource dataSource = getDataSource();
        java.sql.Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        statement.execute("insert into  students (id_student, name_surname) value  (" + st1.getId() + ",'" + st1.getName() + "')");
        connection.close();
    }

    public static void deleteStudent(Student st1) throws SQLException {
        MysqlDataSource dataSource = getDataSource();
        java.sql.Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        statement.execute("delete from students where  (name_surname) = ('" + st1.getName() + "')");
        connection.close();
    }
    public static MysqlDataSource getDataSource() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUseSSL(false);
        dataSource.setServerTimezone(serverTimeZone);
        dataSource.setServerName(serverName);
        dataSource.setDatabaseName(databaseName);
        dataSource.setPortNumber(portNumber);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    private static Connection getConnection () throws SQLException {
        return getDataSource().getConnection();
    }

    private static Statement getStatement () throws SQLException {
        return getConnection().createStatement();
    }

    public static List<Student> showStudents() throws SQLException {

        Statement statement = getStatement();

        ResultSet rs = statement.executeQuery("select * from students");

        List<Student> student = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id_student");
            String Name = rs.getString("name_surname");
            student.add(new Student(id, Name));
        }
        return student;
    }


    public static List<Student> getByName(String name) throws SQLException {
        Statement statement = getStatement();
        List<Student> student = new ArrayList<>();
        String query = "select * from students where name_surname = " + "'" + name + "'";
        System.out.println("Query: " + query);

        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {
            int id = rs.getInt("id_student");
            String fullName = rs.getString("name_surname");
            student.add(new Student(id, fullName));
        }
        return student;
    }

    public static List<Student> getById(int id) throws SQLException {
        Statement statement = getStatement();
        List<Student> student = new ArrayList<>();
        String query = "select * from students where id_student = " + "'" + id + "'";
        System.out.println("Query: " + query);

        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {
            int idTemp = rs.getInt("id_student");
            String fullName = rs.getString("name_surname");
            student.add(new Student(idTemp, fullName));
        }
        return student;
    }
}

