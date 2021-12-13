package com.jerry.entity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * created by jerry on 2021-12-12
 */
@Component
public class User {
    public Integer ID;
    public String Name;
    public Integer Age;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Age=" + Age +
                '}';
    }
}
