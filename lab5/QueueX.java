public class QueueX {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public QueueX(int i){
        maxSize = i;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(long i){
        if(rear == maxSize-1) {
            rear = -1;
        }
        queArray[++rear] = i;
        nItems++;

    }

    public long remove(){
        long temp = queArray[front++];
        if(front == maxSize) {
            front = 0;
        }
        nItems--;

        return temp;
    }

    public long peekFront(){
        return queArray[front];
    }

    public boolean isEmpty(){
        return (nItems == 0);
    }

    public boolean isFull(){
        return (nItems == maxSize);
    }

    public int getSize(){
        return nItems;
    }
}
