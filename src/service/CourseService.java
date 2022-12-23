package service;

import model.Course;

import java.util.UUID;

public class CourseService extends BaseService{
    public static Course[] courses =  new Course[100];
    private int index = 0;

    @Override
    public boolean add(Object object) {
        Course course = (Course) object;
        for (Course course1 : courses) {
            if(course1 != null){
                if(course1.getName().equals(course.getName())){
                    return false;
                }
            }
        }
        courses[index++] = course;
        return true;
    }

    public Course login(String courseName){
        for (Course course : courses) {
            if (course != null){
                if(course.getName().equals(courseName)){
                    return course;
                }
            }
        }
        return null;
    }

    @Override
    public Object getById(UUID id) {
        for (Course course : courses) {
            if(course != null){
                if(course.getId().equals(id)){
                    return course;
                }
            }
        }
        return null;
    }
}
