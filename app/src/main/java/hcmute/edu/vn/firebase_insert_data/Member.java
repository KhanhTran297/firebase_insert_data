package hcmute.edu.vn.firebase_insert_data;

public class Member {
    private String Name;
    private Integer Age;
    private Long Phone;
    private Float Height;

    public void setAge(Integer age) {
        Age = age;
    }

    public void setHeight(Float height) {
        Height = height;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPhone(Long phone) {
        Phone = phone;
    }

    public Float getHeight() {
        return Height;
    }

    public Integer getAge() {
        return Age;
    }

    public Long getPhone() {
        return Phone;
    }

    public String getName() {
        return Name;
    }

}
