package com.yy.yycustom.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserBean implements Serializable {

    private String uid;

    private  String uname;

    private String uphone;


    public String getUid() {
        return uid;
    }

    public String getUname() {
        return uname;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "uid='" + uid + '\'' +
                ", uname='" + uname + '\'' +
                ", uphone='" + uphone + '\'' +
                '}';
    }
}
