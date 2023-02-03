import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int i;
        int k;
        int m;
        double sum = 0;
        System.out.println("Введите количество строк в 1 матрице");
        i = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите количество столбцов в 1 матрице и количество строк во 2");
        k = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите количество столбцов в 2 матрице");
        m = Integer.parseInt(scanner.nextLine());
        LinkList[] matrix = new LinkList[i];
        LinkList[] matrix1 = new LinkList[k];
        LinkList[] ans = new LinkList[i];
        for (int a = 0; a < matrix.length; a++){
            matrix[a] = new LinkList();
        }
        for (int a = 0; a < matrix1.length; a++){
            matrix1[a] = new LinkList();
        }
        for (int a = 0; a < ans.length; a++){
            ans[a] = new LinkList();
        }

        for(int a = 0; a < i; a++){
            System.out.println("Введите " + a + 1 + " строку в обратном порядке");
            for (int b = 0; b < k; b++){
                matrix[a].insertFirst(b, Double.parseDouble(scanner.nextLine()));
            }
        }
        for(int a = 0; a < k; a++){
            System.out.println("Введите " + a + 1 + " строку в обратном порядке");
            for (int b = 0; b < m; b++){
                matrix1[a].insertFirst(b, Double.parseDouble(scanner.nextLine()));
            }
        }

        for (int a = 0; a < i; a++){
            for (int b = 0; b < m; b++) {
                for (int j = 0; j < k; j++) {

                    Elem current = matrix[a].getFirst();
                    Elem current1 = matrix1[j].getFirst();


                    if(j > 0) current = current.next;

                    if(b > 0) current1 = current1.next;

                    sum += current.dData * current1.dData;

                    if (j + 1 == k) {
                        ans[a].insertFirst(b, sum);
                    }
                }

                sum = 0;
            }
        }
        for (LinkList a : ans) a.displayList();


    }

    public void insertMat(LinkList[] matr, int a, int b){
        matr[a].insertFirst(matr[a].length()-1,b);

    }

    public void deleteMat(LinkList[] matr, int a){
        matr[a].deleteFirst();
    }
}
