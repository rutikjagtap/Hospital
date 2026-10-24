package com.accio.SpringProject.Hospital.Entity;

public class Patient {
    String name;
    int age;
    long id;

    public Patient(){
    }
    public Patient(String name, int age,long id){
        this.name=name;
        this.age=age;
        this.id=id;
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
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
