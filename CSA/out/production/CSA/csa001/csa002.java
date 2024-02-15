package csa001;

import java.util.Scanner;

public class csa002 {
    public static void main(String[] args) {
        Book csa002 = new Book("csa002", "Xiongfeng", 2024);
        csa002.displayInfo();
        System.out.println();
        Truck truck = new Truck(8,500,4,400);
        System.out.println(truck);
        Car car = new Car(4,200,3);
        System.out.println(car);
        Vehicle vehicle = new Vehicle(2,300);
        System.out.println(vehicle);
        System.out.println();
        Calculator c = new Calculator();
        double m = c.add(5,10);
        double n=c.multiply(m,2);
        double l=c.divide(n,3);
        System.out.println("5+10*2/3="+l);
        System.out.println();
        String[] strs =new String[]{"flower","flow","flight"};
        maxss i = new maxss();
        System.out.println(i.max(strs));
    }
}
class Book{
    String title;
    String author;
    int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public void displayInfo() {
        System.out.println("title:" + title+"Author: " + author+"Year: " + year);
    }
}
class Vehicle {
    protected int wheels;
    protected double weight;

    public Vehicle(int wheels, double weight) {
        this.wheels = wheels;
        this.weight = weight;
    }

    public String toString() {
        return "Vehicle[wheels=" + wheels + ", weight=" + weight + "]";
    }
}
class Car extends Vehicle {
    protected int loader;

    public Car(int wheels, double weight, int loader) {
        super(wheels, weight);
        this.loader = loader;
    }

    public String toString() {
        return "Car[loader=" + loader + ", wheels=" + wheels + ", weight=" + weight +"]";
    }
}
class Truck extends Car {
    private double payload;

    public Truck(int wheels, double weight, int loader, double payload) {
        super(wheels, weight, loader);
        this.payload = payload;
    }

    public String toString() {
        return "Truck[" +
                "payload=" + payload +
                ", loader=" + loader +
                ", wheels=" + wheels +
                ", weight=" + weight +
                "]";
    }
}
class Calculator {

    public double add(double num1, double num2) {
        return (num1 + num2);
    }

    public double subtraction(double num1, double num2) {
        return (num1 - num2);
    }

    public double multiply(double num1, double num2) {
        return (num1 * num2);
    }

    public double divide(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("除数不能为0!");
            return 0;
        } else {
            return (num1 / num2);
        }
    }

}
class maxss {
    String max(String[] strs) {
        if (strs.length == 0 || strs == null) {
            return "";
        }
        //第一个字符串的长度
        int len = strs[0].length();
        //数组里有几个元素
        int legth = strs.length;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < legth; j++) {
                //strs[j].length() == i 表示当前字符串的长度小于strs[0]的长度
                if (strs[j].length() == i || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

}
