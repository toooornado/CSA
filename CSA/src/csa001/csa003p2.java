package csa001;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class csa003p2 {

    public static boolean isSbuseq(String s,String target){
        //判断目标字符串是否为s的字串
        //法一 暴力破解
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
    //方法二 多指针，考虑将字符串数组 words中的全部字符串和字符串 s同时进行匹配（好思路，只需要遍历一遍字符串s）
    public static int numMatchingSubseq1(String s, String[] words) {
        int count = 0; //记录个数
        Queue<int[]>[] queues = new Queue[26]; //使用26个队列数组实现指针的同时的移动
        for (int i = 0; i < 26; i++) {//初始化队列数组
            queues[i] = new ArrayDeque<int[]>();
        }
        for (int i = 0; i < words.length; i++) {//将words中的所有字符串的第一个字符加入
            int temp = words[i].charAt(0)-'a';//表示当前第一个元素的位置
            queues[temp].offer(new int[]{i,0});//数组中的两个元素分别表示当前元素索引和该元素的索引
        }
        for (int i = 0; i < s.length(); i++) {//只需要对s进行一次遍历即可
            char temp = s.charAt(i);//记录当前s的字符
            Queue<int[]> queue = queues[temp-'a'];//找到所有含有此元素的字符串（即某一个数组队列）
            int size = queue.size();//记录当前队列中的字符串的个数
            while (size>0){//对words中的所有元素含有s【i】的字符串进行操作
                int[] sites = queue.poll();
                int index = sites[1];
                if (words[sites[0]].length()==index+1) count++;//表示此字符串的索引已经走到了最后的位置
                else {
                    index++;
                    queues[words[sites[0]].charAt(index)-'a'].offer(new int[]{sites[0],index});
                }
                size--;
            }
        }
        return count;
    }
    //方法三 二分查找(加快每轮循环中对s中索引的移动速度)
    public static int numMatchingSubseq2(String s, String[] words) {
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; ++i) {
            pos[i] = new ArrayList<>();
        }
        for (int i = 0; i < s.length(); ++i) {
            pos[s.charAt(i) - 'a'].add(i);
        }
        int res = words.length;
        for (String w : words) {
            if (w.length() > s.length()) {
                --res;
                continue;
            }
            int p = -1;
            for (int i = 0; i < w.length(); ++i) {
                char c = w.charAt(i);
                if (pos[c - 'a'].isEmpty() || pos[c - 'a'].get(pos[c - 'a'].size() - 1) <= p) {
                    --res;
                    break;
                }
                p = binarySearch(pos[c - 'a'], p);
            }
        }
        return res;
    }
    // 寻找第一个大于target的元素
    public static int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return list.get(left);
    }



    public static void main(String[] args) {
        System.out.println(numMatchingSubseq("abcde",new String[]{"a","bb","acd","ace"}));
        System.out.println(numMatchingSubseq("dsahjpjauf",new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"}));
        System.out.println(numMatchingSubseq1("abcde",new String[]{"a","bb","acd","ace"}));
        System.out.println(numMatchingSubseq1("dsahjpjauf",new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"}));
        System.out.println(numMatchingSubseq2("abcde",new String[]{"a","bb","acd","ace"}));
        System.out.println(numMatchingSubseq2("dsahjpjauf",new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"}));
    }

}

