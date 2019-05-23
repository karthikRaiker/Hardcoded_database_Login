package com.example.exma6hardcode;

public class User {
    int id;
    String user,password;

    public User(String unm, String pwd) {
        this.id=id;
        this.user =unm;
        this.password=pwd;

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName() {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword()
    {
        this.password = password;
    }
}
