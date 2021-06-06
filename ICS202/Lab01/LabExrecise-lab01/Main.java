package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner kb= new Scanner(System.in);
        String status; int ID; double GPA;
        ArrayList<Integer> list= new ArrayList<>();

        for(int i = 0; i < 10; i++){
            list.add(i);
        }

        Collections.shuffle(list);
        Student[] students= new Student[10];
        Random r= new Random();
        for(int i= 0; i < students.length; i++){

            if((new Random().nextInt(2) + 1) == 1){
                ID= new Random().nextInt(202099999 - 201600000  + 1) + 201600000;
                GPA= randomGPA();
                students[i]= new Graduate(ID, GPA);
            }else{
                ID= new Random().nextInt(202099999 - 201600000 + 1) + 201600000;
                GPA= randomGPA();
                students[i]= new Undergraduate(ID, GPA);
            }
        }

        for (int i= 0; i < students.length; i++){
            students[i].displayStudent();
        }
    }

    public static double randomGPA(){
        return (Math.random() * (4 - 0) +0);
    }
}
