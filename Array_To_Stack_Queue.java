package zuochengyun_123;

public class Array_To_Stack_Queue {
    public static class ArrayStack{
        private Integer[] arr;
        private Integer size;
        public ArrayStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
        }

        //返回栈顶元素
        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[size - 1];
        }

        //入栈
        public void push(int obj){
            if (arr.length == size) {
                throw new ArrayIndexOutOfBoundsException("The stack is full");
            }
            arr[size++] = obj;
        }

        //弹出栈顶元素，并返回栈顶元素
        public Integer pop() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The stack is empty");
            }
            return arr[--size];
        }
    }

    public static class ArrayQueue{
        private Integer[] arr;
        private Integer size;
        private Integer first;
        private Integer last;

        public ArrayQueue(int initSize){
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
            first = 0;
            last = 0;
        }

        //返回第一个进队列的元素
        public Integer peek (){
            if (size == 0) {
                return null;
            }
            return arr[first];
        }

        //入队
        public void push(int obj) {
            if (arr.length == size) {
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            size++;
            arr[last] = obj;
            last = last == arr.length - 1 ? 0 : last + 1;
        }

        //弹出队列第一个进入的元素并返回
        public Integer pop() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            size--;
            int temp = first;
            first = first == arr.length - 1 ? 0 : first + 1;
            return arr[temp];
        }
    }

}
