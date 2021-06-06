package com.company;

public abstract class Student {

    private int ID;
    private double GPA;

    public Student(){

    }

    public Student(int ID, double GPA){
        this.ID= ID;
        this.GPA= GPA;
    }

    public int getID(){
        return ID;
    }

    public double getGPA(){
        return GPA;
    }

    public abstract String getStatus();

    public final void displayStudent(){
        System.out.printf("ID: %d, GPA: %.2f, Status: %s\n", getID(), getGPA(), getStatus());
    }
}
