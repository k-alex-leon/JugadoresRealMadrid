package com.example.jugadoresrealmadrid;

public class Player {

    private String name;
    private int age;
    private int height;
    private String position;
    private String country;


    public Player(){}


    public Player(String name, int age, String position, String country, int height) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.country = country;
        this.height = height;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
