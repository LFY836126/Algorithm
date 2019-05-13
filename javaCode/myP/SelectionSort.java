package myP;
import java.util.Arrays;
/**
 * Created by LFY on 2018/11/14.
 */
//0到n-1上最小的数和0位置上交换，1到n-1上最小的数和1位置上交换，以此类推
// 时间复杂度O(N^2)额外空间复杂度O(1)
public class SelectionSort {
    public static void selectsort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int minIndex = i;
            for(int j = i + 1; j <arr.length; j ++ ){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String [] args){
        int[] arr = {3, 5, 2, 4, 1};
        selectsort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
