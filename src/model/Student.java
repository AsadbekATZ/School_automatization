package model;

import java.util.UUID;

public class Student extends BaseModel{
    public String password;
    public UUID groupId;
    public int absence;

    public boolean isActive;

    public Student(String name, String password, UUID groupId, int absence) {
        super(name);
        this.password = password;
        this.groupId = groupId;
        this.absence = absence;
        this.isActive = true;
    }

    @Override
    public String toString() {
        return "Student{" +
                "password='" + password + '\'' +
                ", groupId=" + groupId +
                ", absence=" + absence +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
