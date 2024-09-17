package org.bazaarBackend.User.Dtos;

import org.bazaarBackend.User.Models.User;

public class UserDto {


    private Integer id;

    private String name;

    private String email;

    private  String gender;

    private  String status;

    private Integer age;

    private String password;

    public  UserDto(User user) {
        id = user.getId();
        name = user.getName();
        age = user.getAge();
        email = user.getEmailId();
    }

    public UserDto() {

    }

//    public UserDto(String name, String email, String gender, String status, String password) {
//        this.name = name;
//        this.email = email;
//        this.gender = gender;
//        this.status = status;
//        this.password = password;
//    }


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
