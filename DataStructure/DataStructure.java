package DataStructure;

public interface DataStructure<T> {
    default void push(T key) {
        // functional interface
    };

    default void pop() {
        // functional interface
    };

    default T front() {
        return null;
        // functional interface
    };

    default T at() {
        return null;
        // functional interface
    }

    public boolean empty();
}
