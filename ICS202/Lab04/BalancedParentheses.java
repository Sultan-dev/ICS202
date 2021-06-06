public class BalancedParentheses {

    public static void main(String[] args) {

        String s = "([3 + (2 – 4) + {(a – b)}]} ";
        boolean flag = false;


        Stack stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));

            } else if (s.charAt(i) == ']' || s.charAt(i) == '}' || s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    flag = false;
                    break;

                } else {
                    char last = (char) stack.pop();

                    if ((s.charAt(i) == ']' && last == '[') || (s.charAt(i) == '}' && last == '{') ||
                            (s.charAt(i) == ')' && last == '(')) {
                        flag = true;

                    } else {
                        flag = false;
                        break;

                    }
                }
            }
        }


        if (flag) {
            if (stack.isEmpty()) {
                System.out.println("The expression is balanced");

            } else {
                System.out.println("The expression is not balanced");

            }
        } else {
            System.out.println("The expression is not balanced");

        }

    }
}
