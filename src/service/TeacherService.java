package service;

import model.Course;
import model.Group;
import model.Teacher;

import java.util.UUID;

public class TeacherService extends BaseService{
    public static Teacher[] teachers = new Teacher[100];
    private int index = 0;

    @Override
    public boolean add(Object object) {
        Teacher teacher = (Teacher) object;
        for (Teacher teacher1 : teachers) {
            if(teacher1 != null){
                if(teacher1.getName().equals(teacher.getName())){
                    return false;
                }
            }
        }
        teachers[index++] = teacher;
        return true;
    }

    public Teacher login(String teacherName, String password){
        for (Teacher teacher : teachers) {
            if(teacher != null){
                if(teacher.getName().equals(teacherName) && teacher.password.equals(password)){
                    return teacher;
                }
            }
        }
        return null;
    }
    public double SalaryIdentifier(int yearsOfXP, Course course, Group group, int yearsOfxp){
        double salary = 0;
        if(yearsOfXP <= 1){
            salary = course.coursePrice * group.amountOfStudents * 0.3;
        }
        if(yearsOfXP <= 2){
            salary = course.coursePrice * group.amountOfStudents * 0.4;
        }
        if(yearsOfXP > 2){
            salary = course.coursePrice * group.amountOfStudents * 0.5;
        }
        return salary;
    }
    @Override
    public Object getById(UUID id) {
        for (Teacher teacher : teachers) {
            if(teacher != null){
                if(teacher.getId().equals(id)){
                    return teacher;
                }
            }
        }
        return null;
    }
}
