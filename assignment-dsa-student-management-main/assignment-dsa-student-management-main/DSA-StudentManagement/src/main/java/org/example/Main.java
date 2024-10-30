package org.example;
public class Main {
    public static void main(String[] args) {
        StudentStack studentManagement = new StudentStack();

        // Adding sample students
        studentManagement.addStudent(new Student(1, "Alice", 8.0));
        studentManagement.addStudent(new Student(2, "Bob", 6.7));
        studentManagement.addStudent(new Student(3, "Charlie", 4.5));
        studentManagement.addStudent(new Student(4, "Diana", 7.9));

        // Displaying all students
        System.out.println("\nInitial list of students:");
        studentManagement.displayStudents();

        // Editing student information
        System.out.println("\nEditing student with ID 2:");
        studentManagement.editStudent(2, "Bobby", 9.2);
        studentManagement.displayStudents();

        // Deleting a student
        System.out.println("\nDeleting student with ID 3:");
        studentManagement.deleteStudent(3);
        studentManagement.displayStudents();

        // Searching for a student by ID
        System.out.println("\nSearching for student with ID 1:");
        studentManagement.searchStudentById(1);

        // Sorting students by marks
        System.out.println("\nSorting students by marks:");
        studentManagement.sortStudentsByMarks();
        studentManagement.displayStudents();
    }
}










