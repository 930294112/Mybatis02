package com.lanou.domain;

/**
 * Created by dllo on 17/11/3.
 */
public class User {
    private int id; //主键
    private String loginName; //登录名
    private String loginPassword;//密码
    private String gender;//性别
    private int age;//年龄

    public User() {
    }

    public User(String loginName, String password, String gender, int age) {

        this.loginName = loginName;
        this.loginPassword = password;
        this.gender = gender;
        this.age = age;
    }

    public User(int id, String loginName, String password, String gender, int age) {

        this.id = id;
        this.loginName = loginName;
        this.loginPassword = password;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
