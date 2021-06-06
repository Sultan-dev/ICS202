public class ReverseTheOrder {

    public static void main(String[] args) {

        Stack stack = new Stack();

        for (int i = 1; i <= 10; i++) {
            stack.push(i);
        }

        System.out.println(stack.toString());

        Queue queue = new Queue();

        for (int i = 1; i <= 10; i++) {
            queue.enqueue(stack.pop());
        }

        System.out.println(queue.toString());
    }
}
