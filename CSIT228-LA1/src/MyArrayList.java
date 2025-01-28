public class MyArrayList <E> {
    private static final int capacity = 5;
    private int _size;
    private E[] array;
    MyArrayList() {
        _size = 0;
        array = (E[]) new Object[capacity];
    }
    void add(E n) throws ArrayFullException {
        try {
            array[_size++] = n;
        } catch (Exception e) {
            throw new ArrayFullException(n);
        }
    }
    void addAt(E n, int pos) throws InvalidPositionException, ArrayFullException {
        if (pos < 1 || pos - 1 > _size) {
            throw new InvalidPositionException(_size + 1);
        }

        if (_size >= capacity) {
            throw new ArrayFullException(n);
        }

        for (int i = _size; i >= pos; i--) {
            array[i] = array[i - 1];
        }

        array[pos - 1] = n;

        _size++;
    }

    boolean remove(E n) {
        for (int i = 0; i < _size; i++) {
            if (array[i] == n) {
                for (int j = i; j < _size - 1; j++) {
                    array[j] = array[j + 1];
                }
                _size--;
                return true;
            }
        }
        return false;
    }

    E removeAt(int pos) throws InvalidPositionException {
        if (pos < 1 || pos - 1 >= _size) {
            throw new InvalidPositionException(_size);
        }

        E n = array[pos - 1];
        for (int i = pos - 1; i < _size - 1; i++) {
            array[i] = array[i + 1];
        }

        _size--;

        return n;
    }

    boolean contains(E n) {
        for (int i = 0; i < _size; i++) {
            if (array[i] == n) {
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

    E get(int pos) throws InvalidPositionException {
        if (pos < 1 || pos > _size) {
            throw new InvalidPositionException(_size);
        }

        return array[pos - 1];
    }

    E set(int pos, E n) throws InvalidPositionException {
        if (pos < 1 || pos - 1 >= _size) {
            throw new InvalidPositionException(_size);
        }
        E e = array[pos - 1];
        array[pos - 1] = n;
        return e;
    }
    <A, C> void print(A a, C c) {
        for (int i = 0; i < _size; i++) {
            System.out.println(a + " " + array[i] + " " + c);
        }
    }
}
