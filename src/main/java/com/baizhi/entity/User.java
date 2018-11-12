package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

public class User {
    private String id;
    private String phoneNum;
    private String username;
    private String password;
    private String province;
    private String city;
    private String nikName;
    private String sex;
    private String sign;
    private String headPic;
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private String regdate;
    private String salt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNikName() {
        return nikName;
    }

    public void setNikName(String nikName) {
        this.nikName = nikName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public User(String id, String phoneNum, String username, String password, String province, String city, String nikName, String sex, String sign, String headPic, String status, String regdate, String salt) {
        this.id = id;
        this.phoneNum = phoneNum;
        this.username = username;
        this.password = password;
        this.province = province;
        this.city = city;
        this.nikName = nikName;
        this.sex = sex;
        this.sign = sign;
        this.headPic = headPic;
        this.status = status;
        this.regdate = regdate;
        this.salt = salt;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", nikName='" + nikName + '\'' +
                ", sex='" + sex + '\'' +
                ", sign='" + sign + '\'' +
                ", headPic='" + headPic + '\'' +
                ", status='" + status + '\'' +
                ", regdate='" + regdate + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
