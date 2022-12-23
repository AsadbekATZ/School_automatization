package model;

import java.util.UUID;

public class Teacher extends BaseModel{
    public String password;
    public int yearsOfXP;
    public String whichBranch;
    public String whichCourse;
    public String whichGroup;
    public UUID groupId;
    public double salary;

    public Teacher(String name, String password, int yearsOfXP, String whichBranch, String whichCourse, String whichGroup, UUID groupId) {
        super(name);
        this.password = password;
        this.yearsOfXP = yearsOfXP;
        this.whichBranch = whichBranch;
        this.whichCourse = whichCourse;
        this.whichGroup = whichGroup;
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "password='" + password + '\'' +
                ", yearsOfXP=" + yearsOfXP +
                ", whichBranch='" + whichBranch + '\'' +
                ", whichCourse='" + whichCourse + '\'' +
                ", whichGroup='" + whichGroup + '\'' +
                ", groupId=" + groupId +
                ", salary=" + salary +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
