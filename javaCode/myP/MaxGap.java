package myP;

import java.util.Arrays;
public class MaxGap {
    public static int maxgap(int[] arr){
        if(arr == null || arr.length < 2){
            return 0;
        }
        int len = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++){
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
        }
        if(max == min){
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1];
        int[] mins = new int[len + 1];
        int[] maxs = new int[len + 1];
        int bid = 0;
        for(int i = 0; i < len; i ++){
            bid = bucket(arr[i] , len, min, max);
            mins[i] = hasNum[i] ? mins[i]: arr[i];
            maxs[i] = hasNum[i] ? maxs[i]: arr[i];
            hasNum[i] = true;
        }
        int res = 0;
        int lastIndex = maxs[0];
        for(int i = 1; i < len; i ++){
            if(hasNum[i]){
                res = Math.max(mins[i] - lastIndex, res);
                lastIndex = maxs[i];
            }
        }
        return res;
    }
    public static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }
    public static void main(String[] args){
        int[] arr = {1, 1, 7, 6, 5, 3};
        System.out.println(maxgap(arr));
    }

}
