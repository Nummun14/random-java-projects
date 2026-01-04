package school;

public class Queue<T> {
    private Node<T> first;
    private Node<T> last;

    public Queue() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public T head() {
        return this.first.getValue();
    }

    public void insert(T x) {
        if (this.isEmpty()) {
            this.first = new Node<T>(x);
            this.last = this.first;
        } else {
            this.last.setNext(new Node<T>(x));
            this.last = this.last.getNext();
        }
    }

    public T remove() {
        T x = this.first.getValue();
        this.first = this.first.getNext();
        return x;
    }

    public String toString() {
        String s = "";
        Node<T> v = this.first;
        while (v != null) {
            s = s + v.getValue();
            v = v.getNext();
        }
        return s;
    }
}