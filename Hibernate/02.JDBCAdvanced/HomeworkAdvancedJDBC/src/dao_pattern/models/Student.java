package dao_pattern.models;

/**
 * Created by vladix on 5/20/17.
 */
public class Student {

    private int id;

    private String name;

    public Student() {
    }

    public Student(int id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Id: %d; Name: %s", this.getId(), this.getName());
    }
}
