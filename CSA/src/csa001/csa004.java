package csa001;

import java.util.ArrayList;
import java.util.List;
public class csa004 {
    public static void main(String[] args) {
        Fanzhuan fan = new Fanzhuan();
        System.out.println(fan.sl(-120));
        System.out.println();
        Palou palou = new Palou();
        System.out.println(palou.sl(5));
        System.out.println();
        Ziji zj = new Ziji();
        int[] nums ={1,2,3,4,5,6};
        System.out.println(zj.subsets(nums));
    }
}
class Fanzhuan {
    public int sl( int x){
        int temp =0;
        while(x!=0){
            int num =x%10;
            x=x/10;
            temp = temp*10+num;
        }
        return temp;
    }
}
class Palou{
    public int sl(int n){
        if(n==1||n==2){
            return n;
        }else{
            return sl(n-1)+sl(n-2);
        }
    }
}
class Ziji {
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {
            t.clear();
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<Integer>(t));
        }
        return ans;
    }
}

