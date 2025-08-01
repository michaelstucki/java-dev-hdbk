package ch04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentRecordManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        manager.addStudent(new Student("S001", "Michael", 64));
        manager.addStudent(new Student("S002", "Phally", 54));
        manager.viewStudents();

        System.out.print("Enter student ID: ");
        String id = sc.nextLine();
        manager.viewStudent(id);
    }
}

class Student {
    String id;
    String name;
    int age;

    Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    String getId() { return id; }
    String getName() { return name; }
    int getAge() { return age; }

    @Override
    public String toString() { return getId() + " " + getName() + " " + getAge(); }
}

class StudentManager {
    Map<String, Student> students = new HashMap<>();
    void addStudent(Student student) { students.put(student.getId(), student); }
    void viewStudents() { students.values().forEach(System.out::println); }
    void viewStudent(String id) {
        Student student = students.get(id);
        if (student != null) System.out.println(student);
        else System.out.println("Student ID: " + id + " not found.");
    }
}
