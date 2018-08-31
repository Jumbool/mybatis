package com.itheima.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable {

    private Integer id ;
    private String usrname;
    private String sex;
    private Date birthday;
    private String address;
    private List<Account> accounts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", usrname='" + usrname + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }
}
