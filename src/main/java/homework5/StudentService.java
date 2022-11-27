package homework5;

class StudentService {

    public Student[] generateArrayOfStudents() {
        Student[] studentArray = new Student[10];
        studentArray[0] = new Student(1, "Serbinenko", "Tanya", "Ihorevna", 1996, "Dnipro", 380990290000L, "Applied Math", "Applied Math", "PM-1");
        studentArray[1] = new Student(2, "Klimenko", "Katya", "Vadimovna", 1995, "Dnipro", 380990290660L, "Applied Math", "System Analysis", "PS-1");
        studentArray[2] = new Student(3, "Yshny", "Vlad", "Viktorovych", 1994, "Dnipro", 380990290680L, "Applied Math", "System Analysis", "PS-2");
        studentArray[3] = new Student(4, "Gylivez", "Tanya", "Adamovna", 1996, "Dnipro", 380990298800L, "Applied Math", "Applied Math", "PM-2");
        studentArray[4] = new Student(5, "Grigoriev", "Myhail", "Dmitrievych", 1996, "Dnipro", 380990290870L, "Economy", "Finance", "EF-1");
        studentArray[5] = new Student(6, "Shementov", "Vlad", "Vadimovych", 1995, "Dnipro", 380990298500L, "Electrolitic", "Applied Mathematic", "PM-1");
        studentArray[6] = new Student(7, "Sidorenko", "Roman", "Vladislavovych", 1997, "Dnipro", 380990450000L, "Economy", "Finance", "EF-1");
        studentArray[7] = new Student(8, "Kryvzun", "Eugeniy", "Alexandrovych", 1996, "Dnipro", 380990560000L, "Literatury", "Ukrainian Literature", "LU-1");
        studentArray[8] = new Student(9, "Sushenko", "Alina", "Sergeevna", 1997, "Dnipro", 380990930000L, "Literatury", "Foreighn Literature", "FL-1");
        studentArray[9] = new Student(10, "Alishev", "Dmutro", "Stanislavovych", 1997, "Dnipro", 380990292400L, "Applied Math", "System Analysis", "PS-1");

        return studentArray;
    }

    public void printByFaculty(Student[] arrayOfStudents, String faculty) {
        if (faculty == null || faculty.isEmpty()) {
            return;
        }
        for (Student student : arrayOfStudents) {
            if (faculty.equals(student.getFaculty())) {
                System.out.println(student);
            }
        }
    }

    public void printByFacultyAndCoure(Student[] arrayOfStudents, String faculty, String course) {
        if (faculty == null || course == null || faculty.isEmpty() || course.isEmpty()) {
            return;
        }
        for (Student student : arrayOfStudents) {
            if ((faculty.equals(student.getFaculty())) && course.equals(student.getCourse())) {
                System.out.println(student);
            }
        }
    }

    public void printStudentsBornAfter(Student[] arrayOfStudents, int year) {
        for (Student student : arrayOfStudents) {
            if (student.getYearOfBirth() > year) {
                System.out.println(student);
            }
        }
    }

    public void printByGroup(Student[] arrayOfStudents, String group) {
        if (group == null || group.isEmpty()) {
            return;
        }
        for (Student student : arrayOfStudents) {
            if (group.equals(student.getGroup())) {
                System.out.println(student);
            }
        }
    }
}