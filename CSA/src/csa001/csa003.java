package csa001;
import java.util.Scanner;

public class csa003 {
    public static void main(String[] args) {
        UseCompute as = new UseCompute();
        Jia jia = new Jia();
        Jian jian = new Jian();
        Cheng cheng = new Cheng();
        Chu chu = new Chu();
        as.useCom(jia,5,6);
        as.useCom(jian,7,6);
        as.useCom(cheng,5,6);
        as.useCom(chu,12,6);

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("请输入分数:");
            int score = scanner.nextInt();
            if (score < 0 || score > 100) {
                throw new ScoreScopeException("分数必须在0-100之间");
            }
            System.out.println("分数为:" + score);
        } catch (ScoreScopeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println();
        try {
            int n = scanner.nextInt();
            if (n<0){
                throw new IllegalArgumentException();
            }
            int a;
            double sum = 0;
            for (int i = 0; i < n; i++) {
                try {
                    a = scanner.nextInt();
                    if (a < 0) {
                        throw new IllegalArgumentException();
                    }
                    sum += a;
                } catch (IllegalArgumentException e) {
                    System.out.println("输入的数必须是正整数或0，请重新输入");
                    i -= 1;
                }
            }
            System.out.println("ave：" + sum / n);
        }catch (IllegalArgumentException e){
            System.out.println("输入的是有意义的整数量");
        }finally {
            scanner.close();
        }

        Man man = new Man("小明",10,new MyDate(2002, 12, 28));
        System.out.println(man);
        System.out.println();


    }
}
interface Compute{
    int computer(int n, int m);
}
class Jia implements Compute{
    public int computer(int n,int m){
        return n+m;
    }
}
class Jian implements Compute{
    public int computer(int n,int m){
        return (n-m);
    }
}
class Cheng implements Compute{
    public int computer(int n,int m){
        return (n*m);
    }
}
class Chu implements Compute{
    public int computer(int n,int m){
        return (n/m);
    }
}
class UseCompute{
    public void useCom(Compute com, int one, int two){
        int result = com.computer(one,two);
        System.out.println(one+"+"+two+"="+result);
    }
}
class ScoreScopeException extends RuntimeException{
    public ScoreScopeException() {
        super();
    }
    public ScoreScopeException(String message) {
        super(message);
    }
}

abstract class Employee {
    private String name;
    private int number;
    private MyDate birthday;


    public Employee(String name, int number, MyDate birthday) {
        super();
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public abstract double earnings();

    @Override
    public String toString() {
        return "name=" + name + ", number=" + number + ", birthday=" + birthday.toDateString();
    }

}
class MyDate {
    private int year;
    private int month;
    private int day;


    public MyDate(int year, int month, int day) {
        super();
        this.year = year;
        this.month = month;
        this.day = day;
    }


    public int getYear() {
        return year;
    }


    public void setYear(int year) {
        this.year = year;
    }


    public int getMonth() {
        return month;
    }


    public void setMonth(int month) {
        this.month = month;
    }


    public int getDay() {
        return day;
    }


    public void setDay(int day) {
        this.day = day;
    }


    public String toDateString(){
        return year + "年" + month + "月" + day + "日";
    }
}

class Man extends Employee{
    public Man(String name, int number, MyDate birthday) {
        super(name, number, birthday);
    }
    @Override
    public double earnings() {
        return 0;
    }
}