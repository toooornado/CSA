package csa001;
import java.util.Scanner;
public class csa001 {
    public static void main(String[] args) {
        //打印选择题答案
        System.out.println("1、 第一答案 2、第二答案 . . .") ;

        //每个编程题都要调用
        showTriangle(10);
        isPalindrome(121) ;
        System.out.println("您输入的数字是：");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        reverseSUM(s);
        System.out.println();
        ShuiXianHua();
        System.out.println();
        arraysDemo();
        //思考如果函数是有返回值呢， 以及如果函数定义中没有加static还可以直接调用吗？
    }
    //杨辉三角
    public static void showTriangle(int n){
        System.out.println("n="+n);
        for(int i=1;i<=n;i++){
            //打印空格，
            for(int z=1;z<=n-i;z++){
                System.out.print(" ");//输出空格
            }
            //第三步：打印*号
            for(int j=1;j<=(2*i-1);j++) {
                System.out.print("*");//输出*号
            }
            System.out.println();//不输出内容，只进行换行操作
        }
    }
    //回文数
    public static void isPalindrome(int num) {
        boolean flag = false;
        int mun = 0;
        int temp = num;
        while (temp!=0){
            int n = temp%10;
            mun = mun*10+n;
            temp = temp/10;
        }
        if(mun==num){
            flag = true;
        }

        if (flag) {
            System.out.println(num+":是的") ; } else
            System.out.println(num+":不是") ;
    }
    //求位数，逆序输出
    public static void reverseSUM(String s) {
        char arr[] = s.toCharArray();
        int mid = arr.length / 2;
        for (int i = 0;i < mid;i ++) {
            char temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        System.out.println("您输入的正整数的位数是：" + arr.length);
        System.out.print("您输入的正整数的逆序是：" );
        for (char element : arr)
            System.out.print(element);

    }
    //水仙花数
    public static void ShuiXianHua() { //思考哪些数是水仙花
        int a, sum;
        int i, j, k;
        for (a = 100; a<=999; a++) {
            i = a / 100;
            j = (a - i * 100) / 10;
            k = a - i * 100 - j * 10;
            sum = i * i * i + j * j * j + k * k * k;
            if (sum == a){
                System.out.print(a+" ");
            }
        }

    }
    //最小最大值和
    public static void arraysDemo() { //操作
        int array[] = new int[10];
        System.out.println("数组的元素为：");
        for (int i=0;i<array.length;i++){
            //为数组元素赋予随机数
            array[i] = (int) (Math.random()*100);
            System.out.print(array[i]+" ");
        }
        int min=0;
        int max=0;
        for(int j=0;j<array.length;j++){
            int value = array[j];
            if (value<min){
                min = value;

            }
            if (value>max){
                max = value;

            }
        }
        System.out.println("max:"+max);
        System.out.println("min:"+min);
        int sum =max+min;
        System.out.println("sum:"+sum);

    }
}