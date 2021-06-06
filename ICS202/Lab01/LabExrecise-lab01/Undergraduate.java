package com.company;

public class Undergraduate extends Student{

    private String status;

    public Undergraduate(){
        super();
    }

    public Undergraduate(int ID, double GPA){
        super(ID, GPA);
    }

    @Override
    public String getStatus() {
        if(super.getGPA() >= 3){
            return "Honor";
        }else if (super.getGPA() >= 2){
            return "Good";
        }else{
            return "Probation";
        }
    }


}
