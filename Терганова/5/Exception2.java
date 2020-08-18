public class Exception2 extends Exception {
    final static String DEFAULT_READONLY_MESSAGE = "Невозможно добавить параметр - элемент выключен";

    public Exception2(String errorMessage) {
        super(errorMessage);
    }
}