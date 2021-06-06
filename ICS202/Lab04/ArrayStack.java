import java.util.EmptyStackException;

public class ArrayStack {

    private Object[] array;
    private int size;

    public ArrayStack() {
        this(100);

    }

    public ArrayStack(int size) {
        this.size = size;
        array = new Object[size];

    }

    public boolean isEmpty() {
        return array[0] == null;

    }

    public void clear() {

        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }

    }

    public void push(Object el) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = el;
                break;
            }
        }

    }

    public Object pop() {
        Object obj = null;

        if (!isEmpty()) {
            for (int i = 0; i < array.length; i++) {
                if (i == (array.length - 1)) {
                    obj = array[i];
                    array[i] = null;
                    break;
                }
            }
        }else{
            throw new EmptyStackException();
        }

        return obj;
    }

    public Object topEl() {
        Object obj = null;
        if (!isEmpty()) {
            for (int i = 0; i < array.length; i++) {
                if (array[i+1] == null) {
                    obj = array[i];
                    break;
                }
            }
        }else{
            throw new EmptyStackException();
        }

        return obj;
    }

    public void printAll() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public int getSize(){
        return array.length;
    }

}
