/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part2;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author integ
 */
public class Main {
     private static List<Teacher> teachers = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();
    private static List<Subject> subjects = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

     private static void initializeSubjects() {
        Teacher mathTeacher = new Teacher("Cristiano Ronaldo");
        Teacher musicTeacher = new Teacher("Kobe Bryant");
        Teacher englishTeacher = new Teacher("Kylian Mbappe");

        Subject mathSubject = new Subject("Math", mathTeacher);
        Subject musicSubject = new Subject("Music", musicTeacher);
        Subject englishSubject = new Subject("English", englishTeacher);

           Student student1 = new Student("LeBron James");
           Student student2 = new Student("Lionel Messi");
           Student student3 = new Student("Luka Nodric");
        
        subjects.add(mathSubject);
        subjects.add(musicSubject);
        subjects.add(englishSubject);
        
        teachers.add(mathTeacher);
        teachers.add(musicTeacher);
        teachers.add(englishTeacher);

 
        students.add(student1);
        students.add(student2);
        students.add(student3);
    }
    
    public static void main(String[] args) {
        

         while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    viewSubjects();
                    break;
                case 2:
                    addTeacherAndStudents();
                    break;
                case 3:
                    updateTeacherOrStudents();
                    break;
                case 4:
                    deleteTeacherOrStudents();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Menu");
        System.out.println("1. View Subjects");
        System.out.println("2. Add Teacher and/or Students");
        System.out.println("3. Update Teacher and/or Students");
        System.out.println("4. Delete Teacher and/or Students");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void viewSubjects() {
        System.out.println("---------------------------------");
        for (Subject subject : subjects) {
            System.out.println("Subject: " + subject.getName());
            System.out.println("Teacher: " + subject.getTeacher().getName());
            System.out.println("Students:");
            for (Student student : subject.getStudents()) {
                System.out.println(student.getName());
            }
            System.out.println("---------------------------------");
        }
    }

    private static void addTeacherAndStudents() {
        System.out.print("Add new teacher: ");
        String teacherName = scanner.nextLine();
        Teacher teacher = new Teacher(teacherName);
        teachers.add(teacher);

        System.out.print("Add new student: ");
        String studentName = scanner.nextLine();
        Student student = new Student(studentName);
        students.add(student);

        Subject subject = new Subject("New Subject", teacher);
        subject.addStudent(student);
        subjects.add(subject);

        while (true) {
            System.out.print("Add more students (Yes/No)? ");
            String moreStudents = scanner.nextLine();
            if (moreStudents.equalsIgnoreCase("No")) {
                break;
            } else if (moreStudents.equalsIgnoreCase("Yes")) {
                System.out.print("Add new student: ");
                studentName = scanner.nextLine();
                student = new Student(studentName);
                students.add(student);
                subject.addStudent(student);
            } else {
                System.out.println("Invalid choice. Please enter Yes or No.");
            }
        }
    }

    private static void updateTeacherOrStudents() {
        System.out.print("Update teacher (Yes/No)? ");
        String updateTeacher = scanner.nextLine();
        if (updateTeacher.equalsIgnoreCase("Yes")) {
            viewTeachers();
            System.out.print("Enter the index of the teacher to update: ");
            int teacherIndex = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (teacherIndex >= 0 && teacherIndex < teachers.size()) {
                System.out.print("Enter the new name for the teacher: ");
                String newTeacherName = scanner.nextLine();
                teachers.get(teacherIndex).setName(newTeacherName);
                System.out.println("Teacher updated successfully.");
            } else {
                System.out.println("Invalid teacher index.");
            }
        }

        System.out.print("Update students (Yes/No)? ");
        String updateStudents = scanner.nextLine();
        if (updateStudents.equalsIgnoreCase("Yes")) {
            viewStudents();
            System.out.print("Enter the index of the student to update: ");
            int studentIndex = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (studentIndex >= 0 && studentIndex < students.size()) {
                System.out.print("Enter the new name for the student: ");
                String newStudentName = scanner.nextLine();
                students.get(studentIndex).setName(newStudentName);
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("Invalid student index.");
            }
        }
    }

    private static void deleteTeacherOrStudents() {
        System.out.print("Delete teacher (Yes/No)? ");
        String deleteTeacher = scanner.nextLine();
        if (deleteTeacher.equalsIgnoreCase("Yes")) {
            viewTeachers();
            System.out.print("Enter the index of the teacher to delete: ");
            int teacherIndex = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (teacherIndex >= 0 && teacherIndex < teachers.size()) {
                teachers.remove(teacherIndex);
                System.out.println("Teacher deleted successfully.");
            } else {
                System.out.println("Invalid teacher index.");
            }
        }

        System.out.print("Delete students (Yes/No)? ");
        String deleteStudents = scanner.nextLine();
        if (deleteStudents.equalsIgnoreCase("Yes")) {
            viewStudents();
            System.out.print("Enter the index of the student to delete: ");
            int studentIndex = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (studentIndex >= 0 && studentIndex < students.size()) {
                students.remove(studentIndex);
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Invalid student index.");
            }
        }
    }

    private static void viewTeachers() {
        System.out.println("Teachers:");
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println(i + ". " + teachers.get(i).getName());
        }
        System.out.println("---------------------------------");
    }

    private static void viewStudents() {
        System.out.println("Students:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(i + ". " + students.get(i).getName());
        }
        System.out.println("---------------------------------");
    }
}

