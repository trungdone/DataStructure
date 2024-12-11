package org.example;

import java.util.ArrayList;
import java.util.Random;

public class StudentManagement {
    private ArrayList<Student> students;

    public StudentManagement() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("✅ Student added: " + student);
    }

    public void generateRandomStudents(int count) {
        Random random = new Random();
        String[] names = {"Nguyen Van A", "Tran Thi B", "Le Van C", "Pham Thi D", "Hoang Van E", "Dang Thi F"};

        for (int i = 1; i <= count; i++) {
            int id = i; // ID increasing sequentially from 1
            String name = names[random.nextInt(names.length)] + " " + i; // Random name
            double marks = 1 + (9 * random.nextDouble()); // Marks between 1.0 and 10.0
            addStudent(new Student(id, name, Math.round(marks * 100.0) / 100.0)); // Round to 2 decimal places
        }
        System.out.println("✅ Randomly created " + count + " students.");
    }

    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("❌ The student list is empty! Nothing to display.");
            return;
        }
        System.out.println("✅ List of all students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void updateStudent(int id, String newName, double newMarks) {
        boolean found = false;
        for (Student student : students) {
            if (student.getId() == id) {
                students.set(students.indexOf(student), new Student(id, newName, newMarks));
                System.out.println("✅ Updated student with ID: " + id);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("❌ Student with ID " + id + " not found.");
        }
    }

    public void deleteStudent(int id) {
        boolean removed = students.removeIf(student -> student.getId() == id);
        if (removed) {
            System.out.println("✅ Deleted student with ID: " + id);
        } else {
            System.out.println("❌ Student with ID " + id + " not found.");
        }
    }

    public Student searchStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println("✅ Found student: " + student);
                return student;
            }
        }
        System.out.println("❌ Student with ID " + id + " not found.");
        return null;
    }

    public void sortStudentsBubbleSort() {
        if (students.isEmpty()) {
            System.out.println("❌ The student list is empty! Cannot sort.");
            return;
        }

        Student[] studentArray = students.toArray(new Student[0]);

        long startTime = System.nanoTime();

        // Bubble Sort
        for (int i = 0; i < studentArray.length - 1; i++) {
            for (int j = 0; j < studentArray.length - i - 1; j++) {
                if (studentArray[j].getMarks() < studentArray[j + 1].getMarks()) {
                    // Swap students[j] and students[j + 1]
                    Student temp = studentArray[j];
                    studentArray[j] = studentArray[j + 1];
                    studentArray[j + 1] = temp;
                }
            }
        }
        long endTime = System.nanoTime();

        // Convert array back to ArrayList
        students.clear();
        for (Student student : studentArray) {
            students.add(student);
        }

        System.out.println("✅ Students sorted by marks in descending order using Bubble Sort.");
        System.out.println("⏱ Time taken: " + (endTime - startTime) + " ns.");
    }

    public void sortStudentsMergeSort() {
        if (students.isEmpty()) {
            System.out.println("❌ The student list is empty! Cannot sort.");
            return;
        }

        long startTime = System.nanoTime();

        Student[] studentArray = students.toArray(new Student[0]);
        mergeSort(studentArray, 0, studentArray.length - 1);
        long endTime = System.nanoTime();

        students.clear();
        for (Student student : studentArray) {
            students.add(student);
        }

        System.out.println("✅ Students sorted by marks in descending order using Merge Sort.");
        System.out.println("⏱ Time taken: " + (endTime - startTime) + " ns.");
    }

    private void mergeSort(Student[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    private void merge(Student[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Student[] leftArray = new Student[n1];
        Student[] rightArray = new Student[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i].getMarks() >= rightArray[j].getMarks()) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}












