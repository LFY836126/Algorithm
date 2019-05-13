package myP;
import java.util.Arrays;

public class Merge {
    public static void mergesort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        mergesort(arr, 0, arr.length-1);
    }
    public static void mergesort(int[] arr, int l, int r){
        if(l == r){
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergesort(arr, l, mid);
        mergesort(arr, mid + 1, r);
        merge(arr, l, r, mid);
    }
    public static void merge(int arr[], int l, int r, int m){
        int i = 0;
        int p1 = l;
        int p2 = m+1;
//        生成辅助数组
        int[] help = new int[r - l + 1];
        while(p1 <= m && p2 <= r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= m){
            help[i++] = arr[p1++];
        }
        while(p2 <= r){
            help[i++] = arr[p2++];
        }
        for(int j= 0; j < help.length; j ++){
            arr[l + j] = help[j];
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String [] args){
        int[] arr = {4 , 2 , 1, 3};
        mergesort(arr);
        System.out.println(Arrays.toString(arr));
    }
}