import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Boolean isWork = true;
        StackX stack = null;


        while (isWork) {
            System.out.println(
                    "1 - Create stack \n" +
                            "2 - Push value to stack \n" +
                            "3 - Take element from head \n" +
                            "4 - Check value of head element \n" +
                            "5 - Is stack empty? \n" +
                            "6 - Is stack full?\n"+
                            "7 - Exit"
            );
            String temp = scanner.nextLine();
            switch (temp) {
                case "1":
                    System.out.println("Enter size of stack");
                    temp = scanner.nextLine();
                    stack = new StackX(parseInt(temp));
                    temp ="";
                    break;
                case "2":
                    if (stack == null ) {
                        System.out.println("Stack is null or empty");
                    } else {
                        System.out.println("Enter value or empty");
                        long i = scanner.nextLong();
                        stack.push(i);
                    }
                    temp ="";
                    break;
                case "3":
                    if (stack == null || stack.isEmpty()) {
                        System.out.println("Stack is null or empty");
                    } else {
                        System.out.println(stack.pop());
                    }
                    temp ="";
                    break;
                case "4":
                    if (stack == null || stack.isEmpty()) {
                        System.out.println("Stack is null or empty");
                    } else {
                        System.out.println(stack.peek());
                    }
                    temp ="";
                    break;
                case "5":
                    if (stack == null) {
                        System.out.println("Stack is null or empty");
                    } else {
                        System.out.println(stack.isEmpty());
                    }
                    temp ="";
                    break;
                case "6":
                    if (stack == null) {
                        System.out.println("Stack is null or empty");
                    } else {
                        System.out.println(stack.isFull());
                    }
                    temp ="";
                    break;
                case "7":
                    isWork = false;
                    break;
            }
        }
    }
}
