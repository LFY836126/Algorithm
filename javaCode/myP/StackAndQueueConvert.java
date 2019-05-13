package myP;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueueConvert {
    /*用两个队列来实现栈结构
    栈：push和pop
    队列：push和poll
    */
    public static class TwoQueuesStack{
        private Queue<Integer>queue;
        private Queue<Integer>help;
        public TwoQueuesStack() {
            queue = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }
        public void push(int pushInt){
            queue.add(pushInt);
        }
        public int pop(){
            if(queue.isEmpty()){
                throw new RuntimeException("Stack is empty!");
            }
            /*只要是不剩最后一个，我就一直把queue中的内容倒到help中*/
            while(queue.size() > 1){
                help.add(queue.poll());
            }
            /*我得先在这里存一下最后的结果，以便最后返回，不能直接返回，要不然就没法执行交换的操作了*/
            int res = queue.poll();
            /*交换，help变为queue，queue变为空的help队列,改变两个引用*/
            swap();
            return res;
        }
        public void swap(){
            Queue<Integer>tmp = queue;
            queue = help;
            help = tmp;
        }
    }
    public static class TwoStacksQueue{
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;
        public TwoStacksQueue(){
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }
        public void  push(int pushInt){
            stackPush.push(pushInt);
            /*dao();随时随地都可以发生倒数据行为，只要满足了那两个条件*/
        }
        public int poll(){
            if(stackPop.isEmpty()&&stackPush.isEmpty()){
                throw new RuntimeException("Queue is empty!");
            }
            dao();
            return stackPop.pop();
        }
        public void dao(){
            /*倒的过程两个注意点：
            1.pop中得为空，不为空直接返回，倒不了
            2.push得一次性倒完，什么时候倒完什么时候停止，
            只要满足这两个条件什么时候都能发生倒数据行为，随时都可以！
            */
            if(!stackPop.isEmpty()){
                return;
            }
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
    }
}