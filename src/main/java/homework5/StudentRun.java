package homework5;

public class StudentRun {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        Student[] students = studentService.generateArrayOfStudents();
        System.out.println("List of students at faculty Applied Math:");
        studentService.printByFaculty(students, "Applied Math");
        System.out.println("_________________");
        System.out.println("List of students at faculty Applied Math and cource System Analysis:");
        studentService.printByFacultyAndCoure(students, "Applied Math", "System Analysis");
        System.out.println("_________________");
        System.out.println("List of students born later than 1996:");
        studentService.printStudentsBornAfter(students, 1996);
        System.out.println("_________________");
        System.out.println("List of students in group PS-1");
        studentService.printByGroup(students, "PS-1");
    }
}
