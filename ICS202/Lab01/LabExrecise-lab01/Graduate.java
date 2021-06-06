package com.company;

public class Graduate extends Student{

    private String status;

    public Graduate(){
        super();
    }

    public Graduate(int ID, double GPA){
        super(ID, GPA);
    }

    @Override
    public String getStatus() {
        if (super.getGPA() >= 3){
            return "Good";
        }else {
            return "Probation";
        }
    }


}
