public class Exception1 extends Exception {
    final static String DEFAULT_OVERLAP_EXCEPTION = "Найдено пересечение";

    public Exception1(String errorMessage) {
        super(errorMessage);
    }
}