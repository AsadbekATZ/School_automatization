package service;

import model.Group;
import model.Student;

import java.util.UUID;

public class StudentService extends BaseService{
    public static Student[] students = new Student[1000];
    private int index = 0;

    @Override
    public boolean add(Object object) {
        Student student = (Student) object;
        for (Student student1 : students) {
            if(student1 != null){
                if(student1.getName().equals(student.getName())){
                    return false;
                }
            }
        }
        student.isActive = true;
        students[index++] = student;
        return true;
    }
    public Student login(String studentName, String password){
        for (Student student : students) {
            if(student != null){
                if(student.getName().equals(studentName) && student.password.equals(password)){
                    return student;
                }
            }
        }
        return null;
    }
    public boolean markAbsence(String studentName, int howManyLessons){
        for (Student student : students) {
            if(student != null){
                if (student.isActive && student.getName().equals(studentName)){
                    student.absence += howManyLessons;
                    if(student.absence >= 3){
                        student.isActive = false;
                        for (Group group : GroupService.groups) {
                            if(group != null){
                                if(group.getId().equals(student.groupId)){
                                    group.amountOfStudents--;
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    @Override
    public Object getById(UUID id) {
        for (Student student : students) {
            if(student != null){
                if(student.isActive && student.getId().equals(id)){
                    return student;
                }
            }
        }
        return null;
    }
}
