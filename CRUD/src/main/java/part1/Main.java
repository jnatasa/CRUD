

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author integ
 */
public class Main {
    private Scanner scanner;
    private List<Student> students;
    
  public Main() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);   

        Student student1 = new Student("Cristiano Ronaldo", 111);
        Student student2 = new Student("Lionel Messi", 222);
        Student student3 = new Student("Kylian Mbappe", 333);
        Student student4 = new Student("Erling Haaland", 444);
        Student student5 = new Student("Roger Federer", 555);
        
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
    }
   private void displayMenu() {
        int option;
        do {
            System.out.println("Menu");
            System.out.println("1. View Students");
            System.out.println("2. Add Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: " );
            

            try {
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        viewStudents();
                        break;
                    case 2:
                        addStudent();
                        break;
                    case 3:
                        updateStudent();
                        break;      
                    case 4:
                        deleteStudent();
                        break;
                    case 5:
                        System.out.println("Exit menu");
                        break;
                    default:
                        System.out.println("False. Try again.");
                }
            } catch (Exception e) {
                System.out.println("False. Please enter a valid option (1 to 5).");
                scanner.nextLine(); 
                option = -1; 
            }

            System.out.println();
        } while (option != 5);
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            students.forEach(student -> {
                student.displayStudentInfo();
            });
        }
    }

    public void addStudent() {
        System.out.println("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.println("Enter student ID: ");
        int studentID = scanner.nextInt();
        scanner.nextLine(); 

        Student newStudent = new Student(studentName, studentID);
        students.add(newStudent);
        System.out.println("Student added successfully!");
    }

    public void updateStudent() {
        System.out.println("Student name you want to change: ");
        String studentNameToUpdate = scanner.nextLine();

        for (Student student : students) {
            if (student.getName().equals(studentNameToUpdate)) {
                System.out.println("Enter new student name: ");
                String newStudentName = scanner.nextLine();
                System.out.println("Enter new student ID: ");
                int newStudentID = scanner.nextInt();
                scanner.nextLine(); 
                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student was not found.");
    }

    public void deleteStudent() {
        System.out.println("Delete a student: ");
        String studentNameToDelete = scanner.nextLine();

        for (Student student : students) {
            if (student.getName().equals(studentNameToDelete)) {
                students.remove(student);
                System.out.println("Student deleted!");
                return;
            }
        }

        System.out.println("Student not found.");
    
    }
        public static void main(String[] args) {
        Main app = new Main();
        app.displayMenu();
    }
}