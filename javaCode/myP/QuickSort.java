package myP;

import java.util.Arrays;

public class QuickSort {
    public static void quicksort(int[] arr){
        if(arr == null || arr.length < 2){
            return ;
        }
        quicksort(arr, 0, arr.length-1);
    }
    public static void quicksort(int[] arr, int l, int r){
        if(l < r){
            int[] p = partition(arr, l, r);
            quicksort(arr, l, p[0] - 1);
            quicksort(arr, p[1] + 1, r);
        }
    }
    public static int[] partition(int[] arr, int l, int r){
        swap(arr , (int)(Math.random() * (r - l + 1)) + l, r);
        int less = l - 1;
        int more = r;
        int cur = l;
        while(cur < more){
            if(arr[cur] < arr[r]){
                swap(arr , ++less, cur++);
            }
            else if(arr[cur] > arr[r]){
                swap(arr , --more, cur);
            }
            else{
                cur ++;
            }
        }
        swap(arr, r, more);
        return new int[]{ less + 1, more};
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args){
        int[] arr = {3, 6, 2, 5, 4, 3, 2};
        quicksort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
