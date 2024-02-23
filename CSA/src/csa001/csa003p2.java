package csa001;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class csa003p2 {

    public static boolean isSbuseq(String s,String target){
        //判断目标字符串是否为s的字串
        int s1 = s.length();
        int s2 = target.length();
        int temp = 0; //记录指针移动位置
        if (s1 == s2 && s.equals(target)){
            return true;
        }else {
            for (int i = 0; i < s2; i++) {
                boolean flag = false;//标志位
                for (int j = temp; j < s1; j++) {
                    if (s.charAt(j)==target.charAt(i)){
                        //匹配成功
                        flag = true;
                        temp = j+1;//记录j的位置
                        break;
                    }
                }
                if (!flag) return false;
            }
        }
        return true;
    }
    public static int numMatchingSubseq(String s, String[] words) {
        int count = 0; //记录结果
        for (int i = 0; i < words.length; i++) {
            if (isSbuseq(s,words[i])) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numMatchingSubseq("abcde",new String[]{"a","bb","acd","ace"}));
    }

}

