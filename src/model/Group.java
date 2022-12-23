package model;

import java.util.UUID;

public class Group extends BaseModel{
    public int capacity;
    public String groupTeacherName;
    public int amountOfStudents;
    public UUID courseId;

    public Group(String name, int capacity, String groupTeacherName, UUID courseId, int amountOfStudents) {
        super(name);
        this.capacity = capacity;
        this.groupTeacherName = groupTeacherName;
        this.courseId = courseId;
        this.amountOfStudents = amountOfStudents;
    }

    @Override
    public String toString() {
        return "Group{" +
                "capacity=" + capacity +
                ", groupTeacherName='" + groupTeacherName + '\'' +
                ", courseId=" + courseId +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
