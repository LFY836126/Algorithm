package myP;
import java.util.Arrays;
/**
 * Created by LFY on 2018/11/14.
**/
// 就像自己手里攥了好多牌，攥的牌是已经排好的，但是新抓了一张牌，这张牌就看能滑到哪个位置上插进去
//    时间复杂度O(N^2)，额外空间复杂度O(1)
public class InsertSort {
    public static void insertsort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            for(int j = i - 1;j >= 0 && arr[j+1] < arr[j]; j--){
                swap(arr, j, j+1);
            }
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String [] args){
        int[] arr = {5, 3, 2, 4, 1};
        insertsort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
