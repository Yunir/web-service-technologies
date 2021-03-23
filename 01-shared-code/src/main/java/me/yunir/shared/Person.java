package me.yunir.shared;

/**
 * POJO, соответствует сущности, описанной в таблице persons базы данных
 */
public class Person {
    private String name;
    private String surname;
    private String email;
    private String phone;
    private int age;

    public Person() {
    }

    public Person(String name, String surname, String email, String phone, int age) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() { return email; }

    public String getPhone() { return phone; }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) { this.email = email; }

    public void setPhone(String phone) { this.phone = phone; }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", surname=" + surname + ", email=" + email + ", phone=" + phone + ", age=" + age + '}';
    }
}
