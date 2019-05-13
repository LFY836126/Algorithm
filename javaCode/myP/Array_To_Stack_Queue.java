package myP;

public class Array_To_Stack_Queue {
    public static class ArrayStack{
        private Integer [] arr;
        private Integer size;

        /*判断数组长度是否正确*/
        public ArrayStack(int initsize){
            if(initsize < 0){
                throw new IllegalArgumentException("The init size is less than 0");
            }
            /*初始化数组*/
            arr = new Integer[initsize];
            /*size是当前可以放东西的位置，可以看作是空的*/
            size = 0;
        }
        /*返回栈顶存的东西*/
        public Integer peek(){
            if(size == 0){
                return null;
            }
            return arr[size - 1];
        }
        /*向当前位添加*/
        public void push(int obj){
            if(size == arr.length ){
                throw new ArrayIndexOutOfBoundsException("This queue is full");
            }
            arr[size++] = obj;
        }
        /*弹出栈顶位置的元素*/
        public Integer pop(){
            if(size == 0){
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            return arr[--size];
        }
    }
    public static class ArrayQueue{
        private Integer [] arr;
        private Integer size;
        private Integer last;
        private Integer start;
        public ArrayQueue(int initsize){
            if(initsize < 0){
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initsize];
            /*size表示我还没有没有空间放东西，就是数组满没满*/
            size = 0;
            /*last表示我当前位置可以放东西。可以当作原本是空的*/
            last = 0;
            /*指向当前栈顶元素*/
            start = 0;
        }
        public void push(int obj){
            if(size == arr.length){
                throw new ArrayIndexOutOfBoundsException("This queue is full");
            }
            size ++;
            arr[last] =obj;
            last = last == arr.length -1 ? 0: last + 1;
        }
        public Integer poll(){
            if(size == 0){
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            size --;
            int tmp = start;
            start = start == arr.length ? 0 : start + 1;
            return arr[tmp];
        }
    }
    public static void main(String[] args) {

    }
}
