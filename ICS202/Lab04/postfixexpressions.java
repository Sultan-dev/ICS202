import java.util.Scanner;

public class postfixexpressions {

    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner kb = new Scanner(System.in);

        System.out.println("Please enter an expression: ");
        String exp = kb.nextLine();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isDigit(c)) {// if it is a digit
                stack.push(c);
                System.out.println("push " + c + "\n" + stack.toString());

            } else if (c == '+' || c == '-' || c == '*' || c == '/') {// if it is an operator
                int num1 = Integer.parseInt(String.valueOf(stack.pop()));
                int num2 = Integer.parseInt(String.valueOf(stack.pop()));

                if (c == '+') {// if it is addition
                    int result = num2 + num1;
                    System.out.println("apply the operation to (" + num2 + "+" + num1 + "= " + result + ")");
                    stack.push(result);
                    System.out.println(stack.toString());

                } else if (c == '-') {// if it is subtraction
                    int result = num2 - num1;
                    System.out.println("apply the operation to (" + num2 + "-" + num1 + "= " + result + ")");
                    stack.push(result);
                    System.out.println(stack.toString());

                } else if (c == '*') {// if it is multiplication
                    int result = num2 * num1;
                    System.out.println("apply the operation to (" + num2 + "*" + num1 + "= " + result + ")");
                    stack.push(result);
                    System.out.println(stack.toString());

                } else if (c == '/') {// if it is division
                    int result = num2 / num1;
                    System.out.println("apply the operation to (" + num2 + "/" + num1 + "= " + result + ")");
                    stack.push(result);
                    System.out.println(stack.toString());

                }
            }
        }

        System.out.println("The result of this expression = " + stack.pop());

    }
}
