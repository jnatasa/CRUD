/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part2;

import java.util.ArrayList;

class Subject {
    private Teacher teacher;
    private ArrayList<Student> students = new ArrayList<>();

    public Subject(Teacher teacher) {
        this.teacher = teacher;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
