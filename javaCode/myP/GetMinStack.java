package myP;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class GetMinStack {
    public static class MyStack{
        /*两个栈，一个是数据栈，一个是存放最小值的那个栈（栈顶位置的数一定是最小的）*/
        private Stack<Integer>stackData;
        private Stack<Integer>stackMin;
        public MyStack(){
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }
        /*将新进来的数与stackMin的栈顶进行比较，要是小于或者等于，那在stackMin中也push newNum*/
        public void push(int newNum){
         if(this.stackMin.isEmpty()) {
             this.stackMin.push(newNum);
         }else if(newNum <= this.getMin()){
             this.stackMin.push(newNum);
         }
         /*不管如何，最终的stackData中肯定是要push新的数的*/
         this.stackData.push(newNum);
        }
        /*弹出数，要是弹出的数等于stackMin中栈顶的数，那就一起都带走，就是两个都弹出*/
        public int pop(){
            if(this.stackData.isEmpty()){
                throw new RuntimeException("Your stack is empty.");
            }
            int value = this.stackData.pop();
            if(value == this.getMin()){
                this.stackMin.pop();
            }
            return value;
        }
        /*得到stackMin这个栈 栈顶的位置*/
        public int getMin(){
            if(this.stackMin.isEmpty()){
                throw new RuntimeException("Your stack is empty.");
            }
//            只得到数值，不弹出
            return this.stackMin.peek();
        }
    }
    public static void main(String [] args){
        MyStack stack = new MyStack();
        stack.push(3);
        stack.push(4);
        stack.push(1);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}
