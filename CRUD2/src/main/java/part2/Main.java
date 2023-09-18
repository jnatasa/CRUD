/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part2;

import java.util.ArrayList;
import java.util.InputMismatchException;
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

      public static void main(String[] args) {
        Teacher one = new Teacher("Kobe Bryant");
        Student frist = new Student("LeBron James");
        Student second = new Student("Lionel Messi");
        Student third = new Student("Kylian Mbappe");
        Subject subject1 = new Subject(one);
        subject1.addStudent(frist);
        subject1.addStudent(second);
        subject1.addStudent(third);

        teachers.add(one);
        students.add(frist);
        students.add(second);
        students.add(third);
        subjects.add(subject1);
          
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu");
            System.out.println("1. View Subjects");
            System.out.println("2. Add Teacher and/or Students");
            System.out.println("3. Update Teacher and/or Students");
            System.out.println("4. Delete Teacher and/or Students");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        viewSubjects();
                        break;
                    case 2:
                        addTeacherAndStudents(scanner);
                        break;
                    case 3:
                        updateTeacherAndStudents(scanner);
                        break;
                    case 4:
                        deleteTeacherAndStudents(scanner);
                        break;
                    case 5:
                        System.out.println("Exiting the application.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
                choice = 0; // Reset the choice to continue the loop
            }
        } while (choice != 5);

        scanner.close();
      }
       private static void viewSubjects() {
        System.out.println("Subjects:");
        for (Subject subject : subjects) {
            Teacher teacher = subject.getTeacher();
              ArrayList<Student> students = subject.getStudents();

            System.out.println("Teacher: " + teacher.getName());
            System.out.println("Students:");
            for (Student student : students) {
                System.out.println(student.getName());
            }
            System.out.println();
        }
       }
     private static void updateTeacherAndStudents(Scanner scanner) {
       System.out.println("Update teacher (Yes/No)?");
    String updateTeacherChoice = scanner.nextLine().trim();

    if (updateTeacherChoice.equalsIgnoreCase("yes")) {
        System.out.println("Enter the current Teacher's Name: ");
        String currentTeacherName = scanner.nextLine().trim();
        
        Teacher teacherToUpdate = findTeacherByName(currentTeacherName);

        if (teacherToUpdate != null) {
            System.out.println("Enter the new Teacher's Name: ");
            String newTeacherName = scanner.nextLine().trim();
            teacherToUpdate.setName(newTeacherName);
            System.out.println("Teacher's Name updated successfully.");
        } else {
            System.out.println("Teacher not found.");
        }
    }

    System.out.println("Update students (Yes/No)?");
    String updateStudentsChoice = scanner.nextLine().trim();

    if (updateStudentsChoice.equalsIgnoreCase("yes")) {
        System.out.println("Students:");
        int studentCount = 1;
        for (Student student : students) {
            System.out.println(studentCount + ". " + student.getName());
            studentCount++;
        }

        System.out.print("Enter the student number to update (1-" + (studentCount - 1) + "): ");
        int studentNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (studentNumber >= 1 && studentNumber < studentCount) {
            System.out.print("Enter the new Student's Name: ");
            String newStudentName = scanner.nextLine().trim();
            
            // Update the selected student's name
            Student selectedStudent = students.get(studentNumber - 1);
            selectedStudent.setName(newStudentName);
            
            System.out.println("Updated name: " + newStudentName);
        } else {
            System.out.println("Invalid student number.");
        }
    }
  
}
      
    private static void addTeacherAndStudents(Scanner scanner) {
    System.out.println("Enter Teacher's Name: ");
    String teacherName = scanner.nextLine();
    Teacher teacher = new Teacher(teacherName);

    System.out.println("Add Students (yes/no)?");
    String addStudentsChoice = scanner.nextLine();

    Subject subject = new Subject(teacher);
    teachers.add(teacher);
    subjects.add(subject);

    while (addStudentsChoice.equalsIgnoreCase("yes")) {
        System.out.println("Enter Student's Name: ");
        String studentName = scanner.nextLine();
        Student student = new Student(studentName);
        subject.addStudent(student);
        students.add(student);

        System.out.println("Add Another Student (yes/no)?");
        addStudentsChoice = scanner.nextLine();
    }

    System.out.println("Teacher and Students added successfully.");
}


private static void updateTeacherName(Scanner scanner) {
    System.out.print("Enter the current Teacher's Name: ");
    String currentName = scanner.nextLine();
    Teacher teacherToUpdate = findTeacherByName(currentName);

    if (teacherToUpdate != null) {
        System.out.println("Enter the new Teacher's Name: ");
        String newName = scanner.nextLine();
        teacherToUpdate.setName(newName);
        System.out.println("Teacher's Name updated successfully.");
    } else {
        System.out.println("Teacher not found.");
    }
}

private static void updateStudentName(Scanner scanner) {
    System.out.print("Enter the current Student's Name: ");
    String currentName = scanner.nextLine();
    Student studentToUpdate = findStudentByName(currentName);

    if (studentToUpdate != null) {
        System.out.println("Enter the new Student's Name: ");
        String newName = scanner.nextLine();
        studentToUpdate.setName(newName);
        System.out.println("Student's Name updated successfully.");
    } else {
        System.out.println("Student not found.");
    }
}

private static Teacher findTeacherByName(String name) {
    for (Teacher teacher : teachers) {
        if (teacher.getName().equals(name)) {
            return teacher;
        }
    }
    return null;
}

private static Student findStudentByName(String name) {
    for (Student student : students) {
        if (student.getName().equals(name)) {
            return student;
        }
    }
    return null;
}

private static void deleteTeacherAndStudents(Scanner scanner) {
    System.out.println("1. Delete Teacher");
    System.out.println("2. Delete Student");
    System.out.println("Enter your choice: ");
    int deleteChoice = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    switch (deleteChoice) {
        case 1:
            deleteTeacher(scanner);
            break;
        case 2:
            deleteStudent(scanner);
            break;
        default:
            System.out.println("Invalid choice.");
            break;
    }
}

private static void deleteTeacher(Scanner scanner) {
    System.out.println("Enter Teacher's Name to delete: ");
    String teacherName = scanner.nextLine();
    Teacher teacherToDelete = findTeacherByName(teacherName);

    if (teacherToDelete != null) {
        teachers.remove(teacherToDelete);
        // Remove associated subjects
        subjects.removeIf(subject -> subject.getTeacher() == teacherToDelete);
        System.out.println("Teacher deleted successfully.");
    } else {
        System.out.println("Teacher not found.");
    }
}

private static void deleteStudent(Scanner scanner) {
    System.out.println("Enter Student's Name to delete: ");
    String studentName = scanner.nextLine();
    Student studentToDelete = findStudentByName(studentName);

    if (studentToDelete != null) {
        students.remove(studentToDelete);
        // Remove the student from all associated subjects
        for (Subject subject : subjects) {
            subject.getStudents().removeIf(student -> student == studentToDelete);
        }
        System.out.println("Student deleted successfully.");
    } else {
        System.out.println("Student not found.");
    }
}
}