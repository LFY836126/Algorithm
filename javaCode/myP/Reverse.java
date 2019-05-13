package myP;
import java.util.Arrays;

public class Reverse {
    public static void reverse(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        mergesort(arr, 0, arr.length -1);
    }
    public static void mergesort(int[] arr, int l, int r){
        if(l == r){
            return;
        }
        /*注意右移必须加括号，要不会报错*/
        int mid = l + ((r - l)>>1);
        mergesort(arr, l, mid);
        mergesort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }
    public static void merge(int[] arr, int l, int m, int r){
        int p1 = l;
        int p2 = m + 1;
        int res = 0;
        int i= 0;
        /*这里的长度也要根据传进来的数判断，不能生成随便长度的数组*/
        int[] help = new int[r - l + 1];
        while(p1 <= m && p2 <= r){
            res += arr[p2] < arr[p1] ? ( m - p1 + 1) : 0;
            while(res > 0){
                System.out.println("[" + arr[p1 + res -1 ] + "," + arr[p2] + "]");
                res --;
            }
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1<=m){
            help[i++] = arr[p1++];
        }
        while(p2 <= r){
            help[i++] = arr[p2++];
        }
        /*这里注意是help.length和arr[l+j]，不能写j，万一参数是2或者3什么的，这里的差别就很明显了，因为每次传进来的参数不一样，长度就有可能不一样，*/
        for(int j =0;j < help.length;j++){
            arr[l+j] = help[j];
        }
    }
    public static void main(String [] args){
        int[] arr = {2, 1, 5, 4, 3};
        reverse(arr);
    }
}
