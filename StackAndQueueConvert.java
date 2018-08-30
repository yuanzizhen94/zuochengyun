package zuochengyun_123;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
如何仅用队列结构实现栈结构？
如何仅用栈结构实现队列结构？
 */
public class StackAndQueueConvert {

    public static class TwoStackQueue {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStackQueue() {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        public void push(int pushInt) {
            this.stackPush.push(pushInt);
        }

        public int poll() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty");
            } else if (stackPop.empty()) {
                while(!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }

        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty");
            } else if (stackPop.empty()) {
                while(!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }

    public static class TwoQueueStack {
        private Queue<Integer> queue;
        private Queue<Integer> help;

        public TwoQueueStack() {
            queue = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        public void push(int pushInt) {
            queue.add(pushInt);
        }

        //返回队列最后进入的元素
        public int peek() {
            if (queue.isEmpty()) {
                throw new RuntimeException("The stack is empty");
            }
            while (queue.size() != 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
            help.add(res);
            swap();
            return res;
        }

        public int pop() {
            if (queue.isEmpty()) {
                throw new RuntimeException("The stack is empty");
            }
            while (queue.size() > 1) {
                help.add(queue.poll());
            }
            int res = queue.poll();
            swap();
            return res;
        }

        public void swap() {
            Queue<Integer> temp = help;
            help = queue;
            queue = temp;
        }
    }
}
