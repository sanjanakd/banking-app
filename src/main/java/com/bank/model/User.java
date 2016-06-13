package com.bank.model;

import javax.persistence.*;

/**
 * Created by XKT676 on 5/7/2016.
 */
@Entity
@Table(name = "USERS")
public class User implements Comparable {


    public static final int INVALID_ID = -1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id = INVALID_ID;
    private String name;
    private int age;

    public static int getInvalidId() {
        return INVALID_ID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
