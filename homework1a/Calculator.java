package ru.geekbrains.java_one.homework.homework1a;

public class Calculator {

    private float a;
    private float b;
    private float c;
    private float d;

    public Calculator(float a, float b, float c, float d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public float calcExpression(){
        return a*(b+(c/d));
    }

    public boolean calcSumInLimits(int a,int b){
        int sum = a+b;
        if(sum>=10 && sum <=20) {
            return true;
        }
        return false;
    }

    public void checkValueSign(int a){
        if(a>=0) System.out.println(a +" is positive number");
        else System.out.println(a +" is negative number");
    }

    public boolean isValueNegative(int a){
        if(a<0) return true;
        return false;
    }

    public void welcomeMessage(String name){
        System.out.println("Hello, "+ name+"!");
    }
    public void checkLeapYear(int year){
        if(year%4==0 && (!(year%100==0)||year%400==0)) {
           System.out.println(year+" Year is leap");

        }
        else System.out.println(year+" Year isn't leap");

    }
}
