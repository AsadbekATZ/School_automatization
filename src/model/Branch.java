package model;

public class Branch extends BaseModel{
    public String location;

    public Branch(String name, String location) {
        super(name);
        this.location = location;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "location='" + location + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
