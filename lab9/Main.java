import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

 public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);
     int size;

     System.out.println("Введите размер массива");
     size = sc.nextInt();

    int[] num = new int[size];
    for(int i = 0; i < size; i++){
        System.out.println("Введите число");
        num[i] = sc.nextInt();
    }

     System.out.println("\n" + "Неотсортированный массив");

    for( int a : num) {System.out.print(a + " ");}

     System.out.println("\n" + "Отсортированный массив");

    radixsort(num);

    for (int h : num)
    System.out.print(h + " ");
    }

    public static void radixsort(int[] input) {

        List<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
        buckets[i] = new ArrayList<Integer>();
        }

        // sort
        boolean flag = false;
        int tmp = -1, divisor = 1;
            while (!flag) {
                flag = true;
                // split input between lists
                for (Integer i : input) {
                    tmp = i / divisor;
                    buckets[tmp % 10].add(i);
                    if (flag && tmp > 0) {
                        flag = false;
                    }
                }
                // empty lists into input array
                int a = 0;
                for (int b = 0; b < 10; b++) {
                    for (Integer i : buckets[b]) {
                        input[a++] = i;
                    }
                    buckets[b].clear();
                }
                // move to next digit
                divisor *= 10;
            }
        }
}