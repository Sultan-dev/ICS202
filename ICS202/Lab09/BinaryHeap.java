import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class BinaryHeap {
    protected Comparable array[];
    int count;

    public BinaryHeap(int i) {
        array = new Comparable[i + 1];
    }

    public BinaryHeap(Comparable[] comparable) {
        this(comparable.length);

        for (int i = 0; i < comparable.length; i++)
            array[i + 1] = comparable[i];

        count = comparable.length;

        // buildHeapTopDown();
        buildHeapBottomUp();
    }

    private void buildHeapBottomUp() {
        Comparable[] tempArray = new Comparable[array.length - 1];
        System.arraycopy(array, 1, tempArray, 0, array.length - 1);
        Arrays.sort(tempArray);
        System.arraycopy(tempArray, 0, array, 1, count);
    }

    private void buildHeapTopDown() {
        Comparable[] tempArray = new Comparable[array.length - 1];
        System.arraycopy(array, 1, tempArray, 0, array.length - 1);

        Arrays.sort(tempArray, Collections.reverseOrder());

        System.arraycopy(tempArray, 0, array, 1, count);

    }


    private void percolateDown(int hole) {
        boolean done = false;
        int i = hole;

        while ((2 * i <= array.length) && !done) {
            i = 2 * i;
            if (i + 1 <= array.length) {


                if ((i + 1 <= array.length) && (array[i + 1].compareTo(array[i]) < 0)) {
                    i = i + 1;
                }
                if (array[i / 2].compareTo(array[i]) > 0) {
                    int el1 = (int) array[i];
                    int el2 = (int) array[i / 2];
                    array[i] = el2;
                    array[i / 2] = el1;
                } else {
                    done = true;
                }
            }
        }
    }

    private void percolateUp(int hole) {
        boolean done = false;
        int i = hole;

        while (!done && (i != 1)) {
            if (array[i].compareTo(array[i / 2]) < 0) {
                int el1 = (int) array[i];
                int el2 = (int) array[i / 2];
                array[i] = el2;
                array[i / 2] = el1;
            } else {
                done = true;
            }
            i = i / 2;
        }
    }


    public void purge() {
        while (count > 0)
            array[count--] = null;
    }

    public void enqueue(Comparable comparable) {
        int hole = ++count;

        // percolate up via a hole
        while (hole > 1 && array[hole / 2].compareTo(comparable) > 0) {
            array[hole] = array[hole / 2];
            hole = hole / 2;
        }

        array[hole] = comparable;
    }

    public Comparable findMin() {
        return array[1];
    }

    public Comparable dequeueMin() {
        Comparable minItem = array[1];
        array[1] = array[count];
        count--;
        percolateDown(1);
        return minItem;
    }

    public Comparable[] heapSort() {
        Comparable[] x = new Comparable[count];
        int total = count;
        for (int i = 0; i < total; i++) {
            x[i] = dequeueMin();
        }
        return x;
    }


    public boolean isFull() {
        return count == array.length - 1;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public String toString() {
        Comparable[] tempArray = new Comparable[array.length - 1];
        System.arraycopy(array, 1, tempArray, 0, array.length - 1);
        return Arrays.toString(tempArray);

    }

    public static void main(String[] args) {
       /* Integer[] a = {10, 2, 8, 9, 1, 6, 3, 4, 0, 5};
        System.out.println("The original array is: " + Arrays.toString(a));
        BinaryHeap bh = new BinaryHeap(a);
        //builds heap bottom up: change the constructor to build it top-down
        System.out.println("\nThe heap is: " + bh);
        System.out.println("\nSorted Array is: " + Arrays.toString(bh.heapSort()));
*/
        Patient<Integer> p1= new Patient<>("Sultan", 1);
        Patient<Integer> p2= new Patient<>("Mohammed", 2);

        System.out.println(p1.compareTo(p2));
    }
}