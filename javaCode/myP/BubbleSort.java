package myP;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by LFY on 2018/11/14.
 */
//每次找最大的数放在后面，范围不断缩小
// 时间复杂度O(N^2)，额外空间复杂度O(1)
public class BubbleSort {
    public static void bubblesort(int [] arr){
        for(int i = arr.length - 1;i > 0 ;i --){
            for(int j = 0; j < i;j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String [] args){
        int[] arr = {4 , 2 , 3 , 1};
        bubblesort(arr);
        System.out.println(Arrays.toString(arr));
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 12);
        map.put("B", 13);
        map.put("c", 14);
        System.out.println(map.containsKey("A"));
        System.out.println(map.get("A"));
    }
}
