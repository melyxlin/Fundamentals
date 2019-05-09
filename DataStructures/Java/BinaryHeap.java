import java.util.Arrays;

public class BinaryHeap<T extends Comparable<T>> {
    private static final int DEFAULT_CAPACITY = 10;
    public T[] array;
    public int size;

    public BinaryHeap() {
        array = (T[]) new Comparable[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(T value) {
        if (size >= array.length - 1) {
            array = this.resize();
        }
        size++;
        int index = size;
        array[index] = value;

        bubbleUp();

    }

    public T remove() {
        T returnVal = this.peek();
        array[1] = array[size];
        array[size] = null;
        size--;

        bubbleDown();
        return returnVal;

    }

    public T peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        } else {
            return array[1];
        }
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public void swap(int index1, int index2) {
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    public T[] resize() {
        return Arrays.copyOf(array, array.length * 2);
    }

    public void bubbleDown() {
        int index = 1;
        while (hasLeftChild(index)) {
            int smallerChild = leftIndex(index);
            if (hasRightChild(index) && array[leftIndex(index)].compareTo(array[rightIndex(index)]) > 0) {
                smallerChild = rightIndex(index);
            }
            if (array[index].compareTo(array[smaller])) {
                swap(index, smallerChild);
            } else {
                break;
            }
            index = smallerChild;
        }
    }

    public void bubbleUp() {
        int index = this.size;
        while (hasParent(index)) {
            if (array[parentIndex(index)].compareTo(array[index]) > 0) {
                swap(parentIndex(index), index);
            }
            index = parentIndex(index);
        }
    }

    public boolean hasParent(int index) {
        if (index > 1) {
            return true;
        }
        return false;
    }

    public int leftIndex(int index) {
        return index * 2;
    }

    public int rightIndex(int index) {
        return index * 2 + 1;
    }

    public boolean hasLeftChild(int index) {
        if (leftIndex(index) <= size) {
            return true;
        }
        return false;
    }

    public boolean hasRightChild(int index) {
        if (rightIndex(index) <= size) {
            return true;
        }
        return false;
    }

    public T parent(int index) {
        return array(parentIndex(index));
    }

    public int parentIndex(int index) {
        return index / 2;
    }

}