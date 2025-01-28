public class ArrayFullException extends Exception {
    <E> ArrayFullException(E n) {
        super("The array is full and " + n + " cannot be inserted.");
    }
}
