public class DequeX {
    private int maxSize;
    private long[] queArray;
    private int nItems;

    public DequeX(int i){
        maxSize = i;
        queArray = new long[maxSize];
        nItems = 0;
    }

    public void insert(long i){
        int j;
        if(nItems == 0){
            queArray[nItems++] = i;
        }else {
            for(j=nItems-1; j>=0; j--){
                if (i > queArray[j]){
                    queArray[j+1] = queArray[j];
                }else{
                    break;
                }
                queArray[j+1] = i;
                nItems++;
            }
        }
    }

    public long remove(){
        return queArray[--nItems];
    }

    public long peekMin(){
        return queArray[nItems-1];
    }

    public boolean isEmpty(){
        return (nItems==0);
    }
    public boolean isFull(){
        return (nItems == maxSize);
    }
}
