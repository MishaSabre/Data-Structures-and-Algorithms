import java.lang.reflect.Array;

public class StackX {
    private int maxSize;
    private long[] stackArray;
    private int top;

    public StackX(int i){
        maxSize = i;
        stackArray = new long[maxSize];
        top = -1;
    }

    public void push(long i){
        if(!this.isFull()) {
            stackArray[++top] = i;
        }else System.out.println("Can't insert, stack is full");
    }

    public long pop(){
        return stackArray[top--];
    }

    public long peek(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (top == maxSize-1);
    }
}
