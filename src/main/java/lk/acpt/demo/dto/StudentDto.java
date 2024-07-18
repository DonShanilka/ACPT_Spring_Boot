package lk.acpt.demo.dto;

public class StudentDto {
    private Integer id;
    private String name;
    private String address;
    private double marks;

    public StudentDto(Integer id, String name, String address, double marks) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.marks = marks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
}
