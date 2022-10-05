package DataStructure;

public class HashMap<V, T> implements DataStructure<Pair<V, T>> {

    private class HashNode<V, T> {
        V key;
        T value;
        final int hashCode;

        HashNode<V, T> next;

        public HashNode(V key, T value, int hashCode) {
            this.hashCode = hashCode;
            this.key = key;
            this.value = value;
        }
    }

    private @Override public boolean empty() {
        // TODO Auto-generated method stub
        return false;
    }

    public T at() {

    }
}
