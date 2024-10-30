package org.example;
import java.util.ArrayList;
import java.util.Comparator;

public class StudentStack {
    private ArrayList<Student> students;

    public StudentStack() {
        students = new ArrayList<>();
    }

    // Add a new student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Added: " + student);
    }

    // Edit student information by ID
    public void editStudent(int id, String newName, double newMarks) {
        for (Student student : students) {
            if (student.getId() == id) {
                students.set(students.indexOf(student), new Student(id, newName, newMarks));
                System.out.println("Updated student with ID " + id);
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // Delete a student by ID
    public void deleteStudent(int id) {
        boolean removed = students.removeIf(student -> student.getId() == id);
        if (removed) {
            System.out.println("Deleted student with ID " + id);
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Search for a student by ID
    public void searchStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println("Found: " + student);
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // Sort students by marks in descending order
    public void sortStudentsByMarks() {
        students.sort(Comparator.comparingDouble(Student::getMarks).reversed());
        System.out.println("Sorted students by marks.");
    }

    // Display all students
    public void displayStudents() {
        System.out.println("Student list:");
        for (Student student : students) {
            System.out.println(student);
        }
    }


    // Check if the stack is empty
    public boolean isEmpty() {
        return students.isEmpty();
    }

    // Pop a student from the stack
    public Student pop() {
        if (!students.isEmpty()) {
            return students.remove(students.size() - 1);
        } else {
            System.out.println("Stack is empty.");
            return null;
        }
    }

    // Peek at the top student in the stack
    public Student peek() {
        if (!students.isEmpty()) {
            return students.get(students.size() - 1);
        } else {
            System.out.println("Stack is empty.");
            return null;
        }
    }

    // Test method
    public static void main(String[] args) {
        StudentStack stack = new StudentStack();

        // Test isEmpty() on an empty stack
        System.out.println("Is stack empty? " + stack.isEmpty());

        // Add a student and test push operation
        stack.addStudent(new Student(1, "Alice", 85));
        System.out.println("Is stack empty after adding a student? " + stack.isEmpty());

        // Peek at the top student
        System.out.println("Top student: " + stack.peek());

        // Pop the top student
        System.out.println("Popped student: " + stack.pop());

        // Try to pop again from an empty stack
        System.out.println("Popped student from empty stack: " + stack.pop());
    }
}




