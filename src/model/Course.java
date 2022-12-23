package model;

import java.util.UUID;

public class Course extends BaseModel{
    public double coursePrice;

    public UUID branchId;

    public Course(String name, double coursePrice, UUID branchId) {
        super(name);
        this.coursePrice = coursePrice;
        this.branchId = branchId;
    }

    @Override
    public String toString() {
        return "Course{" +
                ", coursePrice=" + coursePrice +
                ", branchId=" + branchId +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
