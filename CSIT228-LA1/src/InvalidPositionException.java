public class InvalidPositionException extends RuntimeException {
    InvalidPositionException(int num) {
        super("Position must be between 1 and " + num);
    }
}
