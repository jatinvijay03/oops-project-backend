package com.example.oopsprojectbackend.user;
import javax.persistence.*;


public class UserPassUpdate{
    private Long uid;
    private String newpass;
    private String password;

    public UserPassUpdate() {
    }

    public UserPassUpdate(Long uid, String newpass, String password) {
        this.uid = uid;
        this.newpass = newpass;
        this.password = password;
    }


    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getNewpass() {
        return newpass;
    }

    public void setNewpass(String newpass) {
        this.newpass = newpass;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "UserPassUpdate{" +
                "uid=" + uid +
                ", newpass='" + newpass + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
