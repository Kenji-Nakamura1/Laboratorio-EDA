import java.util.LinkedList;
import java.util.Queue;

public class PilaConFila<T> {

    private Queue<T> cola;

    public PilaConFila() {
        cola = new LinkedList<>();
    }


    public void push(T item) {
        cola.add(item);


        int size = cola.size();
        int i = 0;
        while (i < size - 1) {
            cola.add(cola.remove());
            i++;
        }
    }


    public T pop() {
        if (isEmpty()) return null;
        return cola.remove();
    }


    public T peek() {
        if (isEmpty()) return null;
        return cola.peek();
    }

    public boolean isEmpty() {
        return cola.isEmpty();
    }

    public int size() {
        return cola.size();
    }
}




