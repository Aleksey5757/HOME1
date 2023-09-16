package UXCrowd.api;

public class UserData {

    private Integer id;
    private String firstName;
    private String secondName;
    private Integer age;
    private String sex;
    private Double money;

    public UserData() {
    }
    public UserData(Integer id, String firstName, String secondName, Integer age, String sex, Double money) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.sex = sex;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Integer getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public Double getMoney() {
        return money;
    }
}
