package myP;
import java.util.Arrays;

public class NetherlandsFlag {
    public static void partition(int[] arr, int num ,int L, int R){
//        三个变量
//        less: 存储小于区域的最后一个位置
//        more：存储大于区域的第一个位置
//        cur：当前位置

        int less = L -1;
        int more = R + 1;
        int cur = L;
        while(cur < more){
            if(arr[cur] < num){
                swap(arr, cur++, ++less);
            }
            else if(arr[cur] > num){
                swap(arr, cur, --more);
            }
            else{
                cur ++;
            }
        }
    }
    public static void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String [] args){
        int num = 5;
        int[] arr = {10, 9, 8, 5, 7, 6, 5, 4, 3, 2, 1};
        partition(arr, num, 0, 10);
        System.out.println(Arrays.toString(arr));
    }
}
