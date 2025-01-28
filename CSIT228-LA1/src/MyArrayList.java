public class MyArrayList {

    private static final int capacity = 5;
    private int _size;
    private int[] array;
    MyArrayList() {
        _size = 0;
        array = new int[5];
    }

    void add(int num) throws ArrayFullException {
        try {
            array[_size++] = num;
        } catch (Exception e) {
            throw new ArrayFullException("Array is full");
        }
    }
    void addAt(int num, int pos) throws InvalidPositionException, ArrayFullException {
        if (pos < 1 || pos - 1 > _size) {
            throw new InvalidPositionException("Invalid position");
        }

        if (_size >= capacity) {
            throw new ArrayFullException("Puno na!");
        }

        for (int i = _size; i >= pos; i--) {
            array[i] = array[i - 1];
        }

        array[pos - 1] = num;

        _size++;
    }

    boolean remove(int num) {
        for (int i = 0; i < _size; i++) {
            if (array[i] == num) {
                for (int j = i; j < _size - 1; j++) {
                    array[j] = array[j + 1];
                }
                _size--;
                return true;
            }
        }
        return false;
    }

    int removeAt(int pos) throws InvalidPositionException {
        if (pos < 1 || pos - 1 >= _size) {
            throw new InvalidPositionException("Invalid position");
        }

        int n = array[pos - 1];
        for (int i = pos - 1; i < _size - 1; i++) {
            array[i] = array[i + 1];
        }

        _size--;

        return n;
    }

    boolean contains(int num) {
        for (int i = 0; i < _size; i++) {
            if (array[i] == num) {
                return true;
            }
        }
        return false;
    }

    int size() {
        return _size;
    }

    boolean isEmpty() {
        return _size == 0;
    }

    int get(int pos) throws InvalidPositionException {
        if (pos < 1 || pos > _size) {
            throw new InvalidPositionException("Invalid position");
        }

        return array[pos - 1];
    }

    int set(int pos, int num) throws InvalidPositionException {
        if (pos < 1 || pos - 1 >= _size) {
            throw new InvalidPositionException("Invalid position");
        }
        int n = array[pos - 1];
        array[pos - 1] = num;
        return n;
    }
}
