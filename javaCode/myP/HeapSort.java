package myP;
import java.util.Arrays;

public class HeapSort {
    public static void heapsort(int[] arr){
        if(arr == null || arr.length < 2){
            return ;
        }
        /*建立大根堆的过程·*/
        for(int i = 0; i < arr.length; i++){
            heapInsert(arr , i);
        }
        int heapsize = arr.length;
        /*将大根堆的头部与末尾的数进行交换，然后将换来的数一点一点往下沉，找到合适的位置，重新建立大根堆heapify*/
        swap(arr, 0, --heapsize);
        while(heapsize > 0){
            heapify(arr, 0, heapsize);
            swap(arr, 0, --heapsize);
        }
    }
    /*小值往下扎*/
    public static void heapify(int[] arr, int index, int heapsize){
        int left = index * 2 + 1;
        while(left < heapsize){
//            largest就是记录我左右孩子中较大的数的位置
//            这句话的意思就是只有你左右孩子都在，并且不越界，并且右孩子的值比左孩子大，才会作为largest的取到的坐标值出现，否则的话就是左孩子
            int largest = left + 1 < heapsize && arr[left + 1] > arr[left] ? left + 1:left;
//            左右两个孩子之间的最大值和我之间哪个值大，哪个坐标就作为largest的值出现
            largest = arr[index] > arr[largest] ? index : largest;
//            当值还是我最大，那么什么都不变
            if(largest == index){
                break;
            }
//           我的值小，交换我和较大孩子的值
            swap(arr , index ,largest);
//            将我的坐标和较大孩子的坐标交换，然后继续判断我要不要继续往下沉
            index = largest;
            left = index * 2 + 1;
        }
    }
    /*建立大根堆，大值往上跑*/
    public static void heapInsert(int[] arr, int index){
//        即使当index = 0的时候， -1/2也等于0
        while(arr[index] > arr[( index - 1 ) / 2]){
            swap(arr, index, ( index - 1 ) / 2);
            index = (index - 1) / 2;
        }
    }
    public static void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args){
//        int[] arr = {1, 2, 4, 6, 3, 5, 8};
        int[] arr = {6, 3, 1, 5, 2};
        heapsort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
